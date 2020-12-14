package Controller;

import BTL.Account;
import BTL.CheckAll;
import java.util.*;
import java.util.regex.Pattern;

public class AccController {
    final String ACC_FILE_NAME = "ACC.DAT";
    FileController fileController = new FileController();
    CheckAll checkAll = new CheckAll();
    List<Account> listAcc;
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
    
    public void ShowAllList(){
        listAcc = fileController.ReadAccountFromFile(ACC_FILE_NAME);
        listAcc.forEach((i) -> {
            System.out.println(i);
        });
    }
    
    public void UpdateListAccount(){
        System.out.println("--------------------Update list Account----------------------");
        System.out.println("1. Insert a new account");
        System.out.println("2. Delete a account by id");
        System.out.println("3. Repair a account by id");
        System.out.println("0. Exit");
        System.out.println("--------------------------------------------------------------");
        int choise = 0;
        
        choise = Choose(0, 3);
        
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
                
                choise = Choose(0, 6);
                
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
                                i.setFullName(i.InputFullName());
                                break;
                            case 3:
                                i.setUserName(i.InputUserName());
                                break;
                            case 4:
                                i.setPassword(i.InputPassword());
                                break;
                            case 5:
                                i.setPhoneNumber(i.InputPhoneNumber());
                                break;
                            case 6:
                               i.setEmail(i.InputEmail());
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
    
    public void SearchAndShowInfoAccount(){
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
        
        choise = Choose(0, 6);
        
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
    
    public void SortListAccount() {
        System.out.println("------------------Sort list account-------------------");
        System.out.println("1. Sort by id");
        System.out.println("2. Sort by name");
        System.out.println("3. Sort by userName");
        System.out.println("4. Sort by email");
        System.out.println("5. Sort by createAt");
        System.out.println("0. Exit");
        System.out.println("------------------------------------------------------");
                
        int choise = 0;
        choise = Choose(0, 5);
        
        listAcc = fileController.ReadAccountFromFile(ACC_FILE_NAME);
        
        switch(choise){
            case 1:
                listAcc.sort((o1, o2) -> {
                    if(o1.getId() < o2.getId())
                        return -1;
                    else if(o1.getId() > o2.getId())
                        return 1;
                    else 
                        return 0;
                });
                System.out.println("Sort by id successful");
                break;
            case 2:
                listAcc.sort((o1, o2) -> {
                    if(o1.getFullName().compareTo(o2.getFullName()) < 0)
                        return -1;
                    else if(o1.getFullName().compareTo(o2.getFullName()) > 0)
                        return 1;
                    else 
                        return 0;
                });
                System.out.println("Sort by name successful");
                break;
            case 3:
                listAcc.sort((o1, o2) -> {
                    if(o1.getUserName().compareTo(o2.getUserName()) < 0)
                        return -1;
                    else if(o1.getUserName().compareTo(o2.getUserName()) > 0)
                        return 1;
                    else 
                        return 0;
                });
                System.out.println("Sort by userName successful");
                break;
            case 4:
                listAcc.sort((o1, o2) -> {
                    if(o1.getEmail().compareTo(o2.getEmail()) < 0)
                        return -1;
                    else if(o1.getEmail().compareTo(o2.getEmail()) > 0)
                        return 1;
                    else 
                        return 0;
                });
                System.out.println("Sort by email successful");
                break;
            case 5: 
                listAcc.sort((o1, o2) -> {
                    if(o1.getCreatAt().compareTo(o2.getCreatAt()) < 0)
                        return -1;
                    else if(o1.getCreatAt().compareTo(o2.getCreatAt()) > 0)
                        return 1;
                    else 
                        return 0;
                });
                System.out.println("Sort by gender successful");
                break;
            case 0:
                break;
        }
        fileController.UpdateAccountFile(listAcc, ACC_FILE_NAME);
    }
    
    public void SignUpForAnAccount(){
        listAcc = fileController.ReadAccountFromFile(ACC_FILE_NAME);
        Account tmp = new Account();
        tmp.Input();
        listAcc.add(tmp);
        fileController.UpdateAccountFile(listAcc, ACC_FILE_NAME);
        System.out.println("Create a new account successful");
    }
    
    public String Login(){
        String user;
        boolean check = false;
        do {
            System.out.print("Enter your userName: ");
            user = sc.nextLine();
            System.out.print("Enter your password: ");
            String pass = sc.nextLine();
            if(checkAll.CheckUserNameAccount(user) && checkAll.CheckPasswordAccount(pass)){
                System.out.println("Login successfull");
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
    
    public void ChangeMyPassword(String user){
        listAcc = fileController.ReadAccountFromFile(ACC_FILE_NAME);
        String regPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,}$";
        for(Account i : listAcc){
            if(i.getUserName().compareTo(user) == 0){
                System.out.print("Enter your new pass: ");
                Pattern pattern = Pattern.compile(regPassword);
                String newPass, newPass2;
                do {
                    newPass = sc.nextLine();
                    if(!pattern.matcher(newPass).find()){
                        System.out.print("Enter your new password again: ");
                    }else {
                        System.out.print("Enter your new password once more: ");
                        do {
                            newPass2 = sc.nextLine();
                            if(newPass2.compareTo(newPass) != 0){
                                System.out.print("The password does not match!\nPlease enter new password once again: ");
                            }
                        }while(newPass2.compareTo(newPass) != 0);
                        i.setPassword(newPass);
                        System.out.println("Change password successful\n");
                        break;
                    }
                }while(true);
                break;
            }
        }
        fileController.UpdateAccountFile(listAcc, ACC_FILE_NAME);
    }
}
