package hw_thread;
//Напишите программу, в которой создаются два потока, которые выводят на консоль своё имя по очереди.
public class ThreadName extends Thread{

    public void run(){
        System.out.println(Thread.currentThread().getName());
        //for (int i = 0; i < 10; i++) {
        //    System.out.println(this.getName() + " " + i);
        //}
    }

}
