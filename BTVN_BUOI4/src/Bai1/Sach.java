
package Bai1;

import java.util.Scanner;

public class Sach {
    private String maSach;
    private String tenSach;
    private String NXB;
    private int soTrang;
    private double soTien;

    public Sach() {
    }

    public Sach(String maSach, String tenSach, String NXB, int soTrang, double soTien) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.NXB = NXB;
        this.soTrang = soTrang;
        this.soTien = soTien;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getNXB() {
        return NXB;
    }

    public void setNXB(String NXB) {
        this.NXB = NXB;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }
    
    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã sách: ");
        this.maSach = sc.nextLine();
        System.out.print("Nhập tên sách: ");
        this.tenSach = sc.nextLine();
        System.out.print("Nhập nhà xuất bản: ");
        this.NXB = sc.nextLine();
        System.out.print("Nhập số trang: ");
        this.soTrang = sc.nextInt();
        System.out.print("Nhập giá tiền: ");
        this.soTien = sc.nextDouble();
        sc.nextLine();
    }

    @Override
    public String toString() {
        return "Sach{" + "maSach=" + maSach + ", tenSach=" + tenSach + ", NXB=" + NXB + ", soTrang=" + soTrang + ", soTien=" + soTien + '}';
    }
}
