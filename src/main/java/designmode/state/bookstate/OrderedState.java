package designmode.state.bookstate;

public class OrderedState extends BookState{

	@Override
	public BookState act() {
		System.out.println("借书失败,预约失败");
		return this;
	}

}
