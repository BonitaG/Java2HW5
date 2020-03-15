import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Passenger extends Thread {
    private Semaphore semaphore;
    private int id;
    private CountDownLatch cdl;

    public Passenger(Semaphore semaphore, int id, CountDownLatch cdl) {
        this.semaphore = semaphore;
        this.id = id;
        this.cdl = cdl;
    }

    public synchronized void run(){
        try {
            semaphore.acquire();
            System.out.println( " Passenger " +  id + "  Bought ticket  ");
            sleep(1000);


            System.out.println(" Passenger " + id + "  Bought ticket ");
            semaphore.release();

            System.out.println(" Passenger " + id + "  Got on the bus  ");
            cdl.countDown();
            cdl.await();














        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
        }


