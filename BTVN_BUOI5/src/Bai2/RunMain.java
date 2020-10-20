
package Bai2;

public class RunMain {
    public static void main(String[] args) {
        SoPhuc p1 = new SoPhuc();
        SoPhuc p2 = new SoPhuc();
        System.out.println("Nhập số phức p1");
        p1.Nhap();
        System.out.println("Nhập số phức p2");
        p2.Nhap();
        
        SoPhuc temp = p1.Cong(p2);
        System.out.print("p1 + p2 = ");
        temp.Xuat();
        
        temp = p1.Tru(p2);
        System.out.print("p1 - p2 = ");
        temp.Xuat();
    }
}
