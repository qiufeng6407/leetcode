package no_1110_1120;
public class LC_1115_WaitNotify {
	
    private int n;

    public LC_1115_WaitNotify(int n) {
        this.n = n;
    }
    
    private Object lock = new Object();
    private boolean fooprint = false;
    private boolean barprint = false;

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
				if (i > 0 && !barprint) {
					lock.wait();
				}
	        	// printFoo.run() outputs "foo". Do not change or remove this line.
	        	printFoo.run();
	        	fooprint = true;
	        	barprint = false;
	        	lock.notify();
			}
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
        	 synchronized (lock) {
        		 if (!fooprint) {
 					lock.wait();
 				}
 	            // printBar.run() outputs "bar". Do not change or remove this line.
 	        	printBar.run();
 	        	fooprint = false;
 	        	barprint = true;
	        	lock.notify();
 			}
        }
    }

	public static void main(String[] args) throws InterruptedException {
		final LC_1115_WaitNotify lc = new LC_1115_WaitNotify(10);
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
				lc.foo(new Runnable() {
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
