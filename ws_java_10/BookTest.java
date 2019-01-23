import java.util.ArrayList;

public class BookTest {

	public static void main(String[] args) {
		BookMgrImpl bookmgr = BookMgrImpl.getInstance();
		bookmgr.open();
		
		bookmgr.print();
		bookmgr.add(new Magazine("828456785","동규's 라이프",2600,10,12));
		try {
			bookmgr.sell("828384653", 7);
			bookmgr.buy("828456782", 3);
		} catch (QuantityException e) {
			System.out.println("책이 부족합니다.");
		} catch (ISBNNotFoundException e) {
			System.out.println("존재하지않는 ISBN입니다.");
		}
		bookmgr.print();
		bookmgr.close();
	}

}
