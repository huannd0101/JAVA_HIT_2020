
package Bai3;

import java.util.ArrayList;
import java.util.Scanner;

public class Phieu {
    private String maPhieu;
    private String tenPhieu;
    private DateTime a;
    private ArrayList<SanPham> x = new ArrayList<>();
    private int n;

    public Phieu() {
    }

    public Phieu(String maPhieu, String tenPhieu, DateTime a, int n) {
        this.maPhieu = maPhieu;
        this.tenPhieu = tenPhieu;
        this.a = a;
        this.n = n;
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getTenPhieu() {
        return tenPhieu;
    }

    public void setTenPhieu(String tenPhieu) {
        this.tenPhieu = tenPhieu;
    }

    public DateTime getA() {
        return a;
    }

    public void setA(DateTime a) {
        this.a = a;
    }

    public ArrayList<SanPham> getX() {
        return x;
    }

    public void setX(ArrayList<SanPham> x) {
        this.x = x;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    
    public void InputPhieu(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã phiếu: ");
        this.maPhieu = sc.nextLine();
        System.out.print("Nhập tên phiếu: ");
        this.tenPhieu = sc.nextLine();
        System.out.println("Nhập ngày tháng năm");
        a = new DateTime();
        this.a.InputDate();
        System.out.print("Nhập số sản phẩm: ");
        this.n = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập danh sách sản phẩm");
        for(int i = 0; i < this.n; i++){
            System.out.println("Nhập sản phẩm thứ " + (i + 1));
            SanPham temp = new SanPham();
            temp.InputSP();
            x.add(temp);
        }
    }
    
    public void OutputPhieu(){
        System.out.println("Mã phiếu: " + getMaPhieu());
        System.out.println("Tên phiếu: " + getTenPhieu());
        System.out.print("Ngày tháng năm: ");
        a.OutPutDate();
        System.out.printf("%5s %20s %20s %15s %15s %15s\n", "STT", "Mã SP", "Tên SP", "Số lượng", "Đơn giá", "Thành tiền");
        for(int i = 0; i < x.size(); i++){
            System.out.printf("%5d", (i + 1));
            x.get(i).OutputSP();
        }
           
    }
}
