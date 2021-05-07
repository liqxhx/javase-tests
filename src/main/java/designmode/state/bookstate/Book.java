package designmode.state.bookstate;

public class Book {
	private BookState bs ;
	
	public Book(){}
	
	public Book(BookState bs){this.bs = bs ;}
	
	public void borrow(){
		bs = bs.act();
	}
	
	
	public BookState getBs() {
		return bs;
	}

	public void setBs(BookState bs) {
		this.bs = bs;
	}

	public static void main(String[] args){
		Book book = new Book(new FreeState());
		book.borrow() ;
		book.borrow() ;
		book.borrow() ;
		
		
		book.borrow() ;
		book.borrow() ;
		book.borrow() ;
		book.borrow() ;
		
	}
}
