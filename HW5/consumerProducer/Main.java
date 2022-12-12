package hw_thread_2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Дано два потока — производитель и потребитель. Производитель генерирует некоторые данные (в примере — числа).
// Производитель «потребляет» их.
//Два потока разделяют общий буфер данных, размер которого ограничен.
// Если буфер пуст, потребитель должен ждать, пока там появятся данные.
// Если буфер заполнен полностью, производитель должен ждать, пока потребитель заберёт данные и место освободится.
public class Main {

    private static final List<Integer> list = Collections.synchronizedList(Arrays.asList(new Integer[15]));

    public static void main(String[] args) throws InterruptedException {
        Thread producer = new Thread(new Producer(list));
        Thread consumer = new Thread(new Consumer(list));
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();

    }
}
