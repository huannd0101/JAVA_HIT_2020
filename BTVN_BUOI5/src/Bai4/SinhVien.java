
package Bai4;

import java.util.Scanner;

public class SinhVien {
    private String id;
    private String name;
    private int age;
    private String address;
    private double gpa;

    public SinhVien() {
    }

    public SinhVien(String id, String name, int age, String address, double gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    
    public void Input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ID: ");
        this.id = sc.nextLine();
        System.out.print("Nhập tên: ");
        this.name = sc.nextLine();
        System.out.print("Nhập tuổi: ");
        this.age = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhập địa chỉ: ");
        this.address = sc.nextLine();
        System.out.print("Nhập điểm trung bình: ");
        this.gpa = sc.nextDouble();
        sc.nextLine();
    }
    
    public void Output(){
        System.out.printf("%20s %30s %10d %30s %15f\n", this.id, this.name, this.age, this.address, this.gpa);
    }
}
