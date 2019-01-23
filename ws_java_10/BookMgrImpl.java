import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class BookMgrImpl implements IBookMgr {
	private static BookMgrImpl bookMgrImpl;
	private  BookMgrImpl() {}
	public static BookMgrImpl getInstance() {
		if(bookMgrImpl == null) {
			bookMgrImpl = new BookMgrImpl();
		}
		return bookMgrImpl;
	}
	//open - > book.txt에서 읽은 내용을  books로 
	private ArrayList<Book> books = new ArrayList<>();
	

	@Override
	public void add(Book b) {
		if(books.contains(b)) {
			System.out.printf("%s는 이미 존재합니다.\n",b.getIsbn());
		}else {
			books.add(b);
		}	
	}

	@Override
	public List<Book> search() {
		return books;
	}
	private Book findByIsbn(String isbn) {
		Book b = new Book();
		for (int i = 0; i < books.size(); i++) {
			if(books.get(i).getIsbn().equals(isbn)) {
				b = books.get(i);
				break;
			}
		}
		return b;
	}
	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		Book b = findByIsbn(isbn);
		if(b==null) {
			throw new ISBNNotFoundException();
		}
		if(b.getQuantity()-quantity >0) {
			b.setQuantity(b.getQuantity()-quantity);
		}else {
			throw new QuantityException();
		}
		
	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		Book b = findByIsbn(isbn);
		if(b==null) {
			throw new ISBNNotFoundException();
		}
		if(b.getQuantity()-quantity >0) {
			b.setQuantity(b.getQuantity()+quantity);
		}
	}

	@Override
	public int getTotalAmount() {
		int total =0;
		for (int i = 0; i < books.size(); i++) {
			total += books.get(i).getPrice();
		}
		return total;
	}
	

	@Override
	public void open() {
		String fname = "book.txt";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fname));
			String msg ="";
			while((msg=br.readLine())!=null) {
				StringTokenizer st = new StringTokenizer(msg,"|");
				int kind = Integer.parseInt(st.nextToken().trim());
				if(kind ==1) {
					//book
					books.add(new Book(
							st.nextToken().trim(),
							st.nextToken().trim(),
							Integer.parseInt(st.nextToken().trim()),
							Integer.parseInt(st.nextToken().trim())));
				}else {
					//magazine
					books.add(new Magazine(
							st.nextToken().trim(),
							st.nextToken().trim(),
							Integer.parseInt(st.nextToken().trim()),
							Integer.parseInt(st.nextToken().trim()),
							Integer.parseInt(st.nextToken().trim())));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException e) {
			System.out.println("파일을 읽는 도중 예외가 발생했습니다.");
		}
		
	}

	@Override
	public void close() {
		String fname = "book.txt";
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(fname,false),true);
			for (int i = 0; i < books.size(); i++) {
				if(books.get(i) instanceof Magazine) {
					Magazine m = (Magazine) books.get(i);
					String str = "2|";
					str = str+m;
					pw.println(str);
				}else {
					Book m = books.get(i);
					String str = "1|";
					str = str+m;
					pw.println(str);
				}
			}
		} catch (IOException e) {
			System.out.println("파일을 저장하는 도중 예외가 발생했습니다.");
		}finally {
			if(pw!=null) {
				pw.close();
			}
		}
		
		
	}
	public void print() {
		for (Book b : books) {
			System.out.println(b);
		}
	}

}
