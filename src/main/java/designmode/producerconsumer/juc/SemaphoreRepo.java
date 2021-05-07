package designmode.producerconsumer.juc;

import java.util.concurrent.Semaphore;

/**
 * <p>
 * 用信号量量解决生产者与消费者问题
 * 
 * @author qhlee
 * @versioin v1.0 2016年5月5日
 * @see
 */
public class SemaphoreRepo {
	private final int MAX_SIZE = 10;// 仓库大小

	private final Semaphore semFull = new Semaphore(MAX_SIZE);// 满
	private final Semaphore semEmpty = new Semaphore(0);// 空
	private final Semaphore mutex = new Semaphore(1);// 互斥锁

	private final Object[] items = new Object[MAX_SIZE];// 仓库

	private int count = 0;// 当前产品数量
	private int takeIndex = 0;// 要消费产品的位置
	private int putIndex = 0;// 要生产产品的位置

	/**
	 * <pre>
	 * P semFull
	 * P muetx
	 * 生产
	 * V mutex
	 * V semEmpty
	 * @param anything
	 * @throws InterruptedException
	 */
	public void put(Object anything) throws InterruptedException {
		try {
			semFull.acquire();
			mutex.acquire();

			items[putIndex] = anything;
			putIndex++;
			putIndex = putIndex % MAX_SIZE;
			count++;


		} finally {
			mutex.release();
			semEmpty.release();
		}
	}

	/**
	 * <pre>
	 * P semEmpty
	 * P mutex
	 * 消费
	 * V mutex
	 * V semFull
	 * @return
	 */
	public Object take() throws InterruptedException {
		try {
			semEmpty.acquire();
			mutex.acquire();

			Object ret = items[takeIndex];

			takeIndex++;
			takeIndex = takeIndex % MAX_SIZE;
			count--;
			return ret;
		} finally {
			mutex.release();
			semFull.release();
		}

	}

}

class SemaphoreProducer implements Runnable{
	private SemaphoreRepo repo ;
	private boolean running = true ;
    private int id;

    public SemaphoreProducer(SemaphoreRepo repo, int id){
        this.repo = repo ;
        this.id = id;
    }

	static int num = 1;
    String prefix=this.id+"-prd:";
	public void run(){
		while(running){
			try{
				int n = num++;
                Object prd = prefix+n;
				repo.put(prd);
				System.out.println("["+id+"]<put> "+prd);
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace(System.out);
			}
		}
	}
}

class SemaphoreConsumer implements Runnable {
	private SemaphoreRepo repo ;
    private int id;

    public SemaphoreConsumer(SemaphoreRepo repo, int id){
        this.repo = repo ;
        this.id = id;
    }
	private boolean running = true;
	public void run() {
		while(running){
			try{
				System.out.println("["+id+"]<take> "+repo.take());
				Thread.sleep(100);
			}catch(Exception e){
				e.printStackTrace(System.out);
			}
		}
	}
	public boolean isRunning() {
		return running;
	}
	public void setRunning(boolean running) {
		this.running = running;
	}
	
	
}


class SemaphoreRepoTest{
    public static void main(String[] args) {
        SemaphoreRepo repo = new SemaphoreRepo();

        //生产者数
        int pc = 2;
        //消费者数
        int cc = 1;
        //CountDownLatch singal = new CountDownLatch(pc+cc);

        int i = 0 ;
        //创建消费者
        for(i = 0 ; i < cc; i++){
            new Thread(new SemaphoreConsumer(repo, i)).start();
        }


        //创建生产者
        for(i = 0 ; i < pc; i++){
            new Thread(new SemaphoreProducer(repo, i)).start();
        }

    /*    try {
            singal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("over");
        */
    }
}