package designmode.state.bookstate;

public class BorrowedState extends BookState {

	@Override
	public BookState act() {
		System.out.println("借书失败,预约成功");
		return new OrderedState();
	}

}
