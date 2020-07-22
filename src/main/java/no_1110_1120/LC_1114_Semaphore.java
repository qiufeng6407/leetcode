package no_1110_1120;
public class LC_1114_Semaphore {
	
	public LC_1114_Semaphore() {
        
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

					LC_1114_Semaphore lc = new LC_1114_Semaphore();

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
