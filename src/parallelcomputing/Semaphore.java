package parallelcomputing;

public class Semaphore {
    private final int MAX_AVAILABLE;
    private int taken;

    public Semaphore(int maxAvailable) {
        this.MAX_AVAILABLE = maxAvailable;
        this.taken = 0;
    }

    public synchronized void acquire() throws InterruptedException {
        while (this.taken == MAX_AVAILABLE) {
            wait();
        }
        this.taken++;
    }

    public synchronized void realease() throws InterruptedException {
        this.taken--;
        this.notifyAll();
    }
}
