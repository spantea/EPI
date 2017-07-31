package parallelcomputing;

/**
 * Created by stefan on 14/05/17.
 */
public class PrintEvenOdds {

    public static class OddEvenMonitor {
        private static final boolean ODD_TURN = true;
        private static final boolean EVEN_TURN = false;
        private static boolean turn = ODD_TURN;

        public synchronized void waitTurn(boolean oldTurn){
            while (turn != oldTurn) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    System.out.println("Interrupted exception");
                }
            }
        }

        public synchronized void toggle() {
            turn ^= true;
            notifyAll();
        }

    }

    public static class OddThread extends Thread {

        private final OddEvenMonitor oddEvenMonitor;

        public OddThread(OddEvenMonitor oddEvenMonitor) {
            this.oddEvenMonitor = oddEvenMonitor;
        }

        public void run() {
            for (int i = 1; i <= 100; i += 2) {
                oddEvenMonitor.waitTurn(OddEvenMonitor.ODD_TURN);
                System.out.println("Odd thread: " + i);
                oddEvenMonitor.toggle();
            }
        }
    }

    public static class EvenThread extends Thread {

        private final OddEvenMonitor oddEvenMonitor;

        public EvenThread(OddEvenMonitor oddEvenMonitor) {
            this.oddEvenMonitor = oddEvenMonitor;
        }

        public void run() {
            for (int i = 2; i <= 100; i += 2) {
                oddEvenMonitor.waitTurn(OddEvenMonitor.EVEN_TURN);
                System.out.println("Even thread: " + i);
                oddEvenMonitor.toggle();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        OddEvenMonitor oddEvenMonitor = new OddEvenMonitor();

        Thread t1 = new Thread(new OddThread(oddEvenMonitor));
        Thread t2 = new Thread(new EvenThread(oddEvenMonitor));

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
