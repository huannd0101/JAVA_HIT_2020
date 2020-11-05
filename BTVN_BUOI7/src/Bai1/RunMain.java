
package Bai1;

public class RunMain {
    public static void main(String[] args) {
        Person person1 = new Employee("Huân", "Điện Biên", 999999999);
        Person person2 = new Customer("Khải", "Hà Nội", 1000);
        
        person1.display();
        System.out.println("");
        person2.display();
    }
}
