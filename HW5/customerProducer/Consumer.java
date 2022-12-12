package hw_thread_2;

import java.util.ArrayList;
import java.util.List;

public class Consumer implements Runnable {
    final List<Integer> getData;

    public Consumer(List<Integer> data) {
        getData = data;
    }

    private void consumeInFromList() throws InterruptedException {
        synchronized (getData) {
            while (getData.indexOf(null) == 0){
                System.out.println("Wait until list get full");
                getData.wait();
        }
            int element = getData.set(!getData.contains(null)?14:getData.indexOf(null)-1,null);
            System.out.println(Thread.currentThread().getName() + " took element " + element);
            getData.notifyAll();
        }
    }

    @Override
    public void run() {
        while (true){
            try {
                consumeInFromList();
               // Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
