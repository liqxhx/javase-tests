package designmode.producerconsumer.stack;

public class Consumer extends Thread{
	//***************************************************************************************
	private Stack s;
	//***************************************************************************************
	public Consumer(){super();}
	public Consumer(Stack s){
		this.s = s;
	}
	//***************************************************************************************
	@Override
	public void run(){
		for(int i = 0 ; i < 26 ; i++){
			s.pop();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	//***************************************************************************************

	public Stack getS() {
		return s;
	}

	public void setS(Stack s) {
		this.s = s;
	}
}
