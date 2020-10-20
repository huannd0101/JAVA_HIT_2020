
package Bai3;

import java.util.Scanner;

public class SanPham {
    private String maSP;
    private String tenSP;
    private int soLuong;
    private double donGia;

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, int soLuong, double donGia) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    
    public void InputSP(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\tNhập mã SP: ");
        this.maSP = sc.nextLine();
        System.out.print("\tNhập tên SP: ");
        this.tenSP = sc.nextLine();
        System.out.print("\tNhập số lượng: ");
        this.soLuong = sc.nextInt();
        System.out.print("\tNhập đơn giá: ");
        this.donGia = sc.nextDouble();
        sc.nextLine();
    }
    
    public void OutputSP(){
        System.out.printf("%20s %20s %15d %15f %15f\n", this.maSP, this.tenSP, this.soLuong, this.donGia, this.donGia * this.soLuong);
    }
}
