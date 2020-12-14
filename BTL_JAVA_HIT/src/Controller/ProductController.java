package Controller;

import BTL.*;
import Controller.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class ProductController {
    final String PRODUCT_FILE_NAME = "PRODUCT.DAT";
    final String BILL_FILE_NAME = "BILL.DAT";
    FileController fileController = new FileController();
    CheckAll checkAll = new CheckAll();
    Scanner sc = new Scanner(System.in);
    List<Product> listPro = fileController.ReadProductsFromFile(PRODUCT_FILE_NAME);
    List<Bill> listBill;
    
    private int Choose(int fir, int last){
        int choise;
        System.out.print("Enter your choise: ");
        do {
            choise = sc.nextInt();
            sc.nextLine();
            if(choise < fir || choise > last){
                System.out.print("Enter your choise again: ");
            }
        }while(choise < fir || choise > last);
        return choise;
    }
    
    public void ShowAllListProduct(){
        listPro.forEach((i) -> {
            System.out.println(i);
        });
    }
    public void UpdateListProduct() {
        System.out.println("---------------------Update products------------------------");
        System.out.println("1. Insert a new product");
        System.out.println("2. Delete a product by id");
        System.out.println("3. Repair a product by id");
        System.out.println("0. Exit");
        System.out.println("------------------------------------------------------------");
        int choise = 0;
        boolean check = true;
        
        choise = Choose(0, 3);
        
        switch(choise){
            case 1:
                Product pro = new Product();
                pro.Input();
                listPro = fileController.ReadProductsFromFile(PRODUCT_FILE_NAME);
                listPro.add(pro);
                fileController.UpdateProductFile(listPro, PRODUCT_FILE_NAME);
                break;
            case 2:
                int id = 0;
                System.out.print("Enter productId to delete: ");
                do {
                    id = sc.nextInt();
                    if(checkAll.CheckIdProduct(id)){
                        check = false;
                    }else {
                        check = true;
                        System.out.print("Enter productId again: ");
                    }
                }while(check);
                listPro = fileController.ReadProductsFromFile(PRODUCT_FILE_NAME);
                for(Product i : listPro){
                    if(id == i.getProductId()){
                        listPro.remove(i);
                        break;
                    }
                }
                fileController.UpdateProductFile(listPro, PRODUCT_FILE_NAME);
                break;
            case 3:
                id = 0;
                check = true;
                System.out.print("Enter productId to delete: ");
                do {
                    id = sc.nextInt();
                    if(checkAll.CheckIdProduct(id)){
                        check = false;
                    }else {
                        check = true;
                        System.out.print("Enter productId again: ");
                    }
                }while(check);
                listPro = fileController.ReadProductsFromFile(PRODUCT_FILE_NAME);
                for(Product i : listPro){
                    if(id == i.getProductId()){
                        System.out.println("-------------------------------------------------");
                        System.out.println("1. Repair id");
                        System.out.println("2. Repair name");
                        System.out.println("3. Repair quantily");
                        System.out.println("4. Repair price");
                        System.out.println("5. Repair type");
                        System.out.println("-------------------------------------------------");
                        
                        int choise2 = Choose(1, 5);
                        
                        switch(choise2){
                            case 1:
                                boolean check2 = true;
                                int id2 = 0;
                                System.out.print("Enter id: ");
                                do {
                                    id2 = sc.nextInt();
                                    if(checkAll.CheckIdProduct(id2)){
                                        check2 = true;
                                        System.out.print("Enter id again: ");
                                    }else {
                                        check2 = false;
                                    }
                                }while(check2);
                                i.setProductId(id2);
                                break;
                            case 2:
                                i.setProductName(sc.nextLine());
                                break;
                            case 3:
                                i.setQuantily(sc.nextInt());
                                sc.nextLine();
                                break;
                            case 4: 
                                i.setPrice(sc.nextDouble());
                                sc.nextLine();
                                break;
                            case 5: 
                                String[] spec = {"Drink", "Cake", "FastFood", "Rice"};
                                
                                System.out.println("----------------Type---------------");
                                System.out.println("0. Drink");
                                System.out.println("1. Cake");
                                System.out.println("2. FastFood");
                                System.out.println("3. Rice");
                                System.out.println("-----------------------------------");
                                System.out.print("Enter productType: ");
                                int choise3 = 0;
                                do {
                                    choise3 = sc.nextInt();
                                    if(choise3 < 0 || choise3 > 3){
                                        System.out.print("Enter productType again: ");
                                    }
                                }while(choise3 < 0 || choise3 > 3);
                                i.setProductType(spec[choise3]);
                                break;
                            }
                        break;
                    }
                }
                fileController.UpdateProductFile(listPro, PRODUCT_FILE_NAME);
                break;
            case 0:
                return;
        }
    }
    
    public void SortListProduct() {
        System.out.println("------------------Sort list product-------------------");
        System.out.println("1. Sort by id");
        System.out.println("2. Sort by name");
        System.out.println("3. Sort by quantily");
        System.out.println("4. Sort by price");
        System.out.println("5. Sort by type");
        System.out.println("0. Exit");
        System.out.println("------------------------------------------------------");
                
        int choise = choise = Choose(0, 5);;
        
        listPro = fileController.ReadProductsFromFile(PRODUCT_FILE_NAME);
        switch(choise){
            case 1:
                listPro.sort((o1, o2) -> {
                    if(o1.getProductId() < o2.getProductId())
                        return -1;
                    else if(o1.getProductId() > o2.getProductId())
                        return 1;
                    else 
                        return 0;
                });
                System.out.println("Sort by id successful");
                break;
            case 2:
                listPro.sort((o1, o2) -> {
                    if(o1.getProductName().compareTo(o2.getProductName()) < 0)
                        return -1;
                    else if(o1.getProductName().compareTo(o2.getProductName()) > 0)
                        return 1;
                    else 
                        return 0;
                });
                System.out.println("Sort by name successful");
                break;
            case 3:
                listPro.sort((o1, o2) -> {
                    if(o1.getQuantily()< o2.getQuantily())
                        return -1;
                    else if(o1.getQuantily() > o2.getQuantily())
                        return 1;
                    else 
                        return 0;
                });
                System.out.println("Sort by quantily successful");
                break;
            case 4:
                listPro.sort((o1, o2) -> {
                    if(o1.getPrice()< o2.getPrice())
                        return -1;
                    else if(o1.getPrice()> o2.getPrice())
                        return 1;
                    else 
                        return 0;
                });
                System.out.println("Sort by price successful");
                break;
            case 5: 
                listPro.sort((o1, o2) -> {
                    if(o1.getProductType().compareTo(o2.getProductType()) < 0)
                        return -1;
                    else if(o1.getProductType().compareTo(o2.getProductType()) > 0)
                        return 1;
                    else 
                        return 0;
                });
                System.out.println("Sort by type successful");
                break;
            case 0:
                break;
        }
        fileController.UpdateProductFile(listPro, PRODUCT_FILE_NAME);
    }
    
    public void SearchAndShowInfoProduct() {
        listPro = fileController.ReadProductsFromFile(PRODUCT_FILE_NAME);
        boolean check = false;
        String name;
        
        System.out.println("---------------------Search and show info product----------");
        System.out.println("1. Search by id");
        System.out.println("2. Search by name");
        System.out.println("3. Search by type");
        System.out.println("0. Exit");
        System.out.println("------------------------------------------------------------");
        
        int choise = Choose(0, 5);
        
        switch(choise){
            case 1:
                int id;
                System.out.print("Enter id to search: ");
                id = sc.nextInt();
                for(Product i : listPro){
                    if(i.getProductId() == id){
                        check = true;
                        System.out.println(i);
                        break;
                    }
                }
                if(check == false){
                    System.out.println("\nThis product not contain in shop");
                }
                break;
            case 2:
                check = false;
                System.out.print("Enter name of product to search: ");
                name = sc.nextLine();
                for(Product i : listPro){
                    if(i.getProductName().compareTo(name) == 0){
                        check = true;
                        System.out.println(i);
                        break;
                    }
                }
                if(check == false){
                    System.out.println("\nThis product not contain in shop");
                }
                break;
            case 3:
                check = false;
                System.out.print("Enter type of product to search: ");
                name = sc.nextLine();
                for(Product i : listPro){
                    if(i.getProductType().compareTo(name) == 0){
                        check = true;
                        System.out.println(i);
                        break;
                    }
                }
                if(check == false){
                    System.out.println("\nThis product not contain in shop");
                }
                break;
            case 0: 
                break;
        }
    }
    
    public void BuyProductOnline(String user){
        listPro = fileController.ReadProductsFromFile(PRODUCT_FILE_NAME);
        ShowAllListProduct();
        int quantily;
        int curQuantily;
        double money = 0;
        System.out.print("Enter number of product you buy: " );
        int n = sc.nextInt();
        int id = 0;
        List<Product> listProduct = new ArrayList();
        for(int i = 0; i < n; i++){
            Product tmp = new Product();
            do {
                System.out.print("Enter id of product you buy " + (i + 1) + ": ");
                do {
                    id = sc.nextInt();
                    Product newPro = new Product();
                    tmp = newPro.getProductById(id);
                    if(tmp == null){
                        System.out.println("Sorry. My store don't have this product!!");
                        System.out.print("Enter id again: ");
                    }
                }while(tmp == null);
                curQuantily = tmp.GetQuantilyById(id);
               
                System.out.print("Enter quantitly: ");
                do {
                    quantily = sc.nextInt();
                    if(curQuantily == 0){
                        System.out.println("This product is out of stock\nPlease choose another product.");
                        break;
                    }
                    if(quantily > curQuantily){
                        System.out.print("The number of goods is not enough. Current only " + curQuantily);
                        System.out.print("\nPlease re-select: ");
                    }
                }while(quantily > curQuantily);
            }while(curQuantily == 0);
            
            curQuantily -= quantily;
            
            for(Product j : listPro){
                if(j.getProductId() == id){
                    j.setQuantily(curQuantily);
                    break;
                }
            }
            tmp.setQuantily(quantily);
            money += tmp.getPrice() * tmp.getQuantily();
            listProduct.add(tmp);
        }
        
        fileController.UpdateProductFile(listPro, PRODUCT_FILE_NAME);
        listBill = fileController.ReadBillsFromFile(BILL_FILE_NAME);
        Bill bill = new Bill();
        bill.setBillId(bill.GetMaxIdInListBill() + 1);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        bill.setDateOfPurchase(simpleDateFormat.format(date));
        bill.setUserNameOfCus(user);
        bill.setProductBought(listProduct);
        listBill.add(bill);
        fileController.UpdateBillFile(listBill, BILL_FILE_NAME);
        System.out.println("\nThis is your bill");
        System.out.println(bill);
        System.out.println("\nThe amount you pay is: " + money);
    }
    
    public void BuyProductOffline(){
        listPro = fileController.ReadProductsFromFile(PRODUCT_FILE_NAME);
        ShowAllListProduct();
        int quantily;
        int curQuantily;
        double money = 0;
        System.out.print("Enter number of product you buy:" );
        int n = sc.nextInt();
        int id = 0;
        List<Product> listProduct = new ArrayList();
        for(int i = 0; i < n; i++){
            System.out.print("Enter id of product you buy " + (i + 1) + ": ");
            Product tmp = new Product();
            do {
                do {
                    id = sc.nextInt();
                    Product newPro = new Product();
                    tmp = newPro.getProductById(id);
                    if(tmp == null){
                        System.out.println("Sorry. My store don't have this product!!");
                        System.out.print("Enter id again: ");
                    }
                }while(tmp == null);
                System.out.print("Enter quantitly: ");
                do {
                    quantily = sc.nextInt();
                    curQuantily = tmp.GetQuantilyById(id);
                    if(quantily > curQuantily){
                        System.out.print("The number of goods is not enough. Current only " + curQuantily);
                        System.out.print("\nPlease re-select: ");
                    }
                }while(quantily > curQuantily);

                tmp.setQuantily(quantily);
                money += tmp.getPrice() * tmp.GetMoney();
                
                curQuantily -= quantily;
                for(Product j : listPro){
                    if(j.getProductId() == id){
                        j.setQuantily(curQuantily);
                        break;
                    }
                }
            }while(tmp == null);
            listProduct.add(tmp);
        }
        System.out.println("\nThe amount you pay is: " + money);
        if(money >= 1000000){
            System.out.println("You are a VIPer => your amount is: " + (money - money * 0.1));
        }
        
        Bill bill = new Bill();
        bill.setBillId(bill.GetMaxIdInListBill() + 1);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        bill.setDateOfPurchase(simpleDateFormat.format(date));
        bill.setUserNameOfCus("");
        bill.setProductBought(listProduct);
        
        fileController.UpdateProductFile(listPro, PRODUCT_FILE_NAME);
        listBill = fileController.ReadBillsFromFile(BILL_FILE_NAME);
        listBill.add(bill);
        fileController.UpdateBillFile(listBill, BILL_FILE_NAME);
        
        System.out.println("This is your bill\n");
        System.out.println(bill);
    }
}
