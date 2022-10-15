import java.util.Random;

public class Array_of_weights {
    int[] my_array;
    int sum = 0;
    int count = 0;

    Array_of_weights(int[] values, int[] weights) {
        //Создаем массив длинны суммы всех весов, т.е. 1+2+10 = 13
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
        }
        my_array = new int[sum];
        System.out.println("Длина объединенного массива: " + my_array.length);
        //Заполняем массив так, чтобы число из списка значений встречалось столько раз, сколько оно весит.
            for (int i = 0; i < weights.length; i++) {
                for (int j = 0; j < weights[i]; j++) {
                    my_array[count] = values[i];
                    count+=1;
            }
        }
        // Выводим массив
        System.out.print("Объединенный массив: ");
        for(int k = 0; k < 13; k++){
            System.out.print(my_array[k]);}
        System.out.println();
    }
    //Метод для получения произвольного значения из массива
    public int get_value(){
        Random random = new Random();
        int rand_val = random.nextInt(my_array.length);
        return my_array[rand_val];
    }
}

