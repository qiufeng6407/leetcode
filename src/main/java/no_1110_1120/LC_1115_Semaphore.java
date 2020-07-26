package no_1110_1120;

import java.util.concurrent.Semaphore;

public class LC_1115_Semaphore {
	
    private int n;

    public LC_1115_Semaphore(int n) {
        this.n = n;
    }
    
    private Semaphore fooprinted = new Semaphore(1);
    private Semaphore barprinted = new Semaphore(0);

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
        	fooprinted.acquire();
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
        	barprinted.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
        	barprinted.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
        	fooprinted.release();
        }
    }

	public static void main(String[] args) throws InterruptedException {
		final LC_1115_Semaphore lc = new LC_1115_Semaphore(10);
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
	}

}
