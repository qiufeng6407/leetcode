package no_1110_1119;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class LC_1116_Condition {
	
    private int n;

    public LC_1116_Condition(int n) {
        this.n = n;
    }
    
    private ReentrantLock lock = new ReentrantLock();
    private Condition odd = lock.newCondition();
    private Condition even = lock.newCondition();
    private Condition zero = lock.newCondition();
    private boolean printzero = true;
    private boolean printodd = false;
    private boolean printeven = false;

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
    	for (int i = 0; i < n; i++) {
    		lock.lock();
    		try {
    			if (!printzero) zero.await();
    			printNumber.accept(0);
    			printzero = false;
    			if (printeven) {
    				printeven = true;
        			even.signal();
    			} else {
    				printodd = true;
        			odd.signal();
    			}
			} finally {
				lock.unlock();
			}
    	}
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
    	for (int i = 2; i <= n; i+=2) {
    		lock.lock();
    		try {
    			if (!printeven) even.await();
    			printNumber.accept(i);
    			printzero = true;
    			printeven = false;
    			printodd = true;
    			zero.signal();
			} finally {
				lock.unlock();
			}
    	}
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
    	for (int i = 1; i <= n; i+=2) {
    		lock.lock();
    		try {
    			if (!printodd) odd.await();
    			printNumber.accept(i);
    			printzero = true;
    			printeven = true;
    			printodd = false;
    			zero.signal();
			} finally {
				lock.unlock();
			}
    	}
    }

	public static void main(String[] args) throws InterruptedException {
		final LC_1116_Condition lc = new LC_1116_Condition(10);
		new Thread(()-> {
			try {
				lc.zero((c) -> { System.out.print(c); });
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		new Thread(()-> {
			try {
				lc.even((c) -> { System.out.print(c); });
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		new Thread(()-> {
			try {
				lc.odd((c) -> { System.out.print(c); });
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

}
