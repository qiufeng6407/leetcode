package no_1110_1119;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class LC_1116_Semaphore {
	
    private int n;

    public LC_1116_Semaphore(int n) {
        this.n = n;
    }

    private Semaphore zero = new Semaphore(1);
    private Semaphore odd = new Semaphore(0);
    private Semaphore even = new Semaphore(0);

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
    	for (int i = 1; i <= n; i++) {
    		zero.acquire();
    		printNumber.accept(0);
    		if (i % 2 == 0) {
    			even.release();
    		} else {
    			odd.release();
    		}
    	}
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
    	for (int i = 2; i <= n; i+=2) {
    		even.acquire();
    		printNumber.accept(i);
    		zero.release();
    	}
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
    	for (int i = 1; i <= n; i+=2) {
    		odd.acquire();
    		printNumber.accept(i);
    		zero.release();
    	}
    }

	public static void main(String[] args) throws InterruptedException {
		final LC_1116_Semaphore lc = new LC_1116_Semaphore(100);
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
