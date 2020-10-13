
package Bai3;

import java.util.Scanner;

public class Hang {
    private String maHang;
    private String tenHang;
    private double donGia;

    public Hang() {
    }

    public Hang(String maHang, String tenHang, double donGia) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.donGia = donGia;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    
    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã hàng: ");
        this.maHang = sc.nextLine();
        System.out.print("Nhập tên hàng: ");
        this.tenHang = sc.nextLine();
        System.out.print("Nhập đơn giá: ");
        this.donGia = sc.nextDouble();
    }

    @Override
    public String toString() {
        return "\nHang{" + "maHang=" + maHang + ", tenHang=" + tenHang + ", donGia=" + donGia + '}';
    }
}
