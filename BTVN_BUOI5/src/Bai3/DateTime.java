
package Bai3;

import java.util.Scanner;

public class DateTime {
    private int ngay;
    private int thang;
    private int nam;

    public DateTime() {
    }

    public DateTime(int ngay, int thang, int nam) {
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
    }

    public int getNgay() {
        return ngay;
    }

    public void setNgay(int ngay) {
        this.ngay = ngay;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }
    
    public void InputDate(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\tNhập ngày: ");
        this.ngay = sc.nextInt();
        System.out.print("\tNhập tháng: ");
        this.thang = sc.nextInt();
        System.out.print("\tNhập năm: ");
        this.nam = sc.nextInt();
    }
     
    public void OutPutDate(){
        System.out.printf("%d/%d/%d\n", this.ngay, this.thang, this.nam);
    }
}
