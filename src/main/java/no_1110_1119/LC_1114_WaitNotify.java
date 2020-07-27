package no_1110_1119;
public class LC_1114_WaitNotify {
	
	public LC_1114_WaitNotify() {
        
    }

	private volatile boolean printFirstFinish;
	private volatile boolean printSecondFinish;
	
	private Object lock = new Object();

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
	        // printFirst.run() outputs "first". Do not change or remove this line.
	        printFirst.run();
	        printFirstFinish = true;
	        lock.notifyAll();
		}
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
        	while (!printFirstFinish) {
        		lock.wait();
        	}
	        // printSecond.run() outputs "second". Do not change or remove this line.
	        printSecond.run();
	        printSecondFinish = true;
	        lock.notifyAll();
		}
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
        	while (!printSecondFinish) {
        		System.out.println(3);
        		lock.wait();
        	}
	        // printThird.run() outputs "third". Do not change or remove this line.
	        printThird.run();
        }
    }

	public static void main(String[] args) throws InterruptedException {
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {

					LC_1114_WaitNotify lc = new LC_1114_WaitNotify();

					lc.second(new Runnable() {
						@Override
						public void run() {
							System.out.println("second");
						}
					});
					
					lc.first(new Runnable() {
						@Override
						public void run() {
							System.out.println("one");
						}
					});

					lc.third(new Runnable() {
						@Override
						public void run() {
							System.out.println("third");
						}
					});
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}).start();
	}

}
