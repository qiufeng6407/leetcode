package no_1110_1119;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LC_1115_Condition3 {
	
    private int n;

    public LC_1115_Condition3(int n) {
        this.n = n;
    }
    
    private ReentrantLock lock = new ReentrantLock();
    private Condition fooprinted = lock.newCondition();
    private Condition barprinted = lock.newCondition();
    private boolean flag = true;

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
        	lock.lock();
        	try {
        		if (!flag) barprinted.await();
	        	// printFoo.run() outputs "foo". Do not change or remove this line.
	        	printFoo.run();
	        	flag = false;
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
         	try {
         		if (flag) fooprinted.await();
 	            // printBar.run() outputs "bar". Do not change or remove this line.
 	        	printBar.run();
 	        	flag = true;
 	        	barprinted.signal();
         	} finally {
         		lock.unlock();
 			}
        }
    }

	public static void main(String[] args) throws InterruptedException {
		final LC_1115_Condition3 lc = new LC_1115_Condition3(10);
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
