package a;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用condition实现阻塞队列
 * @author jlgc
 *
 */
public class BlockQueue {

	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition enqcondion = lock.newCondition();
	private Condition deqcondion = lock.newCondition();
	
	public void enq() throws InterruptedException {
		lock.lock();
		try {
			while (count > 10) enqcondion.await();
			count ++;
			System.out.println("enq: " + count);
			enqcondion.signal();
		} finally {
			lock.unlock();
		}
	}
	
	public void deq() throws InterruptedException {
		lock.lock();
		try {
			while (count == 0) deqcondion.await();
			count --;
			System.out.println("deq: " + count);
			enqcondion.signal();
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		final BlockQueue bq = new BlockQueue();
		
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						try {
							bq.enq();
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
		}
		

		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						try {
							bq.deq();
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
		}
		
		
	}
}
