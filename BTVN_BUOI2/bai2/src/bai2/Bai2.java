
package bai2;

import java.util.Scanner;


public class Bai2 {

    public static void Nhap(int[] a, int n){
        Scanner sc = new Scanner(System.in);
        for(int i  = 0; i < n; i++){
            System.out.print("Nhập a[" + i + "] = ");
            a[i] = sc.nextInt();
        }
    }
    
    public static void Xuat(int[] a, int n){
        for(int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
    }
    
    public static int MaxOfArray(int[] a, int n){
        int max = a[0];
        for(int i = 1; i < n; i++)
            max = (max > a[i]) ? max : a[i];
        return max;
    }
    
    public static int MinOfArray(int[] a, int n){
        int min = a[0];
        for(int i = 1; i < n; i++)
            min = (min < a[i]) ? min : a[i];
        return min;
    }
    
    public static void Increase(int[] a, int n){
        for(int i = 0; i < n - 1; i++)
            for(int j = n - 1; j > i; j--)
                if(a[j - 1] > a[j]){
                    int tmp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = tmp;
                }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter the number n = ");
        n = sc.nextInt();
        int[] a = new int[n];
        Nhap(a, n);
        System.out.println("Max of array is: " + MaxOfArray(a, n));
        System.out.println("Min of array is: " + MinOfArray(a, n));
        Increase(a, n);
        System.out.print("Mảng tăng dần là: ");
        Xuat(a, n);
    }
}
