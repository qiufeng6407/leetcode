package no_1110_1120;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LC_1115_Condition2 {
	
    private int n;

    public LC_1115_Condition2(int n) {
        this.n = n;
    }
    
    private ReentrantLock lock = new ReentrantLock();
    private Condition fooprinted = lock.newCondition();
    private Condition barprinted = lock.newCondition();
    private volatile boolean start = false;

    public void foo(Runnable printFoo) throws InterruptedException {
 		while (!start) Thread.yield();
        for (int i = 0; i < n; i++) {
        	lock.lock();
        	try {
	        	// printFoo.run() outputs "foo". Do not change or remove this line.
	        	printFoo.run();
	        	fooprinted.signal();
	        	if (i < n - 1) barprinted.await();
        	} finally {
        		lock.unlock();
			}
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
        	lock.lock();
        	if (!start) start = true;
         	try {
         		if (i == 0) fooprinted.await();
 	            // printBar.run() outputs "bar". Do not change or remove this line.
 	        	printBar.run();
 	        	barprinted.signal();
 	        	if (i < n - 1) fooprinted.await();
         	} finally {
         		lock.unlock();
 			}
        }
    }

	public static void main(String[] args) throws InterruptedException {
		final LC_1115_Condition2 lc = new LC_1115_Condition2(10);
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
