
package Bai2;

import java.util.Scanner;

public class SoPhuc {
    private double thuc;
    private double ao;

    public SoPhuc() {
    }

    public SoPhuc(double thuc, double ao) {
        this.thuc = thuc;
        this.ao = ao;
    }

    public double getThuc() {
        return thuc;
    }

    public void setThuc(double thuc) {
        this.thuc = thuc;
    }

    public double getAo() {
        return ao;
    }

    public void setAo(double ao) {
        this.ao = ao;
    }
    
    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập phần thực: ");
        this.thuc = sc.nextDouble();
        System.out.print("Nhập phần ảo: ");
        this.ao = sc.nextDouble();
    }
    
    public void Xuat(){
        System.out.println(this.thuc + " + " + this.ao + "i");
    }
    
    public SoPhuc Cong(SoPhuc a){
        SoPhuc x = new SoPhuc();
        x.thuc = this.thuc + a.thuc;
        x.ao = this.ao + a.ao;
        return x;
    }
    
    public SoPhuc Tru(SoPhuc a){
        SoPhuc x = new SoPhuc();
        x.thuc = this.thuc - a.thuc;
        x.ao = this.ao - a.ao;
        return x;
    }
}
