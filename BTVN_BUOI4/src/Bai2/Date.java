
package Bai2;

import java.util.Scanner;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date() {
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ngày: ");
        this.day = sc.nextInt();
        System.out.print("Nhập tháng: ");
        this.month = sc.nextInt();
        System.out.print("Nhập năm: ");
        this.year = sc.nextInt();
    }

    @Override
    public String toString() {
        return "Date{" + "day=" + day + ", month=" + month + ", year=" + year + '}';
    }
    
    
}
