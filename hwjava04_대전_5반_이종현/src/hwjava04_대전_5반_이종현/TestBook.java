package hwjava04_대전_5반_이종현;

public class TestBook {
	public static void main(String[] args) {
		Book[] books = new Book[2];
		books[0] = new Book("21424", "JavaPro", "김하나", "jaen.kr", 15000, "Java 기본 문법");
		books[1] = new Book();
		books[1].setIsbn("35355");
		books[1].setTitle("분석설계");
		books[1].setAuthor("소나무");
		books[1].setPublisher("jaen.kr");
		books[1].setPrice(30000);
		books[1].setDesc("SW 모델링");

		for (Book book : books) {
			System.out.println(book);
		}
	}
}
