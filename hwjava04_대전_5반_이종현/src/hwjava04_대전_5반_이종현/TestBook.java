package hwjava04_����_5��_������;

public class TestBook {
	public static void main(String[] args) {
		Book[] books = new Book[2];
		books[0] = new Book("21424", "JavaPro", "���ϳ�", "jaen.kr", 15000, "Java �⺻ ����");
		books[1] = new Book();
		books[1].setIsbn("35355");
		books[1].setTitle("�м�����");
		books[1].setAuthor("�ҳ���");
		books[1].setPublisher("jaen.kr");
		books[1].setPrice(30000);
		books[1].setDesc("SW �𵨸�");

		for (Book book : books) {
			System.out.println(book);
		}
	}
}
