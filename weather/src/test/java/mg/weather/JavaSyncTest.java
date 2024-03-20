package mg.weather;

import org.junit.jupiter.api.Test;

public class JavaSyncTest {


    @Test
    public void threadsTest() {
        ThreadTest t1 = new ThreadTest();
        t1.start();
    }

    @Test
    public void syncBlockTest() {

    }

    class RunnableTest implements Runnable {
        public void run() {
            System.out.println("Another thread");
        }
    }

    class ThreadTest extends Thread {
        public void run() {
            System.out.println("Another thread");
        }
    }
}
