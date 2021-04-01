package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import GuestBookDTO.GuestBookDTO;
import GuestBookService.GuestBookServiceImpl;

//뇌가 안돌아간다. 그냥 컨트롤러 하나만 해서 사용하자.....
//list 구현 못하겠음 머리가 안돌아간다......
//dao하고 service에서 list 구현해서  listView에서 setAttribut하고 list.jsp에서 뿌려주기 => 대략적인 개요는 이런데 지금 못짜겟음
//내일 해봐야 할 것 => error page만들기
//EL하고 JSTL제대로 사용하기
//MainServlet Front-controller하고 controller로 나누기
//DButil 소스코드 안보고 구현하기
//equal할 때 안에 act에 "act"이렇게 쓰지 말기 디버깅하다가 어이가 없음
//login한 상태에서 <%@ include file=".jsp"%>로 들고 다니는 거 연습하기
//주말동안에 구현 못한거 다 구현하기
//디비연결하기
//글 삭제할 때 cascade 안되게 설정하기
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String root = request.getContextPath();
		String act = request.getParameter("act");
		
		System.out.println(act);
		//글쓰기 누르면 
		if("writeForm".equals(act)) {
			response.sendRedirect(root + "/guestbook/write.jsp");
		}else if("write".equals(act)) {
			System.out.println("여긴왔니?");
			registerArticle(request, response);
		}else if ("listView".equals(act)) {
			// ArrayList<guestBookDTO> list = 함수;
			//이부분에 request.setAttribute("bookList",list);
			
			response.sendRedirect(root +"/guestbook/list.jsp");
		}else {
			//list.jsp에서 무슨 행동을 하겠지.....이 이후는 머리가 안돌아가서 작성못함.....
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	
	private void registerArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String path = "";
		
			System.out.println("이건 하기 하니");
			GuestBookDTO guestBookDto = new GuestBookDTO();
			
			guestBookDto.setSubject(request.getParameter("subject"));		
			guestBookDto.setContent(request.getParameter("content"));
			
			try {
				GuestBookServiceImpl.getGuestBookService().registerArticle(guestBookDto);
				path = "/index.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글작성 중 문제가 발생했습니다.");
				System.out.println("글작성 중 문제가 발생했습니다. 아마 db 문제, db안만들었어.....");
			}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
