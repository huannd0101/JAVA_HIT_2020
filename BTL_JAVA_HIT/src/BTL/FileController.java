package BTL;

import java.io.*;
import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileController {
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private PrintWriter printWriter;
    private Scanner scanner;
    
    public Scanner getScanner(){
        return this.scanner;
    }
    
    public void OpenFileToWrite(String fileName){
        try {
            fileWriter = new FileWriter(fileName, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void CloseFileAfterWrite(String fileName){
        try {
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void OpenFileToRead(String fileName){
        try {
            scanner = new Scanner(Paths.get(fileName));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void CloseFileAfterRead(String fileName){
        scanner.close();
    }
    
    //Account
    public void WriteAccountToFile(String fileName, Account acc){
        OpenFileToWrite(fileName);
        printWriter.println(
                acc.getId() + "|" + acc.getFullName() + "|" + acc.getUserName() + "|" + 
                acc.getPassword() + "|" + acc.getEmail() + "|" +  acc.getPhoneNumber()+ "|" + 
                acc.getCreatAt()
        );
        CloseFileAfterWrite(fileName);
    }
    
    public Account CreateAccountFromData(String data){
        String[] datas = data.split("\\|");
        Account acc = new Account(Integer.parseInt(datas[0]), datas[1], datas[2], datas[3], datas[4], datas[5], datas[6]);
        return acc;
    }
    
    public List<Account> ReadAccountFromFile(String fileName){
        OpenFileToRead(fileName);
        List<Account> list = new ArrayList<>();
        while(scanner.hasNext()){
            String data = scanner.nextLine();
            Account acc = CreateAccountFromData(data);
            list.add(acc);
        }
        CloseFileAfterRead(fileName);
        return list;
    }
    
    public void UpdateAccountFile(List<Account> list, String fileName){
        File file = new File(fileName);
        if(file.exists()){
            file.delete();
        }
        OpenFileToWrite(fileName);
        for(Account acc : list){
            printWriter.println(
                acc.getId() + "|" + acc.getFullName() + "|" + acc.getUserName() + "|" + 
                acc.getPassword() + "|" + acc.getEmail() + "|" + acc.getPhoneNumber() + "|" + 
                acc.getCreatAt());
        }
        CloseFileAfterWrite(fileName);
    }
    //Product
    
    public void WriteProductToFile(String fileName, Product product){
        OpenFileToWrite(fileName);
        printWriter.println(
                product.getProductId() + "|" + product.getProductName() + "|" + 
                product.getQuantily() + "|" + product.getPrice() + "|" + product.getProductType()
        );
        CloseFileAfterWrite(fileName);
    }
    
    public Product CreateProductFromData(String data){
        String[] arr = data.split("\\|");
        Product product = new Product(
                Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]),
                Double.parseDouble(arr[3]), arr[4]);
        return product;
    }
    
    public List<Product> ReadProductsFromFile(String fileName){
        List<Product> list = new ArrayList<>();
        OpenFileToRead(fileName);
        while(scanner.hasNext()){
            String data = scanner.nextLine();
            Product product = CreateProductFromData(data);
            list.add(product);
        }
        CloseFileAfterRead(fileName);
        return list;
    }
    
    public void UpdateProductFile(List<Product> list, String fileName){
        File file = new File(fileName);
        if(file.exists()){
            file.delete();
        }
        OpenFileToWrite(fileName);
        for(Product product : list){
            printWriter.println(
                    product.getProductId() + "|" + product.getProductName() + "|" + product.getQuantily()
                    + "|" + product.getPrice() + "|" + product.getProductType()
            );
        }
        CloseFileAfterWrite(fileName);
    }
    
    //bill

    public void WriteBillToFile(String fileName, Bill bill){
        OpenFileToWrite(fileName);
        String tmpBill = "";
        tmpBill += bill.getBillId() + "*" + bill.getDateOfPurchase() + "*" + bill.getUserNameOfCus();
        for(Product product : bill.getProductBought()){
            String tmp = product.getProductId() + "|" + product.getProductName() + "|" + 
                product.getQuantily() + "|" + product.getPrice() + "|" + product.getProductType();
            tmpBill += "*" + tmp;
        }
        printWriter.println(tmpBill);
        CloseFileAfterWrite(fileName);
    }
    
    public Bill CreateBillFromData(String data){
        String[] a = data.split("\\*");
        List<Product> list = new ArrayList<>();
        for(int i = 3; i < a.length; i++){
            Product product = CreateProductFromData(a[i]);
            list.add(product);
        }
        Bill bill = new Bill(Integer.parseInt(a[0]), a[1], a[2], list);
        return bill;
    }

    public List<Bill> ReadBillsFromFile(String fileName){
        List<Bill> list = new ArrayList<>();
        OpenFileToRead(fileName);
        while(scanner.hasNext()){
            String data = scanner.nextLine();
            Bill bill = CreateBillFromData(data);
            list.add(bill);
        }
        CloseFileAfterRead(fileName);
        return list;
    }
    
    public void UpdateBillFile(List<Bill> list, String fileName){
        File file = new File(fileName);
        if(file.exists()){
            file.delete();
        }
        OpenFileToWrite(fileName);
        for(Bill bill : list){
            String text = bill.getBillId() + "*" + bill.getDateOfPurchase() + "*" + bill.getUserNameOfCus();
            List<Product> listProduct = bill.getProductBought();
            for(Product i : listProduct){
                text += "*" + i.getProductId() + "|" + i.getProductName() + "|" + i.getQuantily() + 
                "|" + i.getPrice() + "|" + i.getProductType();
            }
            printWriter.println(text);
        }
        CloseFileAfterWrite(fileName);
    }
    
    //customer

    public void WriteCustomerToFile(String fileName, Customer cus){
        OpenFileToWrite(fileName);
        printWriter.println(
                cus.getCustomerId() + "|" + cus.getCustomerName() + "|" + cus.getAge() + "|" + 
                cus.getCustomerPhoneNumber() + "|" + cus.getCustomerAddress() + "|" + 
                cus.getGender() + "|" + cus.getUserName()
        );
        CloseFileAfterWrite(fileName);
    }
    
    public Customer CreateCustomerFromData(String data){
        String[] a = data.split("\\|");
        Customer cus = new Customer(Integer.parseInt(a[0]), a[1], Integer.parseInt(a[2]), a[3], a[4], a[5], a[6]);
        return cus;
    }
    
    public List<Customer> ReadCustomersFromFile(String fileName){
        List<Customer> list = new ArrayList<>();
        OpenFileToRead(fileName);
        while(scanner.hasNext()){
            String data = scanner.nextLine();
            Customer cus = CreateCustomerFromData(data);
            list.add(cus);
        }
        CloseFileAfterRead(fileName);
        return list;
    }
    
    public void UpdateCustomerFile(List<Customer> list, String fileName){
        File file = new File(fileName);
        if(file.exists()){
            file.delete();
        }
        OpenFileToWrite(fileName);
        for(Customer cus : list){
            printWriter.println(
                    cus.getCustomerId() + "|" + cus.getCustomerName() + "|" + 
                    cus.getAge() + "|" + cus.getCustomerPhoneNumber() + "|" + 
                    cus.getCustomerAddress() + "|" + cus.getGender() + "|" +  cus.getUserName()
            );
        }
        CloseFileAfterWrite(fileName);
    }
    
    //store
    public void UpdateStore(String fileName){
        File file = new File(fileName);
        if(file.exists()){
            file.delete();
        }
        OpenFileToWrite(fileName);
        String AccFile = "ACC.DAT";
        String BillFile = "BILL.DAT";
        String ProFile = "PRODUCT.DAT";
        String CusFile = "CUSTOMER.DAT";
        List<Account> listAcc = ReadAccountFromFile(AccFile);
        List<Bill> listBill = ReadBillsFromFile(BillFile);
        List<Product> listPro = ReadProductsFromFile(ProFile);
        List<Customer> listCus = ReadCustomersFromFile(CusFile);
        int id = 12345;
        String storeName = "Shop of Huan";
        String phone = "0375417808";
        String address = "Doi 1 - Xa Pom Lot - Huyen Dien Bien - Tinh Dien Bien";
        
        double totalRevenue = 0;

        String strPro = "";
        String strBill = "";
        String strAcc = "";
        String strCus = "";
        for(int i = 0; i < listPro.size(); i++){
            strPro += listPro.get(i).getProductId() + "|" + listPro.get(i).getProductName() + "|" + 
                listPro.get(i).getQuantily() + "|" + listPro.get(i).getPrice() + "|" + listPro.get(i).getProductType();
            if(i < listPro.size() - 1)
                strPro += "*";
        }
        for(int j = 0; j < listBill.size(); j++){
            strBill += listBill.get(j).getBillId() + "*" + listBill.get(j).getDateOfPurchase() + "*" 
            + listBill.get(j).getUserNameOfCus() + "*";
            List<Product> listPro2 = listBill.get(j).getProductBought();
            String strPro2 = "";
            for(int i = 0; i < listPro2.size(); i++){
                totalRevenue += listPro2.get(i).getPrice() * listPro2.get(i).getQuantily();
                strPro2 += listPro2.get(i).getProductId() + "|" + listPro2.get(i).getProductName() + "|" + 
                    listPro2.get(i).getQuantily() + "|" + listPro2.get(i).getPrice() + "|" + listPro2.get(i).getProductType();
                if(i < listPro2.size() - 1)
                    strPro2 += "*";
            }
            strBill += strPro2;
            if(j < listBill.size() - 1)
                strBill += "+";
        }
        for(int i = 0; i < listAcc.size(); i++){
            strAcc += listAcc.get(i).getId() + "|" + listAcc.get(i).getFullName() + "|" + listAcc.get(i).getUserName() + "|" + 
                listAcc.get(i).getPassword() + "|" + listAcc.get(i).getEmail() + "|" +  listAcc.get(i).getPhoneNumber()+ "|" + 
                listAcc.get(i).getCreatAt();
            if(i < listAcc.size() - 1)
                strAcc += "+";
        }
        for(int i = 0; i < listCus.size(); i++){
            strCus += listCus.get(i).getCustomerId() + "|" + listCus.get(i).getCustomerName() + "|" + listCus.get(i).getAge() + "|" + 
                listCus.get(i).getCustomerPhoneNumber() + "|" + listCus.get(i).getCustomerAddress() + "|" + 
                listCus.get(i).getGender() + "|" + listCus.get(i).getUserName();
            if(i < listCus.size() - 1)
                strCus += "+";
        }
        printWriter.println(id);
        printWriter.println(storeName);
        printWriter.println(phone);
        printWriter.println(address);
        printWriter.println(strPro);
        printWriter.println(strBill);
        printWriter.println(strAcc);
        printWriter.println(strCus);
        printWriter.println(totalRevenue);
        CloseFileAfterWrite(fileName);
    }
    
    public Store ReadInfoStore(String fileName){
        
        OpenFileToRead(fileName);
        
        String id = scanner.nextLine();
        String name = scanner.nextLine();
        String phone = scanner.nextLine();
        String address = scanner.nextLine();
        String arr[] = scanner.nextLine().split("\\*");
        List<Product> listPro = new ArrayList<>();
        for(String i : arr){
            listPro.add(CreateProductFromData(i));
        }
        arr = scanner.nextLine().split("\\+");
        List<Bill> listBill = new ArrayList<>();
        for(String i : arr){
            listBill.add(CreateBillFromData(i));
        }
        arr = scanner.nextLine().split("\\+");
        List<Account> listAcc = new ArrayList<>();
        for(String i : arr){
            listAcc.add(CreateAccountFromData(i));
        }
        arr = scanner.nextLine().split("\\+");
        List<Customer> listCus = new ArrayList<>();
        for(String i : arr){
            listCus.add(CreateCustomerFromData(i));
        }
        String revenue = scanner.nextLine();
        Store tmp = new Store(Integer.parseInt(id), name, phone, address, listPro, listBill,
                listAcc, listCus, Double.parseDouble(revenue));
        CloseFileAfterRead(fileName);
        return tmp;
    }
}
