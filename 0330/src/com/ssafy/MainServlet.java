package com.ssafy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.member.MemberDto;


@WebServlet("/main") //실수한 점 : /main으로 선언
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    public void init() throws ServletException {
		super.init();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }



	//login할 시에 post방식으로 진행해야하지만 url부분을 타고 들어가는 부분을 지정할 수 없으므로 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		String act = request.getParameter("act");
		
		System.out.println(act); //act가 안넘어와 왜????????? login.jsp에서 input type을 hideen으로 했는 데......
		
		if("login".equals(act)) {
			login(request,response);	
		} 
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// id와 password 가져오기
		
		String id = request.getParameter("userid");
		String pwd = request.getParameter("userpwd");
		//주의할 점 여기서 input의 id 값이 아닌 name의 정보이다.
		System.out.println(id+"/"+pwd);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDto memberDto = null;
		
		try {
			System.out.println("여기는 왔니?");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hw0330?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "leejh", "dydak5310!");
			//이 부분 질문하기 새로운 스키마 연결할 때 모르겠음
			String sql = "select username \n";
			sql += "from ssafy_members \n";
			sql += "where username = ? and userpwd = ?";
			//sql문 다시 짜기, table도 새로 생성 정의한 것만 해서
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("여기는 왔구나");
				System.out.println(rs.getString("username"));
				memberDto = new MemberDto();
				memberDto.setUserName(rs.getString("username")); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//autocloseable => 찾아보기
		
		String path = "/product/lastProduct.jsp"; //철자 틀리는 거하고 file명 틀리지 말기, 계속 문제가 됨......
		//마지막 제품이 나올 페이지
		
		
		//이 경우에는 session에 굳이 담을 필요가 있나???? 다음페이지로 이동하는 건데...
		if(memberDto!=null) {
			//일치하는 id가 있을 경우 session 배정
			HttpSession session = request.getSession();
			session.setAttribute("userinfo", memberDto);
		}else {
			request.setAttribute("msg", "회원이 아니거나 비밀번호가 일치하지않습니다.");
			path = "/user/login.jsp";
		}
		
		//dispactcher를 사용하는 이유
		//request의 경우 다음 페이지로 밖에 넘어갈 수 밖에 없기 때문에
		//
		RequestDispatcher disp = request.getRequestDispatcher(path);
		disp.forward(request, response);
		
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
}
