
package Bai2;

import java.util.ArrayList;
import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<NhanSu> list = new ArrayList<>();
        
        System.out.print("Nhập số nhân sự: ");
        int n = sc.nextInt();
        
        for(int i = 0; i < n; i++){
            NhanSu x = new NhanSu();
            System.out.println("\nNhập thông tin nhân sự thứ " + (i + 1));
            x.Nhap();
            list.add(x);
        }
        
        System.out.println("\n-------------Danh sách nhân sự----------------");
        for(NhanSu i : list)
            System.out.println(i);
        
    }
}
