
package Bai1;

public class RunMain {
    public static void main(String[] args) {
        Person DoanXinhGai = new Person();
        Person DiepBueDe = new Person();
        
        DoanXinhGai.setName("Doan");
        DoanXinhGai.setDateOfBirth("1/1/2001");
        DoanXinhGai.setGender("Nam");
        DoanXinhGai.setHobby("Tình Yêu Đồng Giới");
        
        DiepBueDe.setName("Điệp");
        DiepBueDe.setDateOfBirth("2/2/2000");
        DiepBueDe.setGender("Nam");
        DiepBueDe.setHobby("Thích Doan Vũ");
        
        System.out.println("------Thông tin của đối tượng DoanXinhGai------");
        System.out.println("Name: " + DoanXinhGai.getName());
        System.out.println("Birthday: " + DoanXinhGai.getDateOfBirth());
        System.out.println("Gender: " + DoanXinhGai.getGender());
        System.out.println("Hobby: " + DoanXinhGai.getHobby());
        
        System.out.println("");
        System.out.println("------Thông tin của đối tượng DiepBueDe-------");
        System.out.println("Name: " + DiepBueDe.getName());
        System.out.println("Birthday: " + DiepBueDe.getDateOfBirth());
        System.out.println("Gender: " + DiepBueDe.getGender());
        System.out.println("Hobby: " + DiepBueDe.getHobby());
    } 
}
