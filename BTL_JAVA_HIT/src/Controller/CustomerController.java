package Controller;

import BTL.*;
import Controller.*;
import java.util.*;

public class CustomerController {
    final String CUSTOMER_FILE_NAME = "CUSTOMER.DAT";
    final String BILL_FILE_NAME = "BILL.DAT";
    FileController fileController = new FileController();
    CheckAll checkAll = new CheckAll();
    List<Customer> listCus;
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
    
    public void ShowAllListCustomer() {
        listCus = fileController.ReadCustomersFromFile(CUSTOMER_FILE_NAME);
        for(Customer i : listCus){
            System.out.println(i);
        }
    }

    public void ShowAllListVIPCustomer() {
        listCus = fileController.ReadCustomersFromFile(CUSTOMER_FILE_NAME);
        listBill = fileController.ReadBillsFromFile(BILL_FILE_NAME);
        boolean check = false;
        for(Customer i : listCus){
            String userName = i.getUserName();
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

    public void UpdateListCustomer() {
        System.out.println("--------------------Update list customer----------------------");
        System.out.println("1. Insert a new customer");
        System.out.println("2. Delete a customer by id");
        System.out.println("3. Repair a customer by id");
        System.out.println("0. Exit");
        System.out.println("--------------------------------------------------------------");
        int choise = Choose(0, 3);
        
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
                
                choise = Choose(0, 7);
                
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
    
    public void SearchAndShowInfoCustomer() {
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
        
        choise = Choose(0, 7);
        
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
    
    public void SortListCustomer() {
        System.out.println("------------------Sort list customer-------------------");
        System.out.println("1. Sort by id");
        System.out.println("2. Sort by name");
        System.out.println("3. Sort by age");
        System.out.println("4. Sort by address");
        System.out.println("5. Sort by gender");
        System.out.println("6. Sort by userName");
        System.out.println("0. Exit");
        System.out.println("------------------------------------------------------");
                
        int choise = Choose(0, 6);
        
        listCus = fileController.ReadCustomersFromFile(CUSTOMER_FILE_NAME);
        int n = listCus.size();
        switch(choise){
            case 1:
                listCus.sort((o1, o2) -> {
                    if(o1.getCustomerId() < o2.getCustomerId())
                        return -1;
                    else if(o1.getCustomerId() > o2.getCustomerId())
                        return 1;
                    else 
                        return 0;
                });
                System.out.println("Sort by id successful");
                break;
            case 2:
                listCus.sort((o1, o2) -> {
                    if(o1.getCustomerName().compareTo(o2.getCustomerName()) < 0)
                        return -1;
                    else if(o1.getCustomerName().compareTo(o2.getCustomerName()) > 0)
                        return 1;
                    else 
                        return 0;
                });
                System.out.println("Sort by name successful");
                break;
            case 3:
                listCus.sort((o1, o2) -> {
                    if(o1.getAge() < o2.getAge())
                        return -1;
                    else if(o1.getAge() > o2.getAge())
                        return 1;
                    else 
                        return 0;
                });
                System.out.println("Sort by age successful");
                break;
            case 4:
                listCus.sort((o1, o2) -> {
                    if(o1.getCustomerAddress().compareTo(o2.getCustomerAddress()) < 0)
                        return -1;
                    else if(o1.getCustomerAddress().compareTo(o2.getCustomerAddress()) > 0)
                        return 1;
                    else 
                        return 0;
                });
                System.out.println("Sort by address successful");
                break;
            case 5: 
                listCus.sort((o1, o2) -> {
                    if(o1.getGender().compareTo(o2.getGender()) < 0)
                        return -1;
                    else if(o1.getGender().compareTo(o2.getGender()) > 0)
                        return 1;
                    else 
                        return 0;
                });
                System.out.println("Sort by gender successful");
                break;
            case 6: 
                listCus.sort((o1, o2) -> {
                    if(o1.getUserName().compareTo(o2.getUserName()) < 0)
                        return -1;
                    else if(o1.getUserName().compareTo(o2.getUserName()) > 0)
                        return 1;
                    else 
                        return 0;
                });
                System.out.println("Sort by userName successful");
                break;
            case 0:
                break;
        }
        fileController.UpdateCustomerFile(listCus, CUSTOMER_FILE_NAME);
    }
    
    public void ShowAllBillOfCustomer(String user){
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
}
