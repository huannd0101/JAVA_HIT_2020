
package Bai3;

import java.util.ArrayList;
import java.util.Scanner;

public class Phieu {
    private String maPhieu;
    private ArrayList<Hang> x = new ArrayList<>();
    private int n;

    public Phieu() {
    }

    public Phieu(String maPhieu, int n) {
        this.maPhieu = maPhieu;
        this.n = n;
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public ArrayList<Hang> getX() {
        return x;
    }

    public void setX(ArrayList<Hang> x) {
        this.x = x;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    
    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã phiếu: ");
        this.maPhieu = sc.nextLine();
        System.out.print("Nhập số hàng: ");
        this.n = sc.nextInt();
        for(int i = 0; i < n; i++){
            System.out.println("Nhập thông tin hàng thứ " + (i + 1));
            Hang tmp = new Hang();
            tmp.Nhap();
            x.add(tmp);
        }
    }

    @Override
    public String toString() {
        return "\nPhieu{" + "maPhieu=" + maPhieu + ", \nx=" + x + ", \nn=" + n + '}';
    }
    
    
}
