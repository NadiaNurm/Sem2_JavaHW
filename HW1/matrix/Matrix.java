public class Matrix {
    int row;
    int column;
    int[][] my_matrix;

    //Конструктор 1
    public Matrix() {
    }

    //Конструктор 2
    public Matrix(int row, int column) {
        my_matrix = new int[row][column];
    }

    // Метод для заполнения матрицы произвольными значениями
    public int[][] Fill_Matrix(int my_matrix[][]) {
        for (int i = 0; i < my_matrix.length; i++) {
            for (int j = 0; j < my_matrix[i].length; j++) {
                my_matrix[i][j] = (int) (Math.random() * 10);
            }
        }
        return my_matrix;
    }

    // Метод для вывода матрицы в консоль
    public void OutPut_Matrix(int my_matrix[][]) {
        for (int i = 0; i < my_matrix.length; i++) {
            for (int j = 0; j < my_matrix[i].length; j++) {
                System.out.printf("%3d|", my_matrix[i][j]);
            }
            System.out.println();
        }
    }

    /* Метод для суммирования и вычитания двух матриц.
    Ограничение: количество строк и столбцов должно быть одинаковое
    Если множитель 1, то складываем. Если множитель -1, то вычитаем.
     */
    public static int[][] Sum_Matrix(int first_matrix[][], int second_matrix[][], int f) {
        try {
                if ( f == 1) System.out.println("Сумма матриц");
                if ( f == -1) System.out.println("Разность матриц");
                int [][] res_matrix = new int[first_matrix.length][first_matrix.length];
                for (int i = 0; i < first_matrix.length; i++) {
                    for (int j = 0; j < second_matrix[i].length; j++) {
                        res_matrix[i][j] = first_matrix[i][j] + f*second_matrix[i][j];
                    }
                }
                return res_matrix;
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Суммировать можно только одинаковые матрицы!");
            return null;
    }}

// Метод для умножения двух матриц. Ограничение: число столбцов в первом сомножителе равно числу строк во втором
    public static int[][] Multi_Matrix(int first_matrix[][], int second_matrix[][]) {
       int [][] res_matrix = new int[first_matrix.length ][second_matrix[0].length];
        System.out.println("Умножение матриц");
        try{
            for (int i=0; i < first_matrix.length;i++){
                for (int j=0; j < second_matrix[0].length;j++){
                    for (int k=0; k < second_matrix.length; k++){
                        res_matrix[i][j] += first_matrix[i][k] * second_matrix[k][j]; }}}
            return res_matrix;
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Умножать можно только если число столбцов в первом сомножителе равно числу строк во втором!");
            return null;
        }
    }
// Метод для умножения матрицы на число.
    public static int[][] Multi_num(int num_matrix[][],int num){
        int [][] res_matrix = new int[num_matrix.length][num_matrix[0].length];
        System.out.println("Умножение матрицы на число");
        for (int i = 0; i < num_matrix.length; i++) {
            for (int j = 0; j < num_matrix[i].length; j++) {
                res_matrix[i][j] =num_matrix[i][j]*num;
            }
        }
        return res_matrix;
    }
// Метод для возведения матрицы в степень.
    public static int[][] Exp_num(int num_matrix[][],int power){
        int [][] res_matrix = new int[num_matrix.length][num_matrix[0].length];
        System.out.println("Возведения матрицы в степень");
        for (int i = 0; i < num_matrix.length; i++) {
            for (int j = 0; j < num_matrix[i].length; j++) {
                res_matrix[i][j] = (int) Math.pow(num_matrix[i][j], power);
            }
        }
        return res_matrix;
    }
// Метод для транспонирования матрицы.
    public static int[][] Trans_Matrix(int my_matrix[][]) {
        System.out.println("Транспонированиу матриц");
        int [][] res_matrix = new int[my_matrix[0].length][my_matrix.length];
        for (int i = 0; i < my_matrix[0].length; i++) {
            for (int j = 0; j < my_matrix.length; j++) {
                res_matrix[i][j] = my_matrix[j][i];
        }
    }
    return res_matrix;
}
   }



