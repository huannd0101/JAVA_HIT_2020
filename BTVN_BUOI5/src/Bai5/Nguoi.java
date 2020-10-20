
package Bai5;

import java.util.Scanner;

public class Nguoi {
    protected String hoTen;
    protected String ngaySinh;
    protected String queQuan;

    public Nguoi() {
    }

    public Nguoi(String hoTen, String ngaySinh, String queQuan) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }
    
    public void Input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhập họ tên: ");
        this.hoTen = sc.nextLine();
        System.out.print("Nhập ngày sinh: ");
        this.ngaySinh = sc.nextLine();
        System.out.print("Nhập quê quán: ");
        this.queQuan = sc.nextLine();
    }
    
    public void Output(){
        System.out.printf("%30s %15s %30s ", this.hoTen, this.ngaySinh, this.queQuan);
    }
}
