package designmode.producerconsumer.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 *
 * <p>
 * 使用条件变量与互斥锁实现的生产者与消费者
 * @author qhlee
 * @versioin v1.0 2016年5月5日
 * @see
 */
public class ConditionRepo {
	/**仓库最大值，可容纳的产品数*/
	private static final int MAX_SIZE = 100 ;
	/**仓库当前产品数*/
	private int size ;
	
	private final Object[] items = new Object[MAX_SIZE];// 仓库
	private int takeIndex = 0;// 要消费产品的位置
	private int putIndex = 0;// 要生产产品的位置
	
	private final Lock lock = new ReentrantLock();//互斥锁
	private final Condition condProduce = lock.newCondition();//等待生产的条件
	private final Condition condConsume = lock.newCondition();//等消费的条件
	
	

	public Object take(){
		try{
			lock.lock();
			while(size<=0) {
				System.out.println("消费生产,可消费数："+size+"，仓库大小："+MAX_SIZE);
				try {
					condConsume.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("可消费数："+size);
            Object ret = items[takeIndex];

            takeIndex++;
            takeIndex %= MAX_SIZE;
            size--;

            System.out.println("消费者结束消费，可消费数："+size+"，通知生产...");
			condProduce.signal();
			return ret;
		}finally{
			lock.unlock();
		}
	}
	

	public void put(Object anyting){
		try{
			lock.lock();
			while(size >= MAX_SIZE){
				System.out.println("等待消费，当前仓库已满，产品数："+size+"，仓库大小："+MAX_SIZE);
				try {
					condProduce.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
            items[putIndex] = anyting;
            putIndex++;
            putIndex %= MAX_SIZE;
			size++;
            System.out.println("已生产了：1个产品，现库存："+size+"，通知消费...");
			condConsume.signal();

		}finally{
			lock.unlock();
		}
	}
}
