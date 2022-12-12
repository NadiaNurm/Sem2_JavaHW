package hw_thread_2;

import java.util.ArrayList;
import java.util.List;

public class Producer implements Runnable {

    final List<Integer> data;

    public Producer(List<Integer> list) {
        data = list;
    }

    public void addIntToList() throws InterruptedException {
        // каждый поток ждет пока коллекция даст доступ
        synchronized (data){
            while(!data.contains(null)){
                System.out.println("Dear " + Thread.currentThread().getName() + "! Please, wait, because list is full.");
                data.wait();
            }
            data.set(data.indexOf(null),(int)(Math.random()*100));
            System.out.println(Thread.currentThread().getName() + " has inserted the number!");
            data.notifyAll();// разморозили поток
        }
    }

    @Override
    public void run() {
        try {
            while (true){
                addIntToList();
              //  Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
