package com.ssafy.product.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.product.service.DBUtil;
import com.ssafy.productdto.ProductDto;


@Repository
public class ProductDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DBUtil util = DBUtil.getInstance();
	
	public void add(ProductDto product) throws SQLException {
		System.out.println(product);
		try {
			conn = util.makeConnection();
			String sql = "insert into product(pid,pname,pprice,pdescription) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getId());
			pstmt.setString(2, product.getName());
			pstmt.setInt(3, product.getPrice());
			pstmt.setString(4, product.getDescription());
			
			pstmt.executeUpdate();
		}  finally {
			util.close(pstmt,conn);
		}
	}
	
	public List<ProductDto> getList() throws SQLException{
		List<ProductDto> pList = new ArrayList<ProductDto>();
		try {
			conn = util.makeConnection();
			String sql = "select pid,pname,pprice,pdescription from product";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ProductDto product = new ProductDto();
				product.setId(rs.getString(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getInt(3));
				product.setDescription(rs.getString(4));
				
				System.out.println(product);
				
				pList.add(product);
			}
		}  finally {
			util.close(pstmt,conn);
		}
		return pList;
	}

}
