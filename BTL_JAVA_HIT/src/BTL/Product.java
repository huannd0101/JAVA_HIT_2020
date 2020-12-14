
package BTL;

import Controller.FileController;
import java.util.*;

public class Product {
    private int productId;
    private String productName;
    private int quantily;
    private double price;
    private String productType;

    public Product() {
    }

    public Product(int productId, String productName, int quantily, double price, String productType) {
        this.productId = productId;
        this.productName = productName;
        this.quantily = quantily;
        this.price = price;
        this.productType = productType;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantily() {
        return quantily;
    }

    public void setQuantily(int quantily) {
        this.quantily = quantily;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "\nProduct{" + 
                "productId=" + productId + 
                ", productName=" + productName + 
                ", quantily=" + quantily + 
                ", price=" + price + 
                ", productType=" + productType + 
                '}';
    }
    
    public void Input(){
        CheckAll checkAll = new CheckAll();
        Scanner sc = new Scanner(System.in);
        boolean checkId = true;
        System.out.print("Enter productId: ");
        do{
            this.productId = sc.nextInt();
            checkId = checkAll.CheckIdProduct(this.productId);
            if(checkId){
                System.out.print("Enter productId again: ");
            }
        }while(checkId);
        sc.nextLine();
        System.out.print("Enter productName: ");
        this.productName = sc.nextLine();
        System.out.print("Enter quantily: ");
        this.quantily = sc.nextInt();
        System.out.print("Enter price: ");
        this.price = sc.nextDouble();
        System.out.println("----------------Type---------------");
        System.out.println("0. Drink");
        System.out.println("1. Cake");
        System.out.println("2. FastFood");
        System.out.println("3. Rice");
        System.out.println("-----------------------------------");
        System.out.print("Enter productType: ");
        int choise = 0;
        do {
            choise = sc.nextInt();
            if(choise < 0 || choise > 3){
                System.out.print("Enter productType again: ");
            }
        }while(choise < 0 || choise > 3);
        String[] spec = {"Drink", "Cake", "FastFood", "Rice"};
        this.productType = spec[choise];
    }
    
    public void InputCheckContain(){
        CheckAll checkAll = new CheckAll();
        Scanner sc = new Scanner(System.in);
        boolean checkId = true;
        System.out.print("Enter productId: ");
        do{
            this.productId = sc.nextInt();
            checkId = !checkAll.CheckIdProduct(this.productId);
            if(checkId){
                System.out.println("Id not contain of shop");
                System.out.print("Enter productId again: ");
            }
        }while(checkId);
        sc.nextLine();
        System.out.print("Enter productName: ");
        this.productName = sc.nextLine();
        System.out.print("Enter quantily: ");
        this.quantily = sc.nextInt();
        System.out.print("Enter price: ");
        this.price = sc.nextDouble();
        System.out.println("----------------Type---------------");
        System.out.println("0. Drink");
        System.out.println("1. Cake");
        System.out.println("2. FastFood");
        System.out.println("3. Rice");
        System.out.println("-----------------------------------");
        System.out.print("Enter productType: ");
        int choise = 0;
        do {
            choise = sc.nextInt();
            if(choise < 0 || choise > 3){
                System.out.print("Enter productType again: ");
            }
        }while(choise < 0 || choise > 3);
        String[] spec = {"Drink", "Cake", "FastFood", "Rice"};
        this.productType = spec[choise];
    }
    
    public Product getProductById(int id){
        FileController file = new FileController();
        List<Product> list = file.ReadProductsFromFile("PRODUCT.DAT");
        for(Product i : list)
            if(i.getProductId() == id)
                return i;
        return null;
    }
          
    public double GetMoney(){
        return this.getPrice() * this.getQuantily();
    }
    
    public int GetQuantilyById(int id){
        FileController file = new FileController();
        List<Product> list = file.ReadProductsFromFile("PRODUCT.DAT");
        for(Product i : list)
            if(i.getProductId() == id)
                return i.getQuantily();
        return -1;
    }
}
