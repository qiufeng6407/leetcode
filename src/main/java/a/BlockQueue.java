package a;

import java.util.UUID;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用condition实现阻塞队列
 * @author jlgc
 *
 */
public class BlockQueue<E> {

	private Object[] objs;
	private int enqindex = -1;
	private int deqindex = -1;
	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition enqcondion = lock.newCondition();
	private Condition deqcondion = lock.newCondition();
	
	public BlockQueue(int len) {
		objs = new Object[len];
	}
	
	public void enq(E o) throws InterruptedException {
		lock.lock();
		try {
			while (count >= objs.length) enqcondion.await();
			enqindex = (++enqindex) % objs.length;
			objs[enqindex] = o;
			count++;
			System.out.println(">>>: " + count + " " + o.toString());
			deqcondion.signal();
		} finally {
			lock.unlock();
		}
	}
	
	@SuppressWarnings("unchecked")
	public E deq() throws InterruptedException {
		lock.lock();
		try {
			while (count == 0) deqcondion.await();
			deqindex = (++deqindex) % objs.length;
			Object o = objs[deqindex];
			objs[deqindex] = null;
			count --;
			System.out.println("<<<:      " + count + " " + o);
			enqcondion.signal();
			return (E) o;
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		final BlockQueue<String> bq = new BlockQueue<>(3);
		
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						try {
							bq.enq(UUID.randomUUID().toString());
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
