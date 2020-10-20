
package Bai5;

import java.util.Scanner;

public class SinhVien extends Nguoi{
    private String maSV;
    private String nghanh;
    private int khoaHoc;

    public SinhVien() {
    }

    public SinhVien(String maSV, String nghanh, int khoaHoc) {
        this.maSV = maSV;
        this.nghanh = nghanh;
        this.khoaHoc = khoaHoc;
    }

    public SinhVien(String maSV, String nghanh, int khoaHoc, String hoTen, String ngaySinh, String queQuan) {
        super(hoTen, ngaySinh, queQuan);
        this.maSV = maSV;
        this.nghanh = nghanh;
        this.khoaHoc = khoaHoc;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getNghanh() {
        return nghanh;
    }

    public void setNghanh(String nghanh) {
        this.nghanh = nghanh;
    }

    public int getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(int khoaHoc) {
        this.khoaHoc = khoaHoc;
    }
    
    @Override
    public void Input(){
        Scanner sc = new Scanner(System.in);
        super.Input();
        System.out.print("Nhập mã sinh viên: ");
        this.maSV = sc.nextLine();
        System.out.print("Nhập nghành: ");
        this.nghanh = sc.nextLine();
        System.out.print("Nhập khóa học: ");
        this.khoaHoc = sc.nextInt();
        sc.nextLine();
    }
    
    @Override
    public void Output(){
        super.Output();
        System.out.printf("%20s %20s %10d\n", this.maSV, this.nghanh, this.khoaHoc);
    }
}
