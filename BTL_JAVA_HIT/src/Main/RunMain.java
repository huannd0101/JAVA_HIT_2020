package Main;

import BTL.*;
import Controller.*;
import java.util.*;
import java.util.regex.Pattern;

public class RunMain {
    static Scanner sc = new Scanner(System.in);
   
    static final String PRODUCT_FILE_NAME = "PRODUCT.DAT";
    static final String BILL_FILE_NAME = "BILL.DAT";
    static final String CUSTOMER_FILE_NAME = "CUSTOMER.DAT";
    static final String ACC_FILE_NAME = "ACC.DAT";
    static final String STORE_FILE_NAME = "STORE.DAT";
    
    static Pattern pattern;
    static String regUserName = "^[a-zA-Z0-9]{5,}$";
    static String regPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,}$";
    static String regPhone = "^[0-9\\-\\+]{9,15}$";
    static String regEmail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    
    static List<Product> listPro;
    static List<Bill> listBill;
    static List<Customer> listCus;
    static List<Account> listAcc;
    
    static FileController fileController = new FileController();
    static CheckAll checkAll = new CheckAll();
    static AccController accController = new AccController();
    static ProductController productController = new ProductController();
    static BillController billController = new BillController();
    static CustomerController customerController = new CustomerController();
    
    public static void main(String[] args) {
        do {
            System.out.println("-----------------------Hello------------------------");
            System.out.println("--------------------Who are you---------------------");
            System.out.println("1. Store owner");
            System.out.println("2. Customer");
            System.out.println("0. Exit");
            System.out.println("----------------------------------------------------");
            int choise = Choose(0, 2);
        
            switch(choise){
                case 1:
                    StoreOwner();
                    break;
                case 2:
                    Customers();
                case 0:
                    System.exit(0);
            }
            fileController.UpdateStore(STORE_FILE_NAME);
        }while(true);
    }
    private static int Choose(int fir, int last){
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
    private static void LoginWithStoreOwner(){
        listAcc = fileController.ReadAccountFromFile(ACC_FILE_NAME);
        String user, pass;
        boolean checkUser, checkPass;
        do {
            System.out.print("Enter user name: ");
            user = sc.nextLine();
            System.out.print("Enter password: ");
            pass = sc.nextLine();
            checkUser = checkAll.CheckUserNameAccount(user) && user.compareTo("admin") == 0;
            checkPass = checkAll.CheckPasswordAccount(pass);
            if(checkUser && checkPass){
                System.out.println("Login successfull");
            }else if(checkUser){
                System.out.println("Password is wrong");
            }else if(checkPass){
                System.out.println("User name is not contain");
            }else {
                System.out.println("This account is not contain");
            }
        }while(!checkUser || !checkPass);
    }
    private static void StoreOwner() {
        LoginWithStoreOwner();
        int choise = 0;
        do {
            System.out.println("-----------------You are store owner-------------------");
            System.out.println("1. Show all list product");
            System.out.println("2. Update list product");
            System.out.println("3. Show all list bill");
            System.out.println("4. Update list bill");
            System.out.println("5. Show all list customer");
            System.out.println("6. Show all VIP customer");
            System.out.println("7. Update list customer");
            System.out.println("8. Show all list account");
            System.out.println("9. Update list account");
            System.out.println("10.Sort list product");
            System.out.println("11.Sort list bill");
            System.out.println("12.Sort list customer");
            System.out.println("13.Sort list account");
            System.out.println("14.Search and show info product");
            System.out.println("15.Search and show info bill");
            System.out.println("16.Search and show info customer");
            System.out.println("17.Search and show info account");
            System.out.println("18.Show my info shop and total revenue");
            System.out.println("0. Exit");
            System.out.println("-------------------------------------------------------");
            choise = Choose(0, 19);
            switch(choise){
                case 1:
                    productController.ShowAllListProduct();
                    break;
                case 2:
                    productController.UpdateListProduct();
                    break;
                case 3:
                    billController.ShowAllListBill();
                    break;
                case 4:
                    billController.UpdateListBill(); 
                    break;
                case 5:
                    customerController.ShowAllListCustomer();
                    break;
                case 6:
                    customerController.ShowAllListVIPCustomer();
                    break;
                case 7:
                    customerController.UpdateListCustomer();
                    break;
                case 8:
                    accController.ShowAllList();
                    break;
                case 9:
                    accController.UpdateListAccount();
                    break;
                case 10:
                    productController.SortListProduct();
                    break;
                case 11:
                    billController.SortListBill();
                    break;    
                case 12:
                    customerController.SortListCustomer();
                    break;
                case 13:
                    accController.SortListAccount();
                    break;
                case 14:
                    productController.SearchAndShowInfoProduct();
                    break;
                case 15:
                    billController.SearchAndShowInfoBill();
                    break;
                case 16:
                    customerController.SearchAndShowInfoCustomer();
                    break;
                case 17:
                    accController.SearchAndShowInfoAccount();
                    break;
                case 18:
                    ShowInfoMyStore();
                    break;
                case 0:
                    return;    
            }   
        }while(true);
    }
    
    private static void Customers() {
        int choise = 0;
        do {
            System.out.println("----------------------You are customer------------------");
            System.out.println("1. Purchase online form");
            System.out.println("2. Purchase by offline form");
            System.out.println("0. Exit");
            System.out.println("--------------------------------------------------------");
            choise = Choose(0, 2);  
            switch(choise){
                case 1:
                    PurchaseOnlineForm();
                    break;
                case 2:
                    PurchaseOnfflineForm();
                    break;
                case 0: 
                    return;
            }
        }while(true);
    }

    private static void PurchaseOnlineForm(){
        System.out.println("-------------------Purchase online form-----------------");
        System.out.println("1. Sign up for an account");
        System.out.println("2. Login");
        System.out.println("0. Exit");
        System.out.println("--------------------------------------------------------");
        int choise = Choose(0, 2);
        switch(choise){
            case 1:
                accController.SignUpForAnAccount();
                break;
            case 2:
                String user = accController.Login();
                LoginToShop(user);
                break;
            case 0: 
                break;
        }
    }

    private static void LoginToShop(String user){
        System.out.println("-------------------Purchase online form-----------------");
        System.out.println("1. Buy products");
        System.out.println("2. Change my password");
        System.out.println("0. Exit");
        System.out.println("--------------------------------------------------------");
        int choise = Choose(0, 2);
        switch(choise){
            case 1:
                AffterLogin(user);
                break;
            case 2:
                accController.ChangeMyPassword(user);
                break;
            case 0:
                return;
        }
    }
    
    private static void AffterLogin(String user){
        do {
            System.out.println("1. Show all list product");
            System.out.println("2. By products");
            System.out.println("3. Show my bills");
            System.out.println("4. I'm a VIP customer");
            System.out.println("0. Exit");
            int choise = Choose(0, 4);
            switch(choise){
                case 1:
                    productController.ShowAllListProduct();
                    break;
                case 2:
                    productController.BuyProductOnline(user);
                    break;
                case 3:
                    customerController.ShowAllBillOfCustomer(user);
                    break;
                case 4:
                    IsViper(user);
                    break;
                case 0:
                    return;
            }
        }while(true);
    }
    
    private static void IsViper(String user){
        if(checkAll.CheckViper(user)){
            System.out.println("\nYou was VIPer\n");
        }else {
            System.out.println("\nYou are not VIPer\n");
        }
    }
    
    private static void PurchaseOnfflineForm(){
        int choise = 0;
        do {
            System.out.println("-----------------Purchase by offline form----------------");
            System.out.println("1. Show all list product");
            System.out.println("2. By products");
            System.out.println("0. Exit");
            System.out.println("---------------------------------------------------------");
            
            choise = Choose(0, 2);
            switch(choise){
                case 1:
                    productController.ShowAllListProduct();
                    break;
                case 2:
                    productController.BuyProductOffline();
                    break;
                case 0:
                    return;
            }
        }while(true);
    }

    private static void ShowInfoMyStore() {
        fileController.OpenFileToRead(STORE_FILE_NAME);
        System.out.println("----------------Info of shop----------------");
        System.out.println("Id           : " + fileController.getScanner().nextLine());
        System.out.println("Name         : " + fileController.getScanner().nextLine());
        System.out.println("Phone number : " + fileController.getScanner().nextLine());
        System.out.println("Address      : " + fileController.getScanner().nextLine());
        String tmp;
        for(int i = 0; i < 4; i++)
            tmp = fileController.getScanner().nextLine();
        System.out.println("Total revenue: " + fileController.getScanner().nextLine() + " VNĐ");
    }
}