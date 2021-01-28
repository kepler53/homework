
public class ProductNotFoundException extends Exception {

	public ProductNotFoundException() {
		super("해당 조건의 상품은 없습니다.");
	}
}
