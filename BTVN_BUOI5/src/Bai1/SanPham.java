
package Bai1;

import java.util.Scanner;

public class SanPham {
    protected String maSP;
    protected String tenSP;
    protected String hangSX;
    protected String ngayNhap;

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, String hangSX, String ngayNhap) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.hangSX = hangSX;
        this.ngayNhap = ngayNhap;
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

    public String getHangSX() {
        return hangSX;
    }

    public void setHangSX(String hangSX) {
        this.hangSX = hangSX;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
    
    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã sản phẩm: ");
        this.maSP = sc.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        this.tenSP = sc.nextLine();
        System.out.print("Nhập tên hãng sản xuất: ");
        this.hangSX = sc.nextLine();
        System.out.print("Nhập ngày nhập: ");
        this.ngayNhap = sc.nextLine();
    }
    
    public void Xuat(){
        System.out.printf("%20s %30s %30s %15s", this.maSP, this.tenSP, this.hangSX, this.ngayNhap);
    }
}
