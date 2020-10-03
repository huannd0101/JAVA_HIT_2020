package bai1;

import java.util.Scanner;

public class Bai1 {
    
    public static int MaxOfNumber(int a, int b, int c){
        int max = a;
        if(b > a && b > c)
            max = b;
        if(c > a && c > b)
            max = c;
        return max;
    }
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, c;
        System.out.print("Nhap a = ");
        a = sc.nextInt();
        System.out.print("Nhap b = ");
        b = sc.nextInt();
        System.out.print("Nhap c = ");
        c = sc.nextInt();
        System.out.println("Max(" + a + ", " + b + ", " + c + ") = " + MaxOfNumber(a, b, c));
    }
    
}
