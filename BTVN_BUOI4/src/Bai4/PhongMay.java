
package Bai4;

import java.util.ArrayList;
import java.util.Scanner;

public class PhongMay {
    private String maPhong;
    private String tenPhong;
    private double dienTich;
    private QuanLy x;
    private ArrayList<May> y = new ArrayList<>();
    private int n;

    public PhongMay() {
    }

    public PhongMay(String maPhong, String tenPhong, double dienTich, QuanLy x, int n) {
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.dienTich = dienTich;
        this.x = x;
        this.n = n;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public QuanLy getX() {
        return x;
    }

    public void setX(QuanLy x) {
        this.x = x;
    }

    public ArrayList<May> getY() {
        return y;
    }

    public void setY(ArrayList<May> y) {
        this.y = y;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "PhongMay{" + "\nmaPhong=" + maPhong + ", tenPhong=" + tenPhong + ", dienTich=" + dienTich + ",\nx=" + x + ", \ny=" + y + ", \nn=" + n + '}';
    }
    
    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã phòng: ");
        this.maPhong = sc.nextLine();
        System.out.print("Nhập tên phòng: ");
        this.tenPhong = sc.nextLine();
        System.out.print("Nhập diện tích: ");
        this.dienTich = sc.nextDouble();
        this.x = new QuanLy();
        x.Nhap();
        System.out.print("Nhập số máy: ");
        this.n = sc.nextInt();
        for(int i = 0; i < this.n; i++){
            May tmp = new May();
            System.out.println("Nhập thông tin máy thứ " + (i + 1));
            tmp.Nhap();
            y.add(tmp);
        }
    }
}
