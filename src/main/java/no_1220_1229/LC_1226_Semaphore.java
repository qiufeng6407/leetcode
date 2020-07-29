package no_1220_1229;

import java.util.concurrent.Semaphore;

public class LC_1226_Semaphore {

	private Semaphore[] ss = new Semaphore[5];
	private volatile int pickLeftForkCount = 0;
	public LC_1226_Semaphore() {
		for (int i = 0; i < ss.length; i++) {
			ss[i] = new Semaphore(1);
		}
	}

	// call the run() method of any runnable to execute its code
	public void wantsToEat(int philosopher, Runnable pickLeftFork, Runnable pickRightFork, Runnable eat,
			Runnable putLeftFork, Runnable putRightFork) throws InterruptedException {
		while (pickLeftForkCount == ss.length - 1) {
			Thread.yield();
		}
		Semaphore left = ss[philosopher];
		Semaphore right = null;
		if (philosopher == 0) {
			right = ss[ss.length - 1];
		} else {
			right = ss[philosopher - 1];
		}
		left.acquire();
		pickLeftForkCount ++;
		pickLeftFork.run();
		right.acquire();
		pickRightFork.run();
		eat.run();
		putLeftFork.run();
		left.release();
		pickLeftForkCount --;
		putRightFork.run();
		right.release();
	}

}
