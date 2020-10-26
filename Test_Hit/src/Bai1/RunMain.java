package Bai1;

import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
//        System.out.print("Nhập chuỗi: ");
//        String str = sc.nextLine();
        String str = "bn01da6d47";
        
        int sum = 0;
        int mul = 1;
        int Count = 0;
        for(int i = 0; i < str.length(); i++){
            if(Character.isDigit(str.charAt(i))){
                Count++;
                sum += Integer.parseInt(String.valueOf(str.charAt(i)));
            }
        }
        
        for(int i = 0; i < str.length(); i++){
            if(Character.isDigit(str.charAt(i))){
                int a = Integer.parseInt(String.valueOf(str.charAt(i)));
                if(a != 0)
                    if(sum % a == 0)
                        mul *= a;
            }
        }
        
     
        System.out.println("Có " + Count + " ký tự số và tích = " + mul);
        
        
    }
}
