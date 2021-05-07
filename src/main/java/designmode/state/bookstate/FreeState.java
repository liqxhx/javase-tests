package designmode.state.bookstate;

public class FreeState extends BookState{

	@Override
	public BookState act() {
		System.out.println("借书成功");
		return new BorrowedState();
	}

}
