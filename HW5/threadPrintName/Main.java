package hw_thread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadName threadName1 = new ThreadName();
        ThreadName threadName2 = new ThreadName();
        threadName1.start();
        threadName1.join();
        threadName2.start();
        threadName2.join();
    }
}
