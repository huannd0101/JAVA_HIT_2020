
package Bai4;

import java.util.Scanner;

public class May {
    private String maMay;
    private String kieuMay;
    private String tinhTrang;

    public May() {
    }

    public May(String maMay, String kieuMay, String tinhTrang) {
        this.maMay = maMay;
        this.kieuMay = kieuMay;
        this.tinhTrang = tinhTrang;
    }

    public String getMaMay() {
        return maMay;
    }

    public void setMaMay(String maMay) {
        this.maMay = maMay;
    }

    public String getKieuMay() {
        return kieuMay;
    }

    public void setKieuMay(String kieuMay) {
        this.kieuMay = kieuMay;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "\nMay{" + "maMay=" + maMay + ", kieuMay=" + kieuMay + ", tinhTrang=" + tinhTrang + '}';
    }
    
    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã máy: ");
        this.maMay = sc.nextLine();
        System.out.print("Nhập kiểu máy: ");
        this.kieuMay = sc.nextLine();
        System.out.print("Nhập tình trạng máy: ");
        this.tinhTrang = sc.nextLine();
    }
}
