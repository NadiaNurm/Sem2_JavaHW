import java.util.ArrayList;
import java.util.LinkedList;

/*Реализовать метод, который добавляет 1 000 000 случайных элементов в ArrayList и LinkedList.
Реализовать второй метод, который выбирает из списка элемент наугад 100 000 раз.
Замерьте время и скажите кто быстрее.
 */
public class ArrayList_vs_LinkedList {

    static void compare(){
        int n = 1000000;
        ArrayList<Double> arr_list = new ArrayList<>();
        LinkedList<Double> link_list = new LinkedList<>();
        //Заполняем массивы
        for (int i = 0; i < n; i++) {
            arr_list.add((double) Math.random());
            link_list.add((double) Math.random());
        }
        //Замеряем время выполнения для ArrayList
        long start_arr = System.currentTimeMillis();
        //Выбираем элемент наугад из ArrayList
        for (int i = 0; i < 100000; i++){
            arr_list.get((int) (Math.random() * (arr_list.size() - 1)));
       }
        long finish_arr = System.currentTimeMillis();
        //System.out.println("Прошло времени, мс: " + (finish_arr - start_arr));

        //Замеряем время выполнения для LinkedList
        long start_link = System.currentTimeMillis();
        //Выбираем элемент наугад из LinkedList
        for (int i = 0; i < 100000; i++){
            link_list.get((int) (Math.random() * (link_list.size() - 1)));
        }
        long finish_link = System.currentTimeMillis();
        //System.out.println("Прошло времени, мс: " + (finish_link - start_link));
        if((finish_arr - start_arr)<(finish_link - start_link))System.out.println("ArrayList быстрее!");
        else {System.out.println("LinkedList быстрее!");}
    }
}

