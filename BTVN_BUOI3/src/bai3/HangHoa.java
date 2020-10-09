
package bai3;

public class HangHoa {
    private String maHang;
    private String tenHang;
    private double donGia;
    private int soLuong;

    public HangHoa() {
        
    }

    public HangHoa(String maHang, String tenHang, double donGia, int soLuong) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    public void Xuat(){
        System.out.println("Mã hàng: " + this.getMaHang());
        System.out.println("Tên hàng: " + this.getTenHang());
        System.out.println("Đơn giá: " + this.getDonGia());
        System.out.println("Số lượng: " + this.getSoLuong());
        System.out.println("Thành tiền: " + this.getDonGia() * this.getSoLuong());
    }
}
