package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

	// sql관리 => 그냥 쿼리 날리는 함수 만드는 곳이라고 생각하기

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 상품 추가
	public int insert(ProductDTO product) {
		int result = 0;

		try {
			conn = DButil.makeConnection();
			String sql = "INSERT INTO PRODUCT_TB(ID,PRODUCTNAME,ENTITY,MANUFACTURE,PRICE) " + "VALUES(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getID());
			pstmt.setString(2, product.getProductName());
			pstmt.setInt(3, product.getEntity());
			pstmt.setString(4, product.getManufacture());
			pstmt.setInt(5, product.getPrice());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("상품 추가에 실패했습니다.");
			e.printStackTrace();
		} finally {
			// 궁금한 점 여기서 autocloseable이라고 했는 데 이 부분을 작성안하여도 되는 건지에 대한 의문점.....
			DButil.close(conn);
			DButil.close(pstmt);
			DButil.close(rs);
		}
		return result;
	}

	// 상품 삭제(primarykey인 이름를 가지고 삭제하기)
	public int delete(String productname) {
		int result = 0;
		try {
			conn = DButil.makeConnection();
			String sql = "DELETE FROM PRODUCT_TB WHERE PRODUCTNAME=?";
			System.out.println(productname);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productname);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("상품 추가에 실패했습니다.");
			e.printStackTrace();
		} finally {
			// 궁금한 점 여기서 autocloseable이라고 했는 데 이 부분을 작성안하여도 되는 건지에 대한 의문점.....
			DButil.close(conn);
			DButil.close(pstmt);
			DButil.close(rs);
		}
		return result;		
	}
	// 모든 상품 목록 조회
	public List<ProductDTO> selectAll(){
		try {
			conn = DButil.makeConnection();
			String sql = "SELECT ID, PRODUCTNAME, ENTITY, MANUFACTURE, PRICE FROM PRODUCT_TB";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			ArrayList<ProductDTO> productList = new ArrayList<>();
			
			while(rs.next()) {
				ProductDTO product = new ProductDTO();
				product.setID(rs.getString(1));
				product.setProductName(rs.getString(2));
				product.setEntity(rs.getInt(3));
				product.setManufacture(rs.getString(4));
				product.setPrice(rs.getInt(5));
				
				productList.add(product);	
			}
			return productList;
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("상품 목록을 불러오는 데 실패했습니다.");
			e.printStackTrace();
		} finally {
			// 궁금한 점 여기서 autocloseable이라고 했는 데 이 부분을 작성안하여도 되는 건지에 대한 의문점.....
			DButil.close(conn);
			DButil.close(pstmt);
			DButil.close(rs);
		}
		return null;
	}

	// 상품명 조회(여러개 있을 수 없지, name도 primary key로 지정해야하나?) 
	public ProductDTO searchByName(String productname) {
		ProductDTO product = new ProductDTO();
		try {
			conn = DButil.makeConnection();
			String sql = "SELECT ID, PRODUCTNAME, ENTITY, MANUFACTURE, PRICE FROM PRODUCT_TB WHERE PRODUCTNAME=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productname);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				product.setID(rs.getString(1));
				product.setProductName(rs.getString(2));
				product.setEntity(rs.getInt(3));
				product.setManufacture(rs.getString(4));
				product.setPrice(rs.getInt(5));
				
			}
			return product;
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("해당 상품이 존재하지않습니다.");
			e.printStackTrace();
		} finally {
			// 궁금한 점 여기서 autocloseable이라고 했는 데 이 부분을 작성안하여도 되는 건지에 대한 의문점.....
			DButil.close(conn);
			DButil.close(pstmt);
			DButil.close(rs);
		}
		return null;
		
	}

	// 가격 이하 조회
	
	// 똑같은 이름의 상품이 들어왔을 때 수량 변경(수량을 제외한 모든 값이 같아야한다.) => 리시트로 다시 뿌려주기

}
