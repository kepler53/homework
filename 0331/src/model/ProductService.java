package model;

import java.util.List;

public class ProductService {
	
	//Dao를 조합해서 서비스를 구축하는 클래스
	
	public ProductDao dao = new ProductDao();
	
	
	public List<ProductDTO> getProducts(){
		return dao.selectAll();
	}
	
	public boolean add(ProductDTO product) {
		if (dao.insert(product)==1) {
			return true;
		}
		return false;
	}
	
	public boolean delete(String str) {
		if(dao.delete(str)==1) {
			return true;
		}
		return false;
	}

}
