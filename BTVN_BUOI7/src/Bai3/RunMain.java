
package Bai3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        List<News> list = new ArrayList<>();

        System.out.println("-------------menu--------------");
        System.out.println("\t1. Insert news");
        System.out.println("\t2. View list news");
        System.out.println("\t3. Average rate");
        System.out.println("\t4. Exit");
        System.out.println("-------------------------------");
        
        int choise = 0;
        while(true){
            System.out.print("\nNhập lựa chọn của bạn: ");
            choise = sc.nextInt();
            switch(choise){
                case 1: 
                    News x = new News();
                    System.out.print("Nhập id: ");
                    x.setId(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Nhập title: ");
                    x.setTitle(sc.nextLine());
                    System.out.print("Nhập publishDate: ");
                    x.setPublishDate(sc.nextLine());
                    System.out.print("Nhập author: ");
                    x.setAuthor(sc.nextLine());
                    System.out.print("Nhập content: ");
                    x.setContent(sc.nextLine());
                    System.out.println("Nhập thông tin rates");
                    x.InputRate();
                    list.add(x);
                    break;
                case 2:
                    for(int i = 0; i < list.size(); i++){
                        System.out.println("\nThông tin new thứ " + (i + 1));
                        list.get(i).Display();
                    }
                    break;
                case 3:
                    for(int i = 0; i < list.size(); i++){
                        list.get(i).Calculate();
                        System.out.println("\nThông tin new thứ " + (i + 1));
                        list.get(i).Display();
                    }
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
