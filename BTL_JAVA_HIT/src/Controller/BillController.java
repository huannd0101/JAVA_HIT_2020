package Controller;
import BTL.Bill;
import BTL.CheckAll;
import BTL.Product;
import Controller.*;
import java.util.*;
public class BillController {
    final String BILL_FILE_NAME = "BILL.DAT";
    FileController fileController = new FileController();
    CheckAll checkAll = new CheckAll();
    List<Bill> listBill;
    Scanner sc = new Scanner(System.in);
    
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
    
    public void ShowAllListBill() {
        listBill = fileController.ReadBillsFromFile(BILL_FILE_NAME);
        for(Bill i : listBill){
            System.out.println(i);        
        }
    }
    
    public void UpdateListBill() {
        System.out.println("---------------------Update Bills------------------------");
        System.out.println("1. Insert a new bill");
        System.out.println("2. Delete a bill by id");
        System.out.println("3. Repair a bill by id");
        System.out.println("0. Exit");
        System.out.println("------------------------------------------------------------");
        int choise = Choose(0, 3);
        
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
                        int choise2 = Choose(1, 3);
                        
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
                                        int choise3 = Choose(1, 4);

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
    
    public void SortListBill() {
        System.out.println("------------------Sort list bill-------------------");
        System.out.println("1. Sort by id");
        System.out.println("2. Sort by date of purchse");
        System.out.println("3. Sort by userName of customer");
        System.out.println("0. Exit");
        System.out.println("------------------------------------------------------");
                
        int choise = Choose(0, 3);
        
        listBill = fileController.ReadBillsFromFile(BILL_FILE_NAME);
        int n = listBill.size();
        switch(choise){
            case 1:
                listBill.sort((o1, o2) -> {
                    if(o1.getBillId() < o2.getBillId())
                        return -1;
                    else if(o1.getBillId() > o2.getBillId())
                        return 1;
                    else 
                        return 0;
                });
                System.out.println("Sort by id successful");
                break;
            case 2:
                listBill.sort((o1, o2) -> {
                    if(o1.getDateOfPurchase().compareTo(o2.getDateOfPurchase()) < 0)
                        return -1;
                    else if(o1.getDateOfPurchase().compareTo(o2.getDateOfPurchase()) > 0)
                        return 1;
                    else 
                        return 0;
                });
                System.out.println("Sort by date of purchse successful");
                break;
            case 3:
                listBill.sort((o1, o2) -> {
                    if(o1.getUserNameOfCus().compareTo(o2.getUserNameOfCus()) < 0)
                        return -1;
                    else if(o1.getUserNameOfCus().compareTo(o2.getUserNameOfCus()) > 0)
                        return 1;
                    else 
                        return 0;
                });
                System.out.println("Sort by userName of customer successful");
                break;
            case 0:
                break;
        }
        fileController.UpdateBillFile(listBill, BILL_FILE_NAME);
    }
    
    public void SearchAndShowInfoBill() {
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
        
        choise = Choose(0, 3);
        
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
                if(!check){
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
                if(!check){
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
                if(!check){
                    System.out.println("\nThis bill not contain in shop");
                }
                break;
            case 0: 
                break;
        }
    }
}
