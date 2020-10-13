
package Bai2;

import java.util.Scanner;

public class NhanSu {
    private String maNhanSu;
    private String hoTen;
    private Date NS;

    public NhanSu() {
    }

    public NhanSu(String maNhanSu, String hoTen, Date NS) {
        this.maNhanSu = maNhanSu;
        this.hoTen = hoTen;
        this.NS = NS;
    }

    public String getMaNhanSu() {
        return maNhanSu;
    }

    public void setMaNhanSu(String maNhanSu) {
        this.maNhanSu = maNhanSu;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNS() {
        return NS;
    }

    public void setNS(Date NS) {
        this.NS = NS;
    }
    
    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã nhân sự: ");
        this.maNhanSu = sc.nextLine();
        System.out.print("Nhập tên nhân sự: ");
        this.hoTen = sc.nextLine();
        System.out.println("Nhập thông tin ngày sinh");
        NS = new Date();
        NS.Nhap();
    }

    @Override
    public String toString() {
        return "NhanSu{" + "maNhanSu=" + maNhanSu + ", hoTen=" + hoTen + ", NS=" + NS + '}';
    }
}
