
package Bai1;

import java.util.Scanner;

public class DieuHoa extends SanPham{
    private int congSuat;
    private double giaBan;

    public DieuHoa() {
    }

    public DieuHoa(int congSuat, double giaBan) {
        this.congSuat = congSuat;
        this.giaBan = giaBan;
    }
    
    public int getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(int congSuat) {
        this.congSuat = congSuat;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        super.Nhap();
        System.out.print("Nhập công suất: ");
        this.congSuat = sc.nextInt();
        System.out.print("Nhập gia bán: ");
        this.giaBan = sc.nextFloat();
        sc.nextLine();
    }
    
    @Override
    public void Xuat(){
        super.Xuat();
        System.out.printf("%15d %15f\n", this.congSuat, this.giaBan);
    }
}
