
package Bai4;

import java.util.Scanner;

public class Array {
    private int[] a;
    private int n;

    public Array() {
    }

    public Array(int[] a, int n) {
        this.a = a;
        this.n = n;
    }

    public int[] getA() {
        return a;
    }

    public void setA(int[] a) {
        this.a = a;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    
    public void InputData(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử: ");
        int tmp = sc.nextInt();
        this.setN(tmp);
        this.a = new int[this.getN()];
        for(int i = 0; i < this.getN(); i++){
            System.out.print("Nhập a[" + i + "] = ");
            this.a[i] = sc.nextInt();
        }
    }
    public void Show(){
        for(int i = 0; i < this.getN(); i++){
            System.out.print(this.a[i] + " ");
        }
    }
    public int Sum(){
        int sum = 0;
        for(int i : this.a)
            sum += i;
        return sum;
    }
}
