
package BTL;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Bill {
    private int billId;
    private String dateOfPurchase;
    private String userNameOfCus;
    private List<Product> productBought; 
    
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
    public Bill() {
    }

    public Bill(int billId, String dateOfPurchase, String userNameOfCus, List<Product> productBought) {
        this.billId = billId;
        this.dateOfPurchase = dateOfPurchase;
        this.userNameOfCus = userNameOfCus;
        this.productBought = productBought;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getUserNameOfCus() {
        return userNameOfCus;
    }

    public void setUserNameOfCus(String userNameOfCus) {
        this.userNameOfCus = userNameOfCus;
    }

    public List<Product> getProductBought() {
        return productBought;
    }

    public void setProductBought(List<Product> productBought) {
        this.productBought = productBought;
    }

   

    @Override
    public String toString() {
        return "Bill{" + "billId=" + billId + 
                ", dateOfPurchase=" + dateOfPurchase + 
                ", userName=" + userNameOfCus + 
                ", productBought=" + productBought + '}';
    }

    public double getSumPrice(){
        double sum = 0;
        for(Product i : this.productBought){
            sum += i.getPrice() * i.getQuantily();
        }
        return sum;
    }
    
    public void Input(){
        CheckAll checkAll = new CheckAll(); 
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        System.out.print("Enter billId: ");
        do {
            this.billId = sc.nextInt();
            sc.nextLine();
            if(checkAll.CheckIdBill(this.billId)){
                System.out.print("Enter billId again: ");
            }else {
                check = false;
            }
        }while(check);

        this.dateOfPurchase = simpleDateFormat.format(dateOfPurchase);
        System.out.println("Enter userName: ");
        check = true;
        do {
            this.userNameOfCus = sc.nextLine();
            check = checkAll.CheckUserNameAccount(this.userNameOfCus);
            if(!check){
                System.out.println("UserName not contain in shop");
                System.out.println("Please enter userName again: ");
            }
        }while(!check || this.userNameOfCus.compareTo("") != 0);
        System.out.print("Enter number of product: ");
        int n = sc.nextInt();
        List<Product> listProduct = new ArrayList<>();
        for(int i = 0; i < n; i++){
            Product pro = new Product();
            pro.InputCheckContain();
            listProduct.add(pro);
        }
        this.productBought = listProduct;
    }
    
    public void InputCheckIdContain(){
        CheckAll checkAll = new CheckAll(); 
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        System.out.print("Enter billId: ");
        do {
            this.billId = sc.nextInt();
            sc.nextLine();
            if(checkAll.CheckIdBill(this.billId)){
                System.out.print("Enter billId again: ");
            }else {
                check = false;
            }
        }while(check);
        System.out.print("Enter date of purchase: ");
        this.dateOfPurchase = sc.nextLine();
        System.out.println("Enter userName: ");
        this.userNameOfCus = sc.nextLine();
        System.out.print("Enter number of product: ");
        int n = sc.nextInt();
        List<Product> listProduct = new ArrayList<>();
        for(int i = 0; i < n; i++){
            Product pro = new Product();
            pro.Input();
            listProduct.add(pro);
        }
        this.productBought = listProduct;
    }
    
    public int GetMaxIdInListBill(){
        FileController file = new FileController();
        List<Bill> list = file.ReadBillsFromFile("BILL.DAT");
        int max = list.get(0).getBillId();
        for(Bill i : list)
            max = (i.getBillId() < max) ? max : i.getBillId();
        
        return max;
    }
    
    
    
}
