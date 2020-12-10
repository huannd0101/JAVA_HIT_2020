package De1;

import java.util.*;

public class Products {
    private int id = 0;
    private String name;
    private double price;
    private int quantily;

    public Products() {
    }

    public Products(int id, String name, double price, int quantily) {
        this.id = id++;
        this.name = name;
        this.price = price;
        this.quantily = quantily;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantily() {
        return quantily;
    }

    public void setQuantily(int quantily) {
        this.quantily = quantily;
    }

    @Override
    public String toString() {
        return "Products{" + "id=" + id + ", name=" + name + ", price=" + price + ", quantily=" + quantily + '}';
    }
    
    public void Input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id: ");
        this.id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter name: ");
        this.name = sc.nextLine();
        System.out.print("Enter price: ");
        this.price = sc.nextDouble();
        System.out.print("Enter quantily: ");
        this.quantily = sc.nextInt();
    }
}
