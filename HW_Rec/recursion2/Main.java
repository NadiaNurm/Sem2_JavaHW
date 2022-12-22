package second;

import java.util.*;

public class Main {

    static HashSet<Integer> uniqueNumbers;
    static ArrayList<Integer> numbers;

    public static void main(String[] args) {
        uniqueNumbers = new HashSet<Integer>();
        numbers = new ArrayList<Integer>();
        int N = 100000000; // задаем длину массива, в котором будем искать
        fillArray(N); // получаем список уникальных номеров для поиска
        int element = numbers.get((int)(Math.random())*(numbers.size()-1));
        //Поиск перебором
        System.out.println("Поиск перебором номерова:  " + checkTimeOrdinary(element));

        // сортируем список.
        numbers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        // бинарный поиск
        System.out.println("Бинарный поиск номера:  " + checkTimeBinary(element));

    }


// метод для обычного поиска перебором, возвращает время
    public static double checkTimeOrdinary(int desireNumber) {
        double lStartTime = System.nanoTime();
        for (int number : numbers) {
            if (desireNumber == number) {
                double lEndTime = System.nanoTime();
                return lEndTime - lStartTime;
                }
            }
        return -1;
    }

    // метод для бинарного поиска, возвращает время
    public static double checkTimeBinary(int desireNumber){
        double lStartTime = System.nanoTime();
       if(binarySearch(desireNumber, 0,numbers.size())){
           double lEndTime = System.nanoTime();
           return lEndTime - lStartTime;
       }
        return -1;
    }



    // метод для бинарного поиска, булевый
    public static boolean binarySearch(int desireNumber,int left, int right){
        if (right >= left) {
            int middle = left + (right - left) / 2;
            if (desireNumber == numbers.get(middle)) {
                return true;
                }
            if (desireNumber < numbers.get(middle)){
                return binarySearch(desireNumber, left , middle-1);}

            return binarySearch(desireNumber, middle+1 , right);
            }
            return false;
        }

    public static void fillArray(int len){ // получаем список уникальных номеров для поиска
        Random random = new Random();
        while (uniqueNumbers.size() != len){
            int randomNumber = random.nextInt(len*10) + 1;
            uniqueNumbers.add(randomNumber);
        }
        numbers.addAll(uniqueNumbers);
    }
}
