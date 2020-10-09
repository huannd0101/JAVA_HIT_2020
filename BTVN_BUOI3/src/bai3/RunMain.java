
package bai3;

public class RunMain {
    public static void main(String[] args) {
        HangHoa hang1 = new HangHoa("MaHang1", "Chuối", 5000, 2);
        HangHoa hang2 = new HangHoa();
        hang2.setMaHang("MaHang2");
        hang2.setTenHang("Bưởi");
        hang2.setDonGia(10000);
        hang2.setSoLuong(3);
        System.out.println("Thông tin hàng 1:");
        hang1.Xuat();
        System.out.println("\nThông tin hàng 2:");
        hang2.Xuat();
    }
}
