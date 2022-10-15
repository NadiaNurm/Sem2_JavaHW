import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Создаем вектор
        Vector vec = new Vector(2,3,4);
        // Ищем длину вектора
        System.out.println("Длина вектора:");
        System.out.println(vec.length());
        //Создаем второй вектор
        Vector vec1 = new Vector();
        vec1.x = 5;
        vec1.y = -5;
        vec1.z = 15;
        //Ищем скалярное произведение vec и vec1
        System.out.println("Скалярное произведение vec и vec1:");
        System.out.println(vec.Scalar_product(vec1.x,vec1.y,vec1.z));
        //Векторное произведение
        System.out.println("Векторное произведение vec и vec1:");
        Vector res_product = vec.Vector_product(vec1.x,vec1.y,vec1.z);
        System.out.println("x: "+ res_product.x +"\ny: " + res_product.y + "\nz: " + res_product.z);
        // Косинус угла
        System.out.println("Косинус угла межджу vec и vec1:");
        System.out.println(vec.Angle(vec1.x,vec1.y,vec1.z));
        /*Метод для суммы и разности
          Если f = 1, то мы складываем.
          Если f = -1, то мы вычитаем.
        */
        System.out.println("Сумма координат vec и vec1:");
        Vector res_sum = vec.Sum_product(vec1.x, vec1.y, vec1.z,1);
        System.out.println("x_sum: "+ res_sum.x +"\ny_sum: " + res_sum.y + "\nz_sum: " + res_sum.z);
        System.out.println("Разность координат vec и vec1:");
        Vector res_sub = vec.Sum_product(vec1.x, vec1.y, vec1.z,-1);
        System.out.println("x_sub: "+ res_sub.x +"\ny_sub: " + res_sub.y + "\nz_sub: " + res_sub.z);
        //Массив случайных векторов размером N
        System.out.println("Массив случайных векторов размером N");
        ArrayList my_list = Vector.Vector_list(5);
        System.out.println(my_list.toString());
    }}