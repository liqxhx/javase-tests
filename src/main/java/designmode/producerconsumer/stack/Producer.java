package designmode.producerconsumer.stack;
//生产者线程
public class Producer extends Thread{
	//***************************************************************************************
	private Stack s;
	//***************************************************************************************
	public Producer(){super();}
	public Producer(Stack s){
		this.s = s;
	}
	//***************************************************************************************
	@Override
	public void run(){
		for(char c = 'A' ; c <= 'Z' ; c++){
			s.push(c);
			try{
				Thread.sleep(50);
			}catch(Exception e){
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