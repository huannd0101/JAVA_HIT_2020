package Bai2;

import java.util.Scanner;

public class Book extends Document{
    private int numOfPage;
    private String author;

    public Book() {
    }

    public Book(int numOfPage, String author) {
        this.numOfPage = numOfPage;
        this.author = author;
    }

    public Book(int numOfPage, String author, int id, String name, String publisher, double price) {
        super(id, name, publisher, price);
        this.numOfPage = numOfPage;
        this.author = author;
    }

    public int getNumOfPage() {
        return numOfPage;
    }

    public void setNumOfPage(int numOfPage) {
        this.numOfPage = numOfPage;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void Input(){
        Scanner sc = new Scanner(System.in);
        super.Input();
        System.out.print("Nhập numOfPage: ");
        this.numOfPage = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhập author: ");
        this.author = sc.nextLine();
    }

    @Override
    public String toString() {
        
        return "Document{" + "id=" + id + ", name=" + name + ", publisher=" + publisher + ", price=" + price +
                " Book{" + "numOfPage=" + numOfPage + ", author=" + author + '}';
    }
    
}
