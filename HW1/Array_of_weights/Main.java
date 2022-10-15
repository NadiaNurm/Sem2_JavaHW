public class Main {
    public static void main(String[] args) {
        int[] val = new int[]{1, 2, 3};
        int[] wei = new int[]{1, 2, 10};
        Array_of_weights my_array = new Array_of_weights(val,wei);
        System.out.println("---------------");
        int num = 100;
        for(int i = 0; i< num;i++)System.out.println(my_array.get_value());
    }
}