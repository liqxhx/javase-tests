package designmode.producerconsumer.stack;

public class TestProducerConsumer {

	public static void main(String[] args) {
		Stack s = new Stack();
		
		Thread producer = new Producer(s);
		Thread producer2 = new Producer(s);
		Thread consumer = new Consumer(s);

		producer.start();	
		producer2.start();
		consumer.start();
	}

}
