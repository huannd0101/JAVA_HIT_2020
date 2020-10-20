
package Bai1;

import java.util.ArrayList;
import java.util.Scanner;

public class RunMain {
    
    public static void Title(){
        System.out.printf("%20s %30s %30s %15s %15s %15s\n", "Mã sản phẩm", "Tên sản phẩm", "Tên hãng sx", "Ngày nhập", "Công suất", "Giá bán");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n = ");
        int n = sc.nextInt();
        ArrayList<DieuHoa> myList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            System.out.println("\nNhập điều hòa thứ " + (i + 1));
            DieuHoa x = new DieuHoa();
            x.Nhap();
            myList.add(x);
        }
        
        if(n > 0){
            System.out.println("---------------------------------------------------Danh sách điều hòa---------------------------------------------------");
            Title();
            for(DieuHoa i : myList)
                i.Xuat();
        }
        
        double minGiaBan = myList.get(0).getGiaBan();
        for(DieuHoa i : myList)
            if(i.getGiaBan() < minGiaBan)
                minGiaBan = i.getGiaBan();
       
        boolean check = false;
        for(DieuHoa i : myList){
            if(i.getHangSX().compareToIgnoreCase("Electrolux") == 0 && i.getGiaBan() == minGiaBan){
                check = true;
                break;
            }
        }
        if(check){
            Title();
            for(DieuHoa i : myList)
                if(i.getHangSX().compareToIgnoreCase("Electrolux") == 0 && i.getGiaBan() == minGiaBan)
                    i.Xuat();
        }else
            System.out.println("-----------Không có sản phần nào đúng yêu cầu-----------");
    }
}
