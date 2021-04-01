package controller;

import java.awt.print.Book;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductDTO;
import model.ProductService;


@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//이해한거는 그냥 페이지간 연결 관리.......
	
	ProductService service = new ProductService();
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String act = req.getParameter("act");
		String path = "";
		
		if(act==null||act.equals("list")) {
			System.out.println("리스트 보여줘!!!!");
			List<ProductDTO> productList = service.getProducts();
			req.setAttribute("productList", productList);
			path = "/productManage/product_list.jsp";
		}else if(act.equals("addForm")) {
			path = "/productManage/product_add.jsp";
		}else if(act.equals("deleteForm")) {
			path = "/productManage/product_delete.jsp";
		}
		
		RequestDispatcher dispatcher =req.getRequestDispatcher(path);
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		
		String act = req.getParameter("act");
		String path = "";
//		System.out.println("여기 오긴왔니?");
		if(act.equals("add")) {
			path = "/productManage/product_crud_result.jsp";
			//임의의 결과 페이지 생성 => 나중에 작성하기
			System.out.println("추가해줘");
			String id = req.getParameter("id");
			String productname= req.getParameter("productname");
			String entity = req.getParameter("entity");
			String manufacture = req.getParameter("manufacture");
			String price = req.getParameter("price");
			
			ProductDTO product = new ProductDTO(id, productname, Integer.parseInt(entity), manufacture, Integer.parseInt(price));
			System.out.println(product);
			//이 부분 생각 좀만 더 해보기
			
			if(service.add(product)) {
//				req.setAttribute("addResult", "success");
//				System.out.println("리스트 보여줘!!!!");
//				List<ProductDTO> productList = service.getProducts();
//				req.setAttribute("productList", productList);
//				path = "/productManage/product_list.jsp";
//				위의 다섯 줄은  foward 방식 사용
				// 이 부분으로 바로 가게 되면 db에 있는 데이터를 불러오지 못하게 된다.
				// 그러면 무조건 다른페이지로 가야하는 데 그게 효과적인가? 
				// 
//				resp.sendRedirect(req.getContextPath()+"/MainServlet?=list");
				System.out.println("추가됨");
				path="/productManage/add_result.jsp";
			}else {
				// 이 부분이 진짜 고민이 많이 된다.
				// crud에서 r 빼고 만든 페이지로 그냥 다 들고 가서 처리해버리는 게 낫나?????
			}
		}else if(act.equals("delete")) {
//			path = "/productManage/product_crud_result.jsp";
			//임의의 결과 페이지 생성 => 나중에 작성하기
			System.out.println("삭제해줘");
			
			String productname = req.getParameter("deleteproductname");
			
			if(service.delete(productname)) {
				path = "/productManage/product_list.jsp";
				System.out.println("삭제됨");
			}else {
				System.out.println("삭제 안 됐어");
			}
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		dispatcher.forward(req, resp);
		
	}

}
