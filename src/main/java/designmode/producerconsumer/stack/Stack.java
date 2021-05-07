package designmode.producerconsumer.stack;

public class Stack {
	//***************************************************************************************
//	private char[] data = new char[6];
	private char[] data = new char[]{' ',' ',' ',' ',' ',' '};
	private int index = 0;	
	//***************************************************************************************
	public synchronized void push(char c){		//入栈
		while(index == data.length){
			try{
				this.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		data[index] = c ;
		index ++;
		this.notifyAll();
		System.out.print(c+" push stack :");
		printStack();
	}
	//***************************************************************************************
	public synchronized void pop(){				//出栈
		while(index == 0){
			try{
				this.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
		index --;
		char c = data[index];
		data[index] = ' ';
		
		this.notifyAll();
		System.out.print(c+" pop stack : ");
		printStack();
	}
	//***************************************************************************************
	private void printStack(){
		for(int i = 0 ; i < data.length ; i++){
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}

}
