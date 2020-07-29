package no_1110_1119;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LC_1117_Condition {
	
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private int hydrogenCount = 0;
    private int oxygenCount = 0;

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
    	lock.lock();
		try {
			while (hydrogenCount == 2) {
				condition.await();
			}
	        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
	        releaseHydrogen.run();
	        hydrogenCount++;
			clearIfNeed();
		} finally {
			lock.unlock();
		}
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
    	lock.lock();
		try {
			while (oxygenCount == 1) {
				condition.await();
			}
	        // releaseOxygen.run() outputs "O". Do not change or remove this line.
			releaseOxygen.run();
			oxygenCount++;
			clearIfNeed();
		} finally {
			lock.unlock();
		}
    }
    
    private void clearIfNeed() {
    	if (hydrogenCount == 2 && oxygenCount == 1) {
    		hydrogenCount = 0;
    		oxygenCount = 0;
    	}
    	condition.signalAll();
    }
    
	public static void main(String[] args) throws InterruptedException {
		final LC_1117_Condition lc = new LC_1117_Condition();
		new Thread(()-> {
			try {
				lc.hydrogen(new Runnable() {
					@Override
					public void run() {
						System.out.print("H");
					}
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		new Thread(()-> {
			try {
				lc.oxygen(new Runnable() {
					@Override
					public void run() {
						System.out.print("O");
					}
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

}
