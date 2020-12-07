package BTL;

import java.text.SimpleDateFormat;
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
    static String regUserName = "^[a-zA-Z0-9]{6,}$";
    static String regPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,}$";
    static String regPhone = "^[0-9\\-\\+]{9,15}$";
    static String regEmail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    
    static List<Product> listPro;
    static List<Bill> listBill;
    static List<Customer> listCus;
    static List<Account> listAcc;
    
    static FileController fileController = new FileController();
    static CheckAll checkAll = new CheckAll();
    
    
    public static void main(String[] args) {
        System.out.println("-----------------------Hello------------------------");
        System.out.println("--------------------Who are you---------------------");
        System.out.println("1. Store owner");
        System.out.println("2. Customer");
        System.out.println("0. Exit");
        System.out.println("----------------------------------------------------");
        int choise = 0;
        System.out.print("Enter your choise: ");
        do {
            choise = sc.nextInt();
            if(choise < 0 || choise > 2){
                System.out.print("Enter your choise again: ");
            }
        }while(choise < 0 || choise > 2);
        
        switch(choise){
            case 1:
                StoreOwner();
                break;
            case 2:
                Customers();
            case 3: 
                break;
        }
        fileController.UpdateStore(STORE_FILE_NAME);
    }

    private static void TitleOfStoreOwner(){
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
    }
    
    //Controll of store owner
    private static void StoreOwner() {
        int choise = 0;

        do {
            TitleOfStoreOwner();
            System.out.print("Enter your choise: ");
            do {
                choise = sc.nextInt();
                if(choise < 0 || choise > 19){
                    System.out.print("Enter your choise again: ");
                }
            }while(choise < 0 || choise > 19);

            switch(choise){
                case 1:
                    ShowAllListProduct();
                    break;
                case 2:
                    UpdateListProduct();
                    break;
                case 3:
                    ShowAllListBill();
                    break;
                case 4:
                    UpdateListBill(); 
                    break;
                case 5:
                    ShowAllListCustomer();
                    break;
                case 6:
                    ShowAllListVIPCustomer();
                    break;
                case 7:
                    UpdateListCustomer();
                    break;
                case 8:
                    ShowAllListAccount();
                    break;
                case 9:
                    UpdateListAccount();
                    break;
                case 10:
                    SortListProduct();
                    break;
                case 11:
                    SortListBill();
                    break;
                case 12:
                    SortListCustomer();
                    break;
                case 13:
                    SortListAccount();
                    break;
                case 14:
                    SearchAndShowInfoProduct();
                    break;
                case 15:
                    SearchAndShowInfoBill();
                    break;
                case 16:
                    SearchAndShowInfoCustomer();
                    break;
                case 17:
                    SearchAndShowInfoAccount();
                    break;
                case 18:
                    ShowInfoMyStore();
                    break;
                case 0:
                    return;    
            }   
        }while(true);
    }
    
    private static void TitleFirstOfCustomer(){
        System.out.println("----------------------You are customer------------------");
        System.out.println("1. Purchase online form");
        System.out.println("2. Purchase by offline form");
        System.out.println("0. Exit");
        System.out.println("--------------------------------------------------------");
    }
    
    private static void TitleSecondOfCustomer(){
        System.out.println("-------------------Purchase online form-----------------");
        System.out.println("1. Sign up for an account");
        System.out.println("2. Login to buy product");
        System.out.println("3. Change my password");
        System.out.println("0. Exit");
        System.out.println("--------------------------------------------------------");
    }
    
    private static void TitleThirstOfCustomer(){
        System.out.println("-----------------Purchase by offline form----------------");
        System.out.println("1. Sign up for an account");
        System.out.println("2. Show all list product");
        System.out.println("3. By products");
        System.out.println("0. Exit");
        System.out.println("---------------------------------------------------------");
    }
    
    //controll of customer
    private static void Customers() {
        int choise = 0;
        do {
            TitleFirstOfCustomer();
            System.out.print("Enter your choise: ");
            do {
                choise = sc.nextInt();
                if(choise < 0 || choise > 2){
                    System.out.print("Enter your choise again: ");
                }
            }while(choise < 0 || choise > 2);
                
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
        TitleSecondOfCustomer();
        int choise = 0;
        System.out.print("Enter your choise: ");
        do {
            choise = sc.nextInt();
            sc.nextLine();
            if(choise < 0 || choise > 3){
                System.out.print("Please enter your choise again: ");
            }
        }while(choise < 0 || choise > 3);
        
        switch(choise){
            case 1:
                SignUpForAnAccount();
                break;
            case 2:
                LoginToBuyProduct();
                break;
            case 3: 
                ChangeMyPassword();
                break;
            case 0: 
                break;
        }
    }

    private static void SignUpForAnAccount(){
        listAcc = fileController.ReadAccountFromFile(ACC_FILE_NAME);
        Account tmp = new Account();
        tmp.Input();
        listAcc.add(tmp);
        fileController.UpdateAccountFile(listAcc, ACC_FILE_NAME);
        System.out.println("Create a new account successful");
    }
    
    private static String Login(){
        String user;
        boolean check = false;
        do {
            System.out.print("Enter your userName: ");
            user = sc.nextLine();
            System.out.print("Enter your password: ");
            String pass = sc.nextLine();
            if(checkAll.CheckUserNameAccount(user) && checkAll.CheckPasswordAccount(pass)){
                System.out.println("Login successful");
                check = true;
            }else if(!checkAll.CheckUserNameAccount(user) && !checkAll.CheckPasswordAccount(pass)){
                System.out.println("Account is not contain");
            }else if(!checkAll.CheckUserNameAccount(user)){
                System.out.println("User name is not contain");
            }else {
                System.out.println("Password is wrong");
            }
        }while(!check);
        
        return user;
    }
    
    private static void LoginToBuyProduct(){
        String user = Login();
        System.out.println("\nLogin successfull");
        AffterLogin(user);
    }
    
    private static void AffterLogin(String user){
        do {
            System.out.println("1. Show all list product");
            System.out.println("2. By products");
            System.out.println("3. Show my bills");
            System.out.println("4. I'm a VIP customer");
            System.out.println("0. Exit");
            int choise = 0;
            System.out.print("Enter your choise: ");
            do {
                choise = sc.nextInt();
                sc.nextLine();
                if(choise < 0 || choise > 4){
                    System.out.print("Please enter your choise: ");
                }
            }while(choise < 0 || choise > 4);

            switch(choise){
                case 1:
                    ShowAllListProduct();
                    break;
                case 2:
                    BuyProductOnline(user);
                    break;
                case 3:
                    ShowAllBillOfCustomer(user);
                    break;
                case 4:
                    IsViper(user);
                    break;
                case 0:
                    return;
            }
        }while(true);
    }
    
    private static void BuyProductOnline(String user){
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
    
    private static void ShowAllBillOfCustomer(String user){
        listBill = fileController.ReadBillsFromFile(BILL_FILE_NAME);
        boolean check = false;
        for(Bill i : listBill)
            if(i.getUserNameOfCus().compareTo(user) == 0){
                check = true;
                break;
            }
        if(check){
            for(Bill i : listBill){
                if(i.getUserNameOfCus().compareTo(user) == 0)
                    System.out.println(i);
            }
        }else {
            System.out.println("You don't have bill");
        }
    }
    
    private static void ChangeMyPassword(){
        String user = Login();
        listAcc = fileController.ReadAccountFromFile(ACC_FILE_NAME);
        for(Account i : listAcc){
            if(i.getUserName().compareTo(user) == 0){
                System.out.print("Enter your new pass: ");
                pattern = Pattern.compile(regPassword);
                String newPass;
                do {
                    newPass = sc.nextLine();
                    if(!pattern.matcher(newPass).find()){
                        System.out.print("Enter your new password again: ");
                    }else {
                        i.setPassword(newPass);
                        break;
                    }
                }while(true);
                break;
            }
        }
        fileController.UpdateAccountFile(listAcc, ACC_FILE_NAME);
    }
    
    private static void IsViper(String user){
        if(checkAll.CheckViper(user)){
            System.out.println("You was VIPer");
        }else {
            System.out.println("You are not VIPer");
        }
    }
    
    private static void PurchaseOnfflineForm(){
        int choise = 0;

        do {
            TitleThirstOfCustomer();
            System.out.print("Enter your choise: ");
            do {
                choise = sc.nextInt();
                sc.nextLine();
                if(choise < 0 || choise > 5){
                    System.out.print("Enter your choise again: ");
                }
            }while(choise < 0 || choise > 5);
            
            switch(choise){
                case 1:
                    SignUpForAnAccount();
                    break;
                case 2:
                    ShowAllListProduct();
                    break;
                case 3:
                    BuyProductOffline();
                    break;
                case 0:
                    return;
            }
            
        }while(true);
    }
    
    private static void BuyProductOffline(){
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

    //method of store owner
    private static void ShowAllListProduct() {
        listPro = fileController.ReadProductsFromFile(PRODUCT_FILE_NAME);
        for(Product i : listPro){
            System.out.println(i);
        }
    }
    
    private static void UpdateListProduct() {
        System.out.println("---------------------Update products------------------------");
        System.out.println("1. Insert a new product");
        System.out.println("2. Delete a product by id");
        System.out.println("3. Repair a product by id");
        System.out.println("0. Exit");
        System.out.println("------------------------------------------------------------");
        int choise = 0;
        boolean check = true;
        System.out.print("Enter your choise: ");
        do {
            choise = sc.nextInt();
            if(choise < 0 || choise > 3) {
                System.out.print("Enter your choise again: ");
            }
        }while(choise < 0 || choise > 3);
        
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
                        System.out.print("Enter your choise: ");
                        int choise2 = 0;
                        do {
                            choise2 = sc.nextInt();
                            sc.nextLine();
                            if(choise2 < 1 || choise2 > 5) {
                                System.out.print("Enter your choise again: ");
                            }
                        }while(choise2 < 1 || choise2 > 5);
                        
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
    
    private static void ShowAllListBill() {
        listBill = fileController.ReadBillsFromFile(BILL_FILE_NAME);
        for(Bill i : listBill){
            System.out.println(i);        
        }
    }
   
    private static void UpdateListBill() {
        System.out.println("---------------------Update Bills------------------------");
        System.out.println("1. Insert a new bill");
        System.out.println("2. Delete a bill by id");
        System.out.println("3. Repair a bill by id");
        System.out.println("0. Exit");
        System.out.println("------------------------------------------------------------");
        int choise = 0;
        System.out.print("Enter your choise: ");
        do {
            choise = sc.nextInt();
            if(choise < 0 || choise > 3) {
                System.out.print("Enter your choise again: ");
            }
        }while(choise < 0 || choise > 3);
        
        switch(choise){
            case 1:
                listBill = fileController.ReadBillsFromFile(BILL_FILE_NAME);
                Bill bill = new Bill();
                bill.Input();
                listBill.add(bill);
                fileController.UpdateBillFile(listBill, BILL_FILE_NAME);
                break;
            case 2:
                int id = 0;
                boolean check = true;
                System.out.print("Enter billId to delete: ");
                do {
                    id = sc.nextInt();
                    if(checkAll.CheckIdBill(id)){
                        check = false;
                    }else {
                        check = true;
                        System.out.print("Enter billId again: ");
                    }
                }while(check);
                listBill = fileController.ReadBillsFromFile(BILL_FILE_NAME);
                for(Bill i : listBill){
                    if(id == i.getBillId()){
                        listBill.remove(i);
                        break;
                    }
                }
                fileController.UpdateBillFile(listBill, BILL_FILE_NAME);
                break;
            case 3:
                id = 0;
                check = true;
                System.out.print("Enter billId to repair: ");
                do {
                    id = sc.nextInt();
                    if(checkAll.CheckIdBill(id)){
                        check = false;
                    }else {
                        check = true;
                        System.out.print("Enter billId again: ");
                    }
                }while(check);
                listBill = fileController.ReadBillsFromFile(BILL_FILE_NAME);
                for(Bill i : listBill){
                    if(id == i.getBillId()){
                        System.out.println("-------------------------------------------------");
                        System.out.println("1. Repair id");
                        System.out.println("2. Repair dateOfPurchase");
                        System.out.println("3. Repair list product");
                        System.out.println("-------------------------------------------------");
                        System.out.print("Enter your choise: ");
                        int choise2 = 0;
                        do {
                            choise2 = sc.nextInt();
                            sc.nextLine();
                            if(choise2 < 1 || choise2 > 3) {
                                System.out.print("Enter your choise again: ");
                            }
                        }while(choise2 < 1 || choise2 > 3);
                        
                        switch(choise2){
                            case 1:
                                boolean check2 = true;
                                int id2 = 0;
                                System.out.print("Enter id: ");
                                do {
                                    id2 = sc.nextInt();
                                    sc.nextLine();
                                    if(checkAll.CheckIdProduct(id2)){
                                        check2 = true;
                                        System.out.print("Enter id again: ");
                                    }else {
                                        check2 = false;
                                    }
                                }while(check2);
                                i.setBillId(id2);
                                break;
                            case 2:
                                   i.setDateOfPurchase(sc.nextLine());
                                break;
                            case 3:
                                List<Product> listProduct = i.getProductBought();
                                System.out.print("Enter id of product to repair: ");
                                boolean checkIdOfListPro = true;
                                do {
                                    id = sc.nextInt();
                                    checkIdOfListPro = checkAll.CheckIdCustomerFromBill(id, i);
                                    if(checkIdOfListPro){
                                        checkIdOfListPro = false;
                                    }else {
                                        System.out.print("Enter id of product again to repair: ");
                                        checkIdOfListPro = true;
                                    }
                                }while(checkIdOfListPro);
                                for(Product j : listProduct){
                                    if(id == j.getProductId()){
                                        System.out.println("-------------------------------------------------");
                                        System.out.println("1. Repair name");
                                        System.out.println("2. Repair quantily");
                                        System.out.println("3. Repair price");
                                        System.out.println("4. Repair type");
                                        System.out.println("-------------------------------------------------");
                                        System.out.print("Enter your choise: ");
                                        int choise3 = 0;
                                        do {
                                            choise3 = sc.nextInt();
                                            sc.nextLine();
                                            if(choise3 < 1 || choise3 > 4) {
                                                System.out.print("Enter your choise again: ");
                                            }
                                        }while(choise3 < 1 || choise3 > 4);

                                        switch(choise3){
                                            case 1:
                                                System.out.print("Enter name of product to repair: ");
                                                j.setProductName(sc.nextLine());
                                                break;
                                            case 2:
                                                System.out.print("Enter quantily of product to repair: ");
                                                j.setQuantily(sc.nextInt());
                                                break;
                                            case 3: 
                                                System.out.print("Enter price of product to repair: ");
                                                j.setPrice(sc.nextDouble());
                                                break;
                                            case 4: 
                                                String[] spec = {"Drink", "Cake", "FastFood", "Rice"};

                                                System.out.println("----------------Type---------------");
                                                System.out.println("0. Drink");
                                                System.out.println("1. Cake");
                                                System.out.println("2. FastFood");
                                                System.out.println("3. Rice");
                                                System.out.println("-----------------------------------");
                                                System.out.print("Enter productType: ");
                                                int choise4 = 0;
                                                do {
                                                    choise4 = sc.nextInt();
                                                    if(choise4 < 0 || choise4 > 3){
                                                        System.out.print("Enter productType again: ");
                                                    }
                                                }while(choise4 < 0 || choise4 > 3);
                                                j.setProductType(spec[choise4]);
                                                break;
                                            }
                                        break;
                                    }
                                }
                                break;
                            }
                        break;
                    }
                }
                fileController.UpdateBillFile(listBill, BILL_FILE_NAME);
                break;
            case 0:
                return;
        }
    }

    private static void ShowAllListCustomer() {
        listCus = fileController.ReadCustomersFromFile(CUSTOMER_FILE_NAME);
        for(Customer i : listCus){
            System.out.println(i);
        }
    }

    private static void ShowAllListVIPCustomer() {
        listCus = fileController.ReadCustomersFromFile(CUSTOMER_FILE_NAME);
        listBill = fileController.ReadBillsFromFile(BILL_FILE_NAME);
        boolean check = false;
        for(Customer i : listCus){
            String userName = i.getUserName();//UserName in cus
            if(checkAll.CheckUserNameAccount(userName) && checkAll.CheckUserNameFromBill(userName)){
                double sum = 0;
                int countOfBill = 0;
                for(Bill j : listBill){
                    if(j.getUserNameOfCus().compareTo(userName) == 0){
                        sum += j.getSumPrice();
                        countOfBill++;
                    }
                }
                if(sum >= 1000000 || countOfBill >= 3){
                    System.out.println(i);
                    check = true;
                }
            }
        }
        if(!check){
            System.out.println("Không có khách vip");
        }
    }

    private static void UpdateListCustomer() {
        System.out.println("--------------------Update list customer----------------------");
        System.out.println("1. Insert a new customer");
        System.out.println("2. Delete a customer by id");
        System.out.println("3. Repair a customer by id");
        System.out.println("0. Exit");
        System.out.println("--------------------------------------------------------------");
        int choise = 0;
        
        System.out.print("Enter your choise: ");
        do {
            choise = sc.nextInt();
            sc.nextLine();
            if(choise < 0 || choise > 3){
                System.out.print("Enter your choise again: ");
            }
        }while(choise < 0 || choise > 3);
        
        int id;
        boolean check = true;
        switch(choise){
            case 1:
                listCus = fileController.ReadCustomersFromFile(CUSTOMER_FILE_NAME);
                Customer cus = new Customer();
                cus.Input();
                listCus.add(cus);
                System.out.println("Insert successful");
                fileController.UpdateCustomerFile(listCus, CUSTOMER_FILE_NAME);
                break;
            case 2:
                listCus = fileController.ReadCustomersFromFile(CUSTOMER_FILE_NAME);

                System.out.print("Enter id of customer to delete: ");
                do {
                    id = sc.nextInt();
                    sc.nextLine();
                    check = checkAll.CheckIdCustomer(id);
                    if(!check){
                        System.out.print("This id not contain\nPlease enter id again: ");
                    }
                }while(!check);
                for(Customer i : listCus){
                    if(i.getCustomerId() == id){
                        listCus.remove(i);
                        break;
                    }
                }
                fileController.UpdateCustomerFile(listCus, CUSTOMER_FILE_NAME);
                System.out.println("Delete successful");
                break;
            case 3:
                listCus = fileController.ReadCustomersFromFile(CUSTOMER_FILE_NAME);
                check = true;
                System.out.print("Enter id of customer to repair: ");
                do {
                    id = sc.nextInt();
                    sc.nextLine();
                    check = checkAll.CheckIdCustomer(id);
                    if(!check){
                        System.out.print("This id not contain\nPlease enter id again: ");
                    }
                }while(!check);
                
                System.out.println("----------------Repair a customer-----------------");
                System.out.println("1. Repair id");
                System.out.println("2. Repair name");
                System.out.println("3. Repair age");
                System.out.println("4. Repair phone number");
                System.out.println("5. Repair address");
                System.out.println("6. Repair gender");
                System.out.println("7. Repair user name");
                System.out.println("0. Exit");
                System.out.println("---------------------------------------------------");
                
                System.out.print("\nEnter your choise: ");
                do {
                    choise = sc.nextInt();
                    sc.nextLine();
                    if(choise < 0 || choise > 7){
                        System.out.print("Enter your choise again: ");
                    }
                }while(choise < 0 || choise > 7);
                
                for(Customer i : listCus){
                    if(i.getCustomerId() == id){
                        switch(choise){
                            case 1:
                                System.out.print("Enter a new id: ");
                                    do {
                                        id = sc.nextInt();
                                        sc.nextLine();
                                        check = checkAll.CheckIdCustomer(id);
                                        if(check){
                                            System.out.print("This id is contain\nPlease enter id again: ");
                                        }
                                    }while(check);

                                    i.setCustomerId(id);
                                break;
                            case 2:
                                System.out.print("Enter a new name: ");
                                i.setCustomerName(sc.nextLine());
                                break;
                            case 3:
                                System.out.print("Enter a new age: ");
                                i.setAge(sc.nextInt());
                                sc.nextLine();
                                break;
                            case 4:
                                System.out.print("Enter a new phone number: ");
                                i.setCustomerPhoneNumber(sc.nextLine());
                                break;
                            case 5:
                                System.out.print("Enter a new address: ");
                                i.setCustomerAddress(sc.nextLine());
                                break;
                            case 6:
                                System.out.print("Enter a new gender: ");
                                i.setGender(sc.nextLine());
                                break;
                            case 7: 
                                System.out.print("Enter a new user name: ");
                                i.setUserName(sc.nextLine());
                            case 0:
                                break;
                        }
                        break;
                    }
                }
                
                fileController.UpdateCustomerFile(listCus, CUSTOMER_FILE_NAME);
                System.out.println("Repair successful");
                break;
            case 0:
                break;
        }
    }

    private static void ShowAllListAccount() {
        listAcc = fileController.ReadAccountFromFile(ACC_FILE_NAME);
        for(Account i : listAcc){
            System.out.println(i);
        }
    }

    private static void UpdateListAccount() {
        System.out.println("--------------------Update list Account----------------------");
        System.out.println("1. Insert a new account");
        System.out.println("2. Delete a account by id");
        System.out.println("3. Repair a account by id");
        System.out.println("0. Exit");
        System.out.println("--------------------------------------------------------------");
        int choise = 0;
        
        System.out.print("Enter your choise: ");
        do {
            choise = sc.nextInt();
            sc.nextLine();
            if(choise < 0 || choise > 3){
                System.out.print("Enter your choise again: ");
            }
        }while(choise < 0 || choise > 3);
        
        int id;
        boolean check = true;
        switch(choise){
            case 1:
                listAcc = fileController.ReadAccountFromFile(ACC_FILE_NAME);
                Account acc = new Account();
                acc.Input();
                listAcc.add(acc);
                System.out.println("Insert successful");
                fileController.UpdateAccountFile(listAcc, ACC_FILE_NAME);
                break;
            case 2:
                listAcc = fileController.ReadAccountFromFile(ACC_FILE_NAME);

                System.out.print("Enter id of account to delete: ");
                do {
                    id = sc.nextInt();
                    sc.nextLine();
                    check = checkAll.CheckIdAccount(id);
                    if(!check){
                        System.out.print("This id not contain\nPlease enter id again: ");
                    }
                }while(!check);
                for(Account i : listAcc){
                    if(i.getId() == id){
                        listAcc.remove(i);
                        break;
                    }
                }
                fileController.UpdateAccountFile(listAcc, ACC_FILE_NAME);
                System.out.println("Delete successful");
                break;
            case 3:
                listAcc = fileController.ReadAccountFromFile(ACC_FILE_NAME);
                check = true;
                System.out.print("Enter id of account to repair: ");
                do {
                    id = sc.nextInt();
                    sc.nextLine();
                    check = checkAll.CheckIdAccount(id);
                    if(!check){
                        System.out.print("This id not contain\nPlease enter id again: ");
                    }
                }while(!check);
                
                System.out.println("----------------Repair a customer-----------------");
                System.out.println("1. Repair id");
                System.out.println("2. Repair full name");
                System.out.println("3. Repair userName");
                System.out.println("4. Repair password");
                System.out.println("5. Repair phone number");
                System.out.println("6. Repair email");
                System.out.println("0. Exit");
                System.out.println("---------------------------------------------------");
                
                System.out.print("\nEnter your choise: ");
                do {
                    choise = sc.nextInt();
                    sc.nextLine();
                    if(choise < 0 || choise > 6){
                        System.out.print("Enter your choise again: ");
                    }
                }while(choise < 0 || choise > 6);
                
                for(Account i : listAcc){
                    if(i.getId() == id){
                        switch(choise){
                            case 1:
                                System.out.print("Enter a new id: ");
                                    do {
                                        id = sc.nextInt();
                                        sc.nextLine();
                                        check = checkAll.CheckIdAccount(id);
                                        if(check){
                                            System.out.print("This id is contain\nPlease enter id again: ");
                                        }
                                    }while(check);

                                    i.setId(id);
                                break;
                            case 2:
                                System.out.print("Enter a new full name: ");
                                i.setFullName(sc.nextLine());
                                break;
                            case 3:
                                boolean check2 = true;
                                System.out.print("Enter a new userName: ");
                                pattern = Pattern.compile(regUserName);
                                String tmp;
                                do {
                                    tmp = sc.nextLine();
                                    check = checkAll.CheckUserNameAccount(tmp);
                                    check2 = pattern.matcher(tmp).find();
                                    if(check){
                                        System.out.print("UserName is contain!\nPlease enter a new userName: ");
                                    }else if(!check2){
                                        System.out.print("Please enter userName again: ");
                                    }
                                }while(check == true || check2 == false);

                                i.setUserName(tmp);
                                break;
                            case 4:
                                pattern = Pattern.compile(regPassword);
                                System.out.print("Enter a new password: ");
                                do {
                                    tmp = sc.nextLine();
                                    check = pattern.matcher(tmp).find();
                                    if(!check){
                                        System.out.print("Enter a new password again: ");
                                    }
                                }while(!check);
                                i.setPassword(tmp);
                                break;
                            case 5:
                                pattern = Pattern.compile(regPhone);
                                System.out.print("Enter a new phone number: ");
                                do {
                                    tmp = sc.nextLine();
                                    check = pattern.matcher(tmp).find();
                                    if(!check){
                                        System.out.print("Enter a new phone number again: ");
                                    }
                                }while(!check);
                                
                                i.setPhoneNumber(tmp);
                                break;
                            case 6:
                                pattern = Pattern.compile(regEmail);
                                System.out.print("Enter a new email: ");
                                do {
                                    tmp = sc.nextLine();
                                    check = pattern.matcher(tmp).find();
                                    if(!check){
                                        System.out.print("Enter a new email again: ");
                                    }
                                }while(!check);

                                i.setEmail(tmp);
                                break;
                            case 0:
                                break;
                        }
                        break;
                    }
                }
                fileController.UpdateAccountFile(listAcc, ACC_FILE_NAME);
                System.out.println("Repair successful");
                break;
            case 0:
                break;
        }
    }

    private static void SortListProduct() {
        System.out.println("------------------Sort list product-------------------");
        System.out.println("1. Sort by id");
        System.out.println("2. Sort by name");
        System.out.println("3. Sort by quantily");
        System.out.println("4. Sort by price");
        System.out.println("5. Sort by type");
        System.out.println("0. Exit");
        System.out.println("------------------------------------------------------");
                
        int choise = 0;
        System.out.print("Enter your choise: ");
        do {
            choise = sc.nextInt();
            if(choise < 0 || choise > 5){
                System.out.print("Enter your choise again: ");
            }
        }while(choise < 0 || choise > 5);
        
        listPro = fileController.ReadProductsFromFile(PRODUCT_FILE_NAME);
        int n = listPro.size();
        switch(choise){
            case 1:
                for(int i = 0; i < n - 1; i++){
                    for(int j = n - 1; j > i; j--){
                        if(listPro.get(j - 1).getProductId() > listPro.get(j).getProductId()){
                            Product tmp = listPro.get(j - 1);
                            listPro.set(j - 1, listPro.get(j));
                            listPro.set(j, tmp);
                        }
                    }
                }
                System.out.println("Sort by id successful");
                break;
            case 2:
                for(int i = 0; i < n - 1; i++){
                    for(int j = n - 1; j > i; j--){
                        if(listPro.get(j - 1).getProductName().compareTo(listPro.get(j).getProductName()) > 0){
                            Product tmp = listPro.get(j - 1);
                            listPro.set(j - 1, listPro.get(j));
                            listPro.set(j, tmp);
                        }
                    }
                }
                System.out.println("Sort by name successful");
                break;
            case 3:
                for(int i = 0; i < n - 1; i++){
                    for(int j = n - 1; j > i; j--){
                        if(listPro.get(j - 1).getQuantily() > listPro.get(j).getQuantily()){
                            Product tmp = listPro.get(j - 1);
                            listPro.set(j - 1, listPro.get(j));
                            listPro.set(j, tmp);
                        }
                    }
                }
                System.out.println("Sort by quantily successful");
                break;
            case 4:
                for(int i = 0; i < n - 1; i++){
                    for(int j = n - 1; j > i; j--){
                        if(listPro.get(j - 1).getPrice() > listPro.get(j).getPrice()){
                            Product tmp = listPro.get(j - 1);
                            listPro.set(j - 1, listPro.get(j));
                            listPro.set(j, tmp);
                        }
                    }
                }
                System.out.println("Sort by price successful");
                break;
            case 5: 
                for(int i = 0; i < n - 1; i++){
                    for(int j = n - 1; j > i; j--){
                        if(listPro.get(j - 1).getProductType().compareTo(listPro.get(j).getProductType()) > 0){
                            Product tmp = listPro.get(j - 1);
                            listPro.set(j - 1, listPro.get(j));
                            listPro.set(j, tmp);
                        }
                    }
                }
                System.out.println("Sort by type successful");
                break;
            case 0:
                break;
        }
        fileController.UpdateProductFile(listPro, PRODUCT_FILE_NAME);
    }

    private static void SortListBill() {
        System.out.println("------------------Sort list bill-------------------");
        System.out.println("1. Sort by id");
        System.out.println("2. Sort by date of purchse");
        System.out.println("3. Sort by userName of customer");
        System.out.println("0. Exit");
        System.out.println("------------------------------------------------------");
                
        int choise = 0;
        System.out.print("Enter your choise: ");
        do {
            choise = sc.nextInt();
            if(choise < 0 || choise > 3){
                System.out.print("Enter your choise again: ");
            }
        }while(choise < 0 || choise > 3);
        
        listBill = fileController.ReadBillsFromFile(BILL_FILE_NAME);
        int n = listBill.size();
        switch(choise){
            case 1:
                for(int i = 0; i < n - 1; i++){
                    for(int j = n - 1; j > i; j--){
                        if(listBill.get(j - 1).getBillId() > listBill.get(j).getBillId()){
                            Bill tmp = listBill.get(j - 1);
                            listBill.set(j - 1, listBill.get(j));
                            listBill.set(j, tmp);
                        }
                    }
                }
                System.out.println("Sort by id successful");
                break;
            case 2:
                for(int i = 0; i < n - 1; i++){
                    for(int j = n - 1; j > i; j--){
                        if(listBill.get(j - 1).getDateOfPurchase().compareTo(listBill.get(j).getDateOfPurchase()) > 0){
                            Bill tmp = listBill.get(j - 1);
                            listBill.set(j - 1, listBill.get(j));
                            listBill.set(j, tmp);
                        }
                    }
                }
                System.out.println("Sort by date of purchse successful");
                break;
            case 3:
                for(int i = 0; i < n - 1; i++){
                    for(int j = n - 1; j > i; j--){
                        if(listBill.get(j - 1).getUserNameOfCus().compareTo(listBill.get(j).getUserNameOfCus()) > 0){
                            Bill tmp = listBill.get(j - 1);
                            listBill.set(j - 1, listBill.get(j));
                            listBill.set(j, tmp);
                        }
                    }
                }
                System.out.println("Sort by userName of customer successful");
                break;
            case 0:
                break;
        }
        fileController.UpdateBillFile(listBill, BILL_FILE_NAME);
    }

    private static void SortListCustomer() {
        System.out.println("------------------Sort list customer-------------------");
        System.out.println("1. Sort by id");
        System.out.println("2. Sort by name");
        System.out.println("3. Sort by age");
        System.out.println("4. Sort by address");
        System.out.println("5. Sort by gender");
        System.out.println("6. Sort by userName");
        System.out.println("0. Exit");
        System.out.println("------------------------------------------------------");
                
        int choise = 0;
        System.out.print("Enter your choise: ");
        do {
            choise = sc.nextInt();
            if(choise < 0 || choise > 6){
                System.out.print("Enter your choise again: ");
            }
        }while(choise < 0 || choise > 6);
        
        listCus = fileController.ReadCustomersFromFile(CUSTOMER_FILE_NAME);
        int n = listCus.size();
        switch(choise){
            case 1:
                for(int i = 0; i < n - 1; i++){
                    for(int j = n - 1; j > i; j--){
                        if(listCus.get(j - 1).getCustomerId() > listCus.get(j).getCustomerId()){
                            Customer tmp = listCus.get(j - 1);
                            listCus.set(j - 1, listCus.get(j));
                            listCus.set(j, tmp);
                        }
                    }
                }
                System.out.println("Sort by id successful");
                break;
            case 2:
                for(int i = 0; i < n - 1; i++){
                    for(int j = n - 1; j > i; j--){
                        if(listCus.get(j - 1).getCustomerName().compareTo(listCus.get(j).getCustomerName()) > 0){
                            Customer tmp = listCus.get(j - 1);
                            listCus.set(j - 1, listCus.get(j));
                            listCus.set(j, tmp);
                        }
                    }
                }
                System.out.println("Sort by name successful");
                break;
            case 3:
                for(int i = 0; i < n - 1; i++){
                    for(int j = n - 1; j > i; j--){
                        if(listCus.get(j - 1).getAge() > listCus.get(j).getAge()){
                            Customer tmp = listCus.get(j - 1);
                            listCus.set(j - 1, listCus.get(j));
                            listCus.set(j, tmp);
                        }
                    }
                }
                System.out.println("Sort by age successful");
                break;
            case 4:
                for(int i = 0; i < n - 1; i++){
                    for(int j = n - 1; j > i; j--){
                        if(listCus.get(j - 1).getCustomerAddress().compareTo(listCus.get(j).getCustomerAddress()) > 0){
                            Customer tmp = listCus.get(j - 1);
                            listCus.set(j - 1, listCus.get(j));
                            listCus.set(j, tmp);
                        }
                    }
                }
                System.out.println("Sort by address successful");
                break;
            case 5: 
                for(int i = 0; i < n - 1; i++){
                    for(int j = n - 1; j > i; j--){
                        if(listCus.get(j - 1).getGender().compareTo(listCus.get(j).getGender()) > 0){
                            Customer tmp = listCus.get(j - 1);
                            listCus.set(j - 1, listCus.get(j));
                            listCus.set(j, tmp);
                        }
                    }
                }
                System.out.println("Sort by gender successful");
                break;
            case 6: 
                for(int i = 0; i < n - 1; i++){
                    for(int j = n - 1; j > i; j--){
                        if(listCus.get(j - 1).getUserName().compareTo(listCus.get(j).getUserName()) > 0){
                            Customer tmp = listCus.get(j - 1);
                            listCus.set(j - 1, listCus.get(j));
                            listCus.set(j, tmp);
                        }
                    }
                }
                System.out.println("Sort by userName successful");
                break;
            case 0:
                break;
        }
        fileController.UpdateCustomerFile(listCus, CUSTOMER_FILE_NAME);
    }

    private static void SortListAccount() {
        /*    private int id;
            private String fullName;
            private String userName;
            private String password;
            private String phoneNumber;
            private String email;
            private String creatAt;*/
        System.out.println("------------------Sort list account-------------------");
        System.out.println("1. Sort by id");
        System.out.println("2. Sort by name");
        System.out.println("3. Sort by userName");
        System.out.println("4. Sort by email");
        System.out.println("5. Sort by createAt");
        System.out.println("0. Exit");
        System.out.println("------------------------------------------------------");
                
        int choise = 0;
        System.out.print("Enter your choise: ");
        do {
            choise = sc.nextInt();
            if(choise < 0 || choise > 5){
                System.out.print("Enter your choise again: ");
            }
        }while(choise < 0 || choise > 5);
        
        listAcc = fileController.ReadAccountFromFile(ACC_FILE_NAME);
        int n = listAcc.size();
        switch(choise){
            case 1:
                for(int i = 0; i < n - 1; i++){
                    for(int j = n - 1; j > i; j--){
                        if(listAcc.get(j - 1).getId() > listAcc.get(j).getId()){
                            Account tmp = listAcc.get(j - 1);
                            listAcc.set(j - 1, listAcc.get(j));
                            listAcc.set(j, tmp);
                        }
                    }
                }
                System.out.println("Sort by id successful");
                break;
            case 2:
                for(int i = 0; i < n - 1; i++){
                    for(int j = n - 1; j > i; j--){
                        if(listAcc.get(j - 1).getFullName().compareTo(listAcc.get(j).getFullName()) > 0){
                            Account tmp = listAcc.get(j - 1);
                            listAcc.set(j - 1, listAcc.get(j));
                            listAcc.set(j, tmp);
                        }
                    }
                }
                System.out.println("Sort by name successful");
                break;
            case 3:
                for(int i = 0; i < n - 1; i++){
                    for(int j = n - 1; j > i; j--){
                        if(listAcc.get(j - 1).getUserName().compareTo(listAcc.get(j).getUserName()) > 0){
                            Account tmp = listAcc.get(j - 1);
                            listAcc.set(j - 1, listAcc.get(j));
                            listAcc.set(j, tmp);
                        }
                    }
                }
                System.out.println("Sort by userName successful");
                break;
            case 4:
                for(int i = 0; i < n - 1; i++){
                    for(int j = n - 1; j > i; j--){
                        if(listAcc.get(j - 1).getEmail().compareTo(listAcc.get(j).getEmail()) > 0){
                            Account tmp = listAcc.get(j - 1);
                            listAcc.set(j - 1, listAcc.get(j));
                            listAcc.set(j, tmp);
                        }
                    }
                }
                System.out.println("Sort by email successful");
                break;
            case 5: 
                for(int i = 0; i < n - 1; i++){
                    for(int j = n - 1; j > i; j--){
                        if(listAcc.get(j - 1).getCreatAt().compareTo(listAcc.get(j).getCreatAt()) > 0){
                            Account tmp = listAcc.get(j - 1);
                            listAcc.set(j - 1, listAcc.get(j));
                            listAcc.set(j, tmp);
                        }
                    }
                }
                System.out.println("Sort by gender successful");
                break;
            case 0:
                break;
        }
        fileController.UpdateAccountFile(listAcc, ACC_FILE_NAME);
    }

    private static void SearchAndShowInfoProduct() {
        listPro = fileController.ReadProductsFromFile(PRODUCT_FILE_NAME);
        boolean check = false;
        int choise = 0;
        String name;
        
        System.out.println("---------------------Search and show info product----------");
        System.out.println("1. Search by id");
        System.out.println("2. Search by name");
        System.out.println("3. Search by type");
        System.out.println("0. Exit");
        System.out.println("------------------------------------------------------------");
        
        System.out.print("Enter your choise: ");
        do {
            choise = sc.nextInt();
            sc.nextLine();
            if(choise < 0 || choise > 3){
                System.out.print("Enter your choise again: ");
            }
        }while(choise < 0 || choise > 3);
        
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

    private static void SearchAndShowInfoBill() {
        listBill = fileController.ReadBillsFromFile(BILL_FILE_NAME);
        boolean check = false;
        int choise = 0;
        String name;
        
        System.out.println("---------------------Search and show info bill----------");
        System.out.println("1. Search by id");
        System.out.println("2. Search by date");
        System.out.println("3. Search by user name of customer");
        System.out.println("0. Exit");
        System.out.println("------------------------------------------------------------");
        
        System.out.print("Enter your choise: ");
        do {
            choise = sc.nextInt();
            sc.nextLine();
            if(choise < 0 || choise > 3){
                System.out.print("Enter your choise again: ");
            }
        }while(choise < 0 || choise > 3);
        
        switch(choise){
            case 1:
                int id;
                System.out.print("Enter id to search: ");
                id = sc.nextInt();
                for(Bill i : listBill){
                    if(i.getBillId() == id){
                        check = true;
                        System.out.println(i);
                        break;
                    }
                }
                if(check == false){
                    System.out.println("\nThis bill not contain in shop");
                }
                break;
            case 2:
                check = false;
                System.out.print("Enter date to search: ");
                name = sc.nextLine();
                for(Bill i : listBill){
                    if(i.getDateOfPurchase().compareTo(name) == 0){
                        check = true;
                        System.out.println(i);
                    }
                }
                if(check == false){
                    System.out.println("\nThis bill not contain in shop");
                }
                break;
            case 3:
                check = false;
                System.out.print("Enter userName of product to search: ");
                name = sc.nextLine();
                for(Bill i : listBill){
                    if(i.getUserNameOfCus().compareTo(name) == 0){
                        check = true;
                        System.out.println("\n" + i);
                    }
                }
                if(check == false){
                    System.out.println("\nThis bill not contain in shop");
                }
                break;
            case 0: 
                break;
        }
    }

    private static void SearchAndShowInfoCustomer() {
        listCus = fileController.ReadCustomersFromFile(CUSTOMER_FILE_NAME);
        boolean check = false;
        int choise = 0;
        int tmp;
        String name;
        
        System.out.println("---------------------Search and show info customer----------");
        System.out.println("1. Search by id");
        System.out.println("2. Search by name");
        System.out.println("3. Search by age");
        System.out.println("4. Search by phone number");
        System.out.println("5. Search by address");
        System.out.println("6. Search by gender");
        System.out.println("7. Search by user name of customer");
        System.out.println("0. Exit");
        System.out.println("------------------------------------------------------------");
        
        System.out.print("Enter your choise: ");
        do {
            choise = sc.nextInt();
            sc.nextLine();
            if(choise < 0 || choise > 7){
                System.out.print("Enter your choise again: ");
            }
        }while(choise < 0 || choise > 7);
        
        switch(choise){
            case 1:
                int id;
                System.out.print("Enter id to search: ");
                id = sc.nextInt();
                for(Customer i : listCus){
                    if(i.getCustomerId() == id){
                        check = true;
                        System.out.println(i);
                        break;
                    }
                }
                if(check == false){
                    System.out.println("\nThis customer not contain in shop");
                }
                break;
            case 2:
                check = false;
                System.out.print("Enter name to search: ");
                name = sc.nextLine();
                for(Customer i : listCus){
                    if(i.getCustomerName().compareTo(name) == 0){
                        check = true;
                        System.out.println(i);
                    }
                }
                if(check == false){
                    System.out.println("\nThis customer not contain in shop");
                }
                break;
            case 3:
                check = false;
                System.out.print("Enter userName of product to search: ");
                tmp = sc.nextInt();
                sc.nextLine();
                for(Customer i : listCus){
                    if(i.getAge() == tmp){
                        check = true;
                        System.out.println(i);
                    }
                }
                if(check == false){
                    System.out.println("\nThis customer not contain in shop");
                }
                break;
            case 4:
                check = false;
                System.out.print("Enter phone number to search: ");
                name = sc.nextLine();
                for(Customer i : listCus){
                    if(i.getCustomerPhoneNumber().compareTo(name) == 0){
                        check = true;
                        System.out.println(i);
                    }
                }
                if(check == false){
                    System.out.println("\nThis customer not contain in shop");
                }
                break;
            case 5:
                check = false;
                System.out.print("Enter address to search: ");
                name = sc.nextLine();
                for(Customer i : listCus){
                    if(i.getCustomerAddress().compareTo(name) == 0){
                        check = true;
                        System.out.println(i);
                    }
                }
                if(check == false){
                    System.out.println("\nThis customer not contain in shop");
                }
                break;
            case 6:
                check = false;
                System.out.print("Enter gender to search: ");
                name = sc.nextLine();
                for(Customer i : listCus){
                    if(i.getGender().compareTo(name) == 0){
                        check = true;
                        System.out.println(i);
                    }
                }
                if(check == false){
                    System.out.println("\nThis customer not contain in shop");
                }
                break;
            case 7:
                check = false;
                System.out.print("Enter userName to search: ");
                name = sc.nextLine();
                for(Customer i : listCus){
                    if(i.getUserName().compareTo(name) == 0){
                        check = true;
                        System.out.println(i);
                    }
                }
                if(check == false){
                    System.out.println("\nThis customer not contain in shop");
                }
                break;
            case 0: 
                break;
        }
    }

    private static void SearchAndShowInfoAccount() {
        listAcc = fileController.ReadAccountFromFile(ACC_FILE_NAME);
        boolean check = false;
        int choise = 0;
        String name;
        
        System.out.println("---------------------Search and show info account----------");
        System.out.println("1. Search by id");
        System.out.println("2. Search by name");
        System.out.println("3. Search by userName");
        System.out.println("4. Search by phone number");
        System.out.println("5. Search by email");
        System.out.println("6. Search by createAt");
        System.out.println("0. Exit");
        System.out.println("------------------------------------------------------------");
        
        System.out.print("Enter your choise: ");
        do {
            choise = sc.nextInt();
            sc.nextLine();
            if(choise < 0 || choise > 6){
                System.out.print("Enter your choise again: ");
            }
        }while(choise < 0 || choise > 6);
        
        switch(choise){
            case 1:
                int id;
                System.out.print("Enter id to search: ");
                id = sc.nextInt();
                for(Account i : listAcc){
                    if(i.getId() == id){
                        check = true;
                        System.out.println(i);
                        break;
                    }
                }
                if(check == false){
                    System.out.println("\nThis account not contain in shop");
                }
                break;
            case 2:
                check = false;
                System.out.print("Enter name to search: ");
                name = sc.nextLine();
                for(Account i : listAcc){
                    if(i.getFullName().compareTo(name) == 0){
                        check = true;
                        System.out.println(i);
                    }
                }
                if(check == false){
                    System.out.println("\nThis customer not contain in shop");
                }
                break;
            case 3:
                check = false;
                System.out.print("Enter userName to search: ");
                name = sc.nextLine();
                for(Account i : listAcc){
                    if(i.getUserName().compareTo(name) == 0){
                        check = true;
                        System.out.println(i);
                        break;
                    }
                }
                if(check == false){
                    System.out.println("\nThis account not contain in shop");
                }
                break;
            case 4:
                check = false;
                System.out.print("Enter phone number to search: ");
                name = sc.nextLine();
                for(Account i : listAcc){
                    if(i.getPhoneNumber().compareTo(name) == 0){
                        check = true;
                        System.out.println(i);
                    }
                }
                if(check == false){
                    System.out.println("\nThis account not contain in shop");
                }
                break;
            case 5:
                check = false;
                System.out.print("Enter email to search: ");
                name = sc.nextLine();
                for(Account i : listAcc){
                    if(i.getEmail().compareTo(name) == 0){
                        check = true;
                        System.out.println(i);
                    }
                }
                if(check == false){
                    System.out.println("\nThis account not contain in shop");
                }
                break;
            case 6:
                check = false;
                System.out.print("Enter gender to search: ");
                name = sc.nextLine();
                for(Account i : listAcc){
                    if(i.getCreatAt().compareTo(name) == 0){
                        check = true;
                        System.out.println(i);
                    }
                }
                if(check == false){
                    System.out.println("\nThis account not contain in shop");
                }
                break;
            case 0: 
                break;
        }
    }

    private static void ShowInfoMyStore() {
        fileController.OpenFileToRead(STORE_FILE_NAME);
        System.out.println("----------------Info of shop----------------");
        System.out.println("Id           : " + fileController.getScanner().nextLine());
        System.out.println("Name         : " + fileController.getScanner().nextLine());
        System.out.println("Phone number : " + fileController.getScanner().nextLine());
        System.out.println("Address      : " + fileController.getScanner().nextLine());
        String tmp = fileController.getScanner().nextLine();
        tmp = fileController.getScanner().nextLine();
        tmp = fileController.getScanner().nextLine();
        tmp = fileController.getScanner().nextLine();
        System.out.println("Total revenue: " + fileController.getScanner().nextLine());
    }
}
