
package Bai5;

import java.util.ArrayList;
import java.util.Scanner;

public class LopHoc {
    private String maLP;
    private String tenLP;
    private String ngayMo;
    private ArrayList<SinhVien> x = new ArrayList<>();
    private int n;
    private Nguoi giaoVien;

    public LopHoc() {
    }

    public LopHoc(String maLP, String tenLP, String ngayMo, int n, Nguoi giaoVien) {
        this.maLP = maLP;
        this.tenLP = tenLP;
        this.ngayMo = ngayMo;
        this.n = n;
        this.giaoVien = giaoVien;
    }

    public String getMaLP() {
        return maLP;
    }

    public void setMaLP(String maLP) {
        this.maLP = maLP;
    }

    public String getTenLP() {
        return tenLP;
    }

    public void setTenLP(String tenLP) {
        this.tenLP = tenLP;
    }

    public String getNgayMo() {
        return ngayMo;
    }

    public void setNgayMo(String ngayMo) {
        this.ngayMo = ngayMo;
    }

    public ArrayList<SinhVien> getX() {
        return x;
    }

    public void setX(ArrayList<SinhVien> x) {
        this.x = x;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public Nguoi getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(Nguoi giaoVien) {
        this.giaoVien = giaoVien;
    }
    
    public void Input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã lớp học: ");
        this.maLP = sc.nextLine();
        System.out.print("Nhập tên lớp học: ");
        this.tenLP = sc.nextLine();
        System.out.print("Nhập ngày mở: ");
        this.ngayMo = sc.nextLine();
        System.out.print("Nhập số lượng sinh viên: ");
        this.n = sc.nextInt();
        for(int i = 0; i < this.n; i++){
            System.out.print("\nNhập thông tin sinh viên thứ " + (i + 1));
            SinhVien temp = new SinhVien();
            temp.Input();
            x.add(temp);
        }
        System.out.print("\nNhập thông tin giáo viên");
        giaoVien = new Nguoi();
        giaoVien.Input();
    }
    
    public void Output(){
        System.out.println("\t--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\t\tMã lớp học: " + this.maLP);
        System.out.println("\t\tTên lớp học: " + this.tenLP);
        System.out.println("\t\tNgày mở: " + this.ngayMo);
        System.out.println("\t----------------------------------Thông tin sinh viên----------------------------------");
        System.out.printf("%30s %15s %30s %20s %20s %10s\n", "Họ tên", "Ngày sinh", "Quê quán", "Mã SV", "Nghành", "Khóa học");
        
        for(SinhVien i : x){
            i.Output();
        }
            
        System.out.println("\t----------------------------------Thông tin giáo viên ----------------------------------");
        System.out.printf("%30s %15s %30s\n", "Họ tên", "Ngày sinh", "Quê quán");
        giaoVien.Output();
    }
    
    public int CountK14(){
        int Count = 0;
        for(SinhVien i : x)
            if(i.getKhoaHoc() == 14)
                Count++;
        return Count;
    }
    
    public void SapXep(){
        for(int i = 0; i < x.size() - 1; i++){
            for(int j = x.size() - 1; j > i; j--){
                if(x.get(j - 1).getKhoaHoc() > x.get(j).getKhoaHoc()){
                    SinhVien tmp = x.get(j - 1);
                    x.set(j - 1, x.get(j));
                    x.set(j, tmp);
                }
            }
        }
    }
}
