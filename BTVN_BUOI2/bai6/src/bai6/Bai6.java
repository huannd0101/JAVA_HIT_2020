
package bai6;

import java.util.Scanner;

public class Bai6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        System.out.print("Nhập chuỗi: ");
        str = sc.nextLine();
        str = str.trim();
        while(str.indexOf("  ") != -1)
            str = str.replaceAll("  ", " ");
//        str = str.replaceAll("\\s+", " "); //xóa khoảng trắng thừa giữa các từ cách 2
        str = str.toLowerCase();
        String[] a = str.split(" ");
        str = "";
        for(int i = 0; i < a.length; i++){
            str += String.valueOf(a[i].charAt(0)).toUpperCase() + a[i].substring(1);
            if(i < a.length - 1)
                str += " ";
        }
        System.out.println(str);
    }
    
}
