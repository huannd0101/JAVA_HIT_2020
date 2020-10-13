
package Bai1;

import java.util.ArrayList;
import java.util.Scanner;

public class RunMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Sach> listBook = new ArrayList<>();
        int n;
        System.out.print("Nhập số lượng sách: ");
        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            System.out.println("\nNhập thông tin sách thứ " + (i + 1));
            Sach x = new Sach();
            x.Nhap();
            listBook.add(x);
        }
        
        System.out.println("\n-----------------------List Book----------------------------");
        for(Sach i : listBook){
            System.out.println(i);
        }
    }
}
