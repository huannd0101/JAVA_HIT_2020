
package Bai5;

import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LopHoc lopHoc = new LopHoc();
        
        lopHoc.Input();
        System.out.println("\n\n\t\t\t\t\t\t Thông tin lớp học vừa nhập");
        lopHoc.Output();
        
        System.out.println("\n\n\tLớp học có \'" + lopHoc.CountK14() + "\' sinh viên k14");
        
        lopHoc.SapXep();
        System.out.println("\n\n\t\t\t\t\t\t Thông tin lớp học sau khi sắp xếp");
        lopHoc.Output();
    }      
}
