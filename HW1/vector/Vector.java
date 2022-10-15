import java.util.ArrayList;

public class Vector {
    int x;
    int y;
    int z;

//Конструктор 1
    Vector(){}
//Конструктор 2
    Vector(int x,int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }


    //Длина вектора
    public double length(){
        return Math.sqrt(Math.pow(x,2)+Math.pow(y,2)+Math.pow(z,2));
    }
//Скалярное произведение
    public double Scalar_product(int x1,int y1,int z1){
        return this.x * x1 + this.y * y1 + this.z * z1;
    }
//Векторное произведение
    public Vector Vector_product(int x1,int y1,int z1){
        Vector res_vec = new Vector();
        res_vec.x = this.y*z1-this.z*y1;
        res_vec.y = this.z*x1-this.x*z1;
        res_vec.z = this.x*y1+this.y*x1;
        return res_vec;
    }
    //Косинус угла
    public double Angle(int x1,int y1,int z1){
        return (this.Scalar_product(x1,y1,z1))/(this.length()*Math.sqrt(Math.pow(x1,2)+Math.pow(y1,2)+Math.pow(z1,2)));
    }
    /*Метод для суммы и разности
    Если f = 1, то мы складываем.
    Если f = -1, то мы вычитаем.
    */
    public Vector Sum_product(int x1,int y1,int z1,int f){
        Vector res_vec = new Vector();
        res_vec.x = this.x + f*x1;
        res_vec.y = this.y + f*y1;
        res_vec.z = this.z + f*z1;
        return res_vec;
    }
    //Массив случайных векторов размером N

    public static ArrayList Vector_list(int n){
        ArrayList<Vector> vec_list = new ArrayList<Vector>();
        for (int i=0;i<n;i++){
            int x = (int) (Math.random() * 100);
            int y = (int) (Math.random() * 100);
            int z = (int) (Math.random() * 100);
            vec_list.add(new Vector( x,  y, z));
        }
        return vec_list;
}


}
