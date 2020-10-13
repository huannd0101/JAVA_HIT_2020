
package Bai4;

import java.util.Scanner;

public class QuanLy {
    private String maQL;
    private String hoTen;

    public QuanLy() {
    }

    public QuanLy(String maQL, String hoTen) {
        this.maQL = maQL;
        this.hoTen = hoTen;
    }

    public String getMaQL() {
        return maQL;
    }

    public void setMaQL(String maQL) {
        this.maQL = maQL;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    @Override
    public String toString() {
        return "QuanLy{" + "maQL=" + maQL + ", hoTen=" + hoTen + '}';
    }
    
    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã quản lý: ");
        this.maQL = sc.nextLine();
        System.out.print("Nhập họ tên quản lý: ");
        this.hoTen = sc.nextLine();
    }
}
