package no_1190_1199;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class LC_1195_Semaphore {
	
    private int n;
    private int v = 1;

    public LC_1195_Semaphore(int n) {
        this.n = n;
    }

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

 // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
    	lock.lock();
		try {
			while (v <= n) {
				if (v % 3 != 0 || v % 5 == 0) {
					condition.await();continue;
				}
				printFizz.run();
		        v++;
		        condition.signalAll();
			}
		} finally {
			lock.unlock();
		}
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
    	lock.lock();
		try {
			while (v <= n) {
				if (v % 3 == 0 || v % 5 != 0) {
					condition.await();continue;
				}
				printBuzz.run();
		        v++;
		        condition.signalAll();
			}
		} finally {
			lock.unlock();
		}
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
    	lock.lock();
		try {
			while (v <= n) {
				if (v % 3 != 0 || v % 5 != 0) {
					condition.await();continue;
				}
				printFizzBuzz.run();
		        v++;
		        condition.signalAll();
			}
		} finally {
			lock.unlock();
		}
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
    	lock.lock();
		try {
			while (v <= n) {
				if (v % 3 == 0 || v % 5 == 0) {
					condition.await();continue;
				}
				printNumber.accept(v);
		        v++;
		        condition.signalAll();
			}
		} finally {
			lock.unlock();
		}
    }

}
