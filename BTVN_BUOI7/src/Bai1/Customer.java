
package Bai1;

public class Customer extends Person{
    private int balence;

    public Customer() {
    }

    public Customer(int balence) {
        this.balence = balence;
    }

    public Customer(String name, String address, int balence) {
        super(name, address);
        this.balence = balence;
    }

    public int getBalence() {
        return balence;
    }

    public void setBalence(int balence) {
        this.balence = balence;
    }
    
    @Override
    public void display(){
        System.out.println("Customer name: " + this.getName());
        System.out.println("Customer address: " + this.getAddress());
        System.out.println("Customer salary: " + this.balence);
    }
}
