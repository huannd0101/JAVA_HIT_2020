
package Bai5;

public class RunMain {
    public static void main(String[] args) {
        Guns Player1 = new Guns("Aka 47", 50);
        Guns Player2 = new Guns("Soft Gun", 70);
        
        while(Player1.getAmmoNumber() > 0 && Player2.getAmmoNumber() > 0){
            Player1.Shoot(5);
            Player1.Load(2);
            Player2.Shoot(10);
            Player2.Load(5);
        }
        if(Player1.getAmmoNumber() == 0){
            System.out.println("Player1 thua với số đạn còn lại là: " + Player1.getAmmoNumber());
            System.out.println("Player2 thắng với số đạn còn lại là: " + Player2.getAmmoNumber());
        }else{
            System.out.println("Player1 thắng với số đạn còn lại là: " + Player1.getAmmoNumber());
            System.out.println("Player2 thua với số đạn còn lại là: " + Player2.getAmmoNumber());
        }
    }
}
