
package bai4;

import java.util.Scanner;

public class Bai4 {

    public static boolean Check(int n){
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) 
                return false;
        }   
        return n > 1;
    }
    
    public static int prime(int n){
        int s = 0, j = 0;
        
        if(n == 0)
            return 2;
        
        for(int i = 2; i < 1000000; i++){
            if(Check(i)){
                s = i;
                j++;
                if(n + 1 == j)
                    break;
            }
        }
        return s; 
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Nhập n = ");
        n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            System.out.print("Nhập a[" + i + "] = ");
            a[i] = sc.nextInt();
        }
        System.out.print("Mảng vừa nhập là: ");
        for(int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println("");
    
        int s = 0;
        for(int i = 0; i < n; i++){
            s += (Check(a[i]) ? a[i] + prime(i) - i : a[i]);
        }
        System.out.println("S = " + s);
    }
    
}
