package no_1110_1120;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class LC_1114_Semaphore {
	
	public LC_1114_Semaphore() {
        
    }

	private Semaphore printSecondSemaphore = new Semaphore(0);
	private Semaphore printThirdSemaphore = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        printSecondSemaphore.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
		printSecondSemaphore.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        printThirdSemaphore.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
    	printThirdSemaphore.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

	public static void main(String[] args) throws InterruptedException {
		LC_1114_Semaphore lc = new LC_1114_Semaphore();
		
		ThreadPoolExecutor ex = new ThreadPoolExecutor(10, 10, 10000, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

		ex.execute(new Runnable() {
			@Override
			public void run() {
				try {
					lc.second(new Runnable() {
						@Override
						public void run() {
							System.out.println("second");
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		ex.execute(new Runnable() {
			@Override
			public void run() {
				try {
					lc.first(new Runnable() {
						@Override
						public void run() {
							System.out.println("first");
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		ex.execute(new Runnable() {
			@Override
			public void run() {
				try {
					lc.third(new Runnable() {
						@Override
						public void run() {
							System.out.println("third");
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
