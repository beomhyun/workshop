
public class Magazine extends Book {
	private int month;

	public Magazine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Magazine(String isbn, String title, int price, int quantity,int month) {
		super(isbn, title, price, quantity);
		this.month = month;
	}

	@Override
	public String toString() {
		return isbn + "|" + title + "|" + price + "|" + quantity + "|" + month;
	}
	
}
