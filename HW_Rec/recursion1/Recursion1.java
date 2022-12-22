package first;

import java.util.ArrayList;
import java.util.Scanner;

public class Recursion1 {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        numbersDesc(n,1);

    }
    public static void numbersDesc(int n,int counter){
        System.out.println(counter);
        if (counter<n) {
            numbersDesc(n, counter + 1);
        }
        }
    }

