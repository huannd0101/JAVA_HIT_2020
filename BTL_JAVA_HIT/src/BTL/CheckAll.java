package BTL;

import Controller.FileController;
import java.util.ArrayList;
import java.util.List;

public class CheckAll {
    private FileController fileController = new FileController();
    
    public boolean CheckIdProduct(int id){
        List<Product> list = fileController.ReadProductsFromFile("PRODUCT.DAT");
        for(Product i : list){
                if(id == i.getProductId()){
                    return true;
                }
            }
        return false;
    }
    
    public boolean CheckIdBill(int id){
        List<Bill> list = fileController.ReadBillsFromFile("BILL.DAT");
        for(Bill i : list){
                if(id == i.getBillId()){
                    return true;
                }
            }
        return false;
    }
    
    public boolean CheckIdCustomer(int id){
        List<Customer> list = fileController.ReadCustomersFromFile("CUSTOMER.DAT");
        for(Customer i : list){
                if(id == i.getCustomerId()){
                    return true;
                }
            }
        return false;
    }
    
    public boolean CheckIdCustomerFromBill(int id, Bill bill){
        List<Product> list = bill.getProductBought();
        for(Product i : list){
                if(id == i.getProductId()){
                    return true;
                }
            }
        return false;
    }
    
    public boolean CheckIdAccount(int id){
        List<Account> list = fileController.ReadAccountFromFile("ACC.DAT");
        for(Account i : list){
                if(id == i.getId()){
                    return true;
                }
            }
        return false;
    }
    
    public boolean CheckUserNameAccount(String userName){
        List<Account> list = fileController.ReadAccountFromFile("ACC.DAT");
        for(Account i : list){
                if(userName.compareTo(i.getUserName()) == 0){
                    return true;
                }
            }
        return false;
    }
    
    public boolean CheckPasswordAccount(String pass){
        List<Account> list = fileController.ReadAccountFromFile("ACC.DAT");
        for(Account i : list)
            if(pass.compareTo(i.getPassword()) == 0)
                return true;
        return false;
    }
    
    public boolean CheckUserNameFromBill(String userName){
        List<Bill> listBill = fileController.ReadBillsFromFile("BILL.DAT");
        for(Bill i : listBill){
            if(i.getUserNameOfCus().compareTo(userName) == 0){
                return true;
            }
        }
        return false;
    }
    
    public boolean CheckViper(String userName){
        List<Bill> listBill = fileController.ReadBillsFromFile("BILL.DAT");
        double sum = 0;
        int countOfBill = 0;
        for(Bill i : listBill){
            if(i.getUserNameOfCus().compareTo(userName) == 0){
                List<Product> listProducts = i.getProductBought();
                for(Product j : listProducts){
                    sum += j.GetMoney();
                }
                countOfBill++;
            }
        }
        if(sum >= 1000000 || countOfBill >= 3){
            return true;
        }
        return false;
    }
    
}
