package no_1110_1119;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LC_1115_Condition {
	
    private int n;

    public LC_1115_Condition(int n) {
        this.n = n;
    }
    
    private ReentrantLock lock = new ReentrantLock();
    private Condition fooprinted = lock.newCondition();
    private Condition barprinted = lock.newCondition();
    private volatile boolean start = false;

    public void foo(Runnable printFoo) throws InterruptedException {
 		while (!start) Thread.yield();
    	lock.lock();
    	try {
    		for (int i = 0; i < n; i++) {
        		if (i > 0) barprinted.await();
	        	// printFoo.run() outputs "foo". Do not change or remove this line.
	        	printFoo.run();
	        	fooprinted.signal();
    		}
    	} finally {
    		lock.unlock();
		}
    }

    public void bar(Runnable printBar) throws InterruptedException {
    	lock.lock();
    	if (!start) start = true;
     	try {
	        for (int i = 0; i < n; i++) {
         		fooprinted.await();
 	            // printBar.run() outputs "bar". Do not change or remove this line.
 	        	printBar.run();
 	        	barprinted.signal();
	        }
     	} finally {
     		lock.unlock();
		}
    }

	public static void main(String[] args) throws InterruptedException {
		final LC_1115_Condition lc = new LC_1115_Condition(10);
		new Thread(()-> {
			try {
				lc.foo(new Runnable() {
					@Override
					public void run() {
						System.out.print("foo");
					}
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		new Thread(()-> {
			try {
				lc.bar(new Runnable() {
					@Override
					public void run() {
						System.out.print("bar");
					}
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

}
