
public class Main {
    public static void main(String[] args) {
        //конструкторы классов
        //первый способ
        Matrix a = new Matrix();
        a.row = 3;
        a.column = 3;
        a.my_matrix = new int [a.row][a.column];
        //заполняем матрицу а произвольными значениями и распечатываем ее
        System.out.println("Матрица а");
        a.Fill_Matrix(a.my_matrix);
        a.OutPut_Matrix(a.my_matrix);
        //второй способ
        Matrix b = new Matrix(3,3);
        //заполняем матрицу b произвольными значениями и распечатываем ее
        System.out.println("Матрица b");
        b.Fill_Matrix(b.my_matrix);
        b.OutPut_Matrix(b.my_matrix);
        System.out.println("-------------");
        //суммируем матрицы

        int res_sum [][] = Matrix.Sum_Matrix(a.my_matrix,b.my_matrix,1);
        for (int i=0;i<res_sum.length;i++){
            for (int j = 0 ; j < res_sum[i].length;j++){
                System.out.printf("%3d|", res_sum[i][j]);
            }
            System.out.println();
        }
        //вычитаем матрицы
        int res_sub [][] = Matrix.Sum_Matrix(a.my_matrix,b.my_matrix,-1);
        for (int i=0;i<res_sub.length;i++){
            for (int j = 0 ; j < res_sub[i].length;j++){
                System.out.printf("%3d|", res_sub[i][j]);
            }
            System.out.println();
        }
        //создадим матрицу c
        System.out.println("-------------");
        System.out.println("Матрица c");
        Matrix c = new Matrix(1,3);
        c.Fill_Matrix(c.my_matrix);
        c.OutPut_Matrix(c.my_matrix);
        // умножаем матрицу на число num
        int res_num [][]=Matrix.Multi_num(c.my_matrix, 2);
        for (int i=0;i<res_num.length;i++){
            for (int j = 0 ; j < res_num[i].length;j++){
                System.out.printf("%3d|", res_num[i][j]);
            }
            System.out.println();
        }
        // возводим матрицу в степень power
        int res_pow [][] =Matrix.Exp_num(c.my_matrix, 2);
        for (int i=0;i<res_pow.length;i++){
            for (int j = 0 ; j < res_pow[i].length;j++){
                System.out.printf("%3d|", res_pow[i][j]);
            }
            System.out.println();
        }
        // Транспонируем матрицу
        int res_trans [][] = Matrix.Trans_Matrix(c.my_matrix);
        for (int i=0;i<res_trans.length;i++){
            for (int j = 0 ; j < res_trans[i].length;j++){
                System.out.printf("%3d|", res_trans[i][j]);
            }
            System.out.println();
        }
        System.out.println("-------------");
        System.out.println("Матрица а");
        a.OutPut_Matrix(a.my_matrix);
        System.out.println("Матрица c");
        c.OutPut_Matrix(c.my_matrix);
        // умножаем матрицы
        int res_multy [][] = Matrix.Multi_Matrix(a.my_matrix,c.my_matrix);
        for (int i=0;i<res_multy.length;i++){
            for (int j = 0 ; j < res_multy[i].length;j++){
                System.out.printf("%3d|", res_multy[i][j]);
            }
            System.out.println();
        }
        //Проверяем, что сама матрица не меняется
        System.out.println("-------------");
        System.out.println("Проверяем, что сама матрица не меняется");
        System.out.println("Матрица а");
        a.OutPut_Matrix(a.my_matrix);
        System.out.println("Матрица b");
        b.OutPut_Matrix(b.my_matrix);
        System.out.println("Матрица c");
        c.OutPut_Matrix(c.my_matrix);
    }

    }
