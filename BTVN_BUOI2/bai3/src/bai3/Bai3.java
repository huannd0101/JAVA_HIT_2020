
package bai3;

import java.util.Scanner;

public class Bai3 {
    public static int n;
    public static int[] a;
    public static void main(String[] args) {
        Menu();   
    }

    public static void Title(){
        System.out.println("\n------------------------Menu------------------------");
        System.out.println("1. Tạo và nhập mảng với n số nguyên.");
        System.out.println("2. Hiển thị mảng vừa tạo.");
        System.out.println("3. Thêm một phần tử vào vị trí k.");
        System.out.println("4. Xóa một phần tử tại vị trí k.");
        System.out.println("5. Đảo ngược mảng.");
        System.out.println("6. Hiển thị phần tử a[1] và các số chia hết cho a[1].");
        System.out.println("7. Thoát.");
        System.out.println("----------------------------------------------------");
    }
    
    public static void Menu(){
        Scanner sc = new Scanner(System.in);
        Title();
        boolean check = true;
        while(check){
            System.out.print("\nNhập lựa chọn của bạn: ");
            int c = sc.nextInt();
            switch(c){
                case 1:
                    Nhap();
                    break;
                case 2:
                    Xuat();
                    break;
                case 3:
                    Insert();
                    break;
                case 4:
                    Delete();
                    break;
                case 5: 
                    DaoNguoc();
                    break;
                case 6:
                    DisplayPhanTu();
                    break;
                case 7:
                    check = false;
            }
        }
    }
    
    private static void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n = ");
        n = sc.nextInt();
        a = new int[1000];
        for(int i = 0; i < n; i++){
            System.out.print("Nhập a[" + i + "] = ");
            a[i] = sc.nextInt();
        }
    }

    private static void Xuat() {
        for(int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
    }

    private static void Insert() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vị trí cần chèn: ");
        int k = sc.nextInt();
        System.out.print("Nhập giá trị cần chèn: ");
        int val = sc.nextInt();
        for(int i = n; i >= k; i--)
            a[i] = a[i - 1];
        a[k] = val;
        n++;
    }

    private static void Delete() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vị trí cần xóa: ");
        int k = sc.nextInt();
        for(int i = k; i < n - 1; i++)
            a[i] = a[i + 1];
        n--;
    }

    private static void DaoNguoc() {
        int[] b = new int[n];
        int j = 0;
        for(int i = n - 1; i >= 0; i--)
            b[j++] = a[i];
        for(int i = 0; i < n; i++)
            a[i] = b[i];
    }

    private static void DisplayPhanTu() {
        System.out.println("a[1] = " + a[1]);
        boolean check = false;
        for(int i = 0; i < n; i++){
            if(i == 1)
                continue;
            if(a[i] % a[1] == 0){
                check = true;
                break;
            } 
        }
        if(check){
            System.out.println("Các số chia hết cho " + a[1] + " là: ");
            for(int i = 0; i < n; i++){
                if(i == 1)
                    continue;
                if(a[i] % a[1] == 0)
                    System.out.print(a[i] + " ");
            }
        }else{
            System.out.println("Không có số nào chia hết cho " + a[1] + " ngoại trừ nó :v");
        }
    } 
}
