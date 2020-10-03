
package bai5;

import java.util.Scanner;

public class Bai5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        System.out.print("Nhập chuỗi: ");
        str = sc.nextLine();
        int s = 0;
        int Count = 0;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(Character.isDigit(c)){
                Count++;
                s += Integer.parseInt(String.valueOf(c));
            }
        }
        if(Count == 0)
            System.out.println("Không có số trong chuỗi");
        else
            System.out.println(1.0 * s / Count);
    }
    
}
