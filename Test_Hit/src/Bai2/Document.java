package Bai2;

import java.util.Scanner;

public class Document {
    protected int id;
    protected String name;
    protected String publisher;
    protected double price;

    public Document() {
    }

    public Document(int id, String name, String publisher, double price) {
        this.id = id;
        this.name = name;
        this.publisher = publisher;
        this.price = price;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public void Input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập id: ");
        this.id = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhập name: ");
        this.name = sc.nextLine();
        System.out.print("Nhập publisher: ");
        this.publisher = sc.nextLine();
        System.out.print("Nhập price: ");
        this.price = sc.nextDouble();
        sc.nextLine();
    }

    @Override
    public String toString() {
        return "Document{" + "id=" + id + ", name=" + name + ", publisher=" + publisher + ", price=" + price + '}';
    }
}
