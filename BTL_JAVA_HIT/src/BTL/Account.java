package BTL;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Account {
    private int id;
    private String fullName;
    private String userName;
    private String password;
    private String phoneNumber;
    private String email;
    private String creatAt;

    public Account() {
    }

    public Account(int id, String fullName, String userName, String password, String email, String phoneNumber, String creatAt) {
        this.id = id;
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.creatAt = creatAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(String creatAt) {
        this.creatAt = creatAt;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + 
                ", fullName=" + fullName + 
                ", userName=" + userName + 
                ", password=" + password + 
                ", email=" + email + 
                ", phoneNumber=" + phoneNumber + 
                ", creatAt=" + creatAt + '}';
    }
    
    public int GetIdMaxOfListAccount(){
        FileController fileController = new FileController();
        List<Account> list = fileController.ReadAccountFromFile("ACC.DAT");
        int max = list.get(0).getId();
        for(Account i : list){
            max = (max > i.getId()) ? max : i.getId();
        }
        return max;
    }
    
    public void Input(){
        Scanner sc = new Scanner(System.in);
        Pattern pattern;
        String regUserName = "^[a-zA-Z0-9]{6,}$";
        String regPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,}$";
        String regPhone = "^[0-9\\-\\+]{9,15}$";
        String regEmail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        boolean check = true;
        boolean check2 = true;
        CheckAll checkAll = new CheckAll();
//        System.out.print("Enter id: ");
//        do {
//            this.id = sc.nextInt();
//            sc.nextLine();
//            check = checkAll.CheckIdAccount(id);
//            if(check){
//                System.out.print("Id is contain!\nPlease enter id again: ");
//            }
//        }while(check);
        this.id = GetIdMaxOfListAccount() + 1;
        
        System.out.print("Enter full name: ");
        this.fullName = sc.nextLine();
        System.out.print("Enter user name: ");
        pattern = Pattern.compile(regUserName);
        do {
            this.userName = sc.nextLine();
            check = checkAll.CheckUserNameAccount(this.userName);
            check2 = pattern.matcher(this.userName).find();
            if(check){
                System.out.print("UserName is contain!\nPlease enter userName again: ");
            }else if(!check2){
                System.out.print("Please enter userName again: ");
            }
        }while(check == true || check2 == false);
        
        System.out.print("Enter password: ");
        pattern = Pattern.compile(regPassword);
        String tmp;
        do {
            tmp = sc.nextLine();
            check2 = pattern.matcher(tmp).find();
            if(!check2){
                System.out.print("Password wrong :v \nEnter password again: ");
            }
        }while(!check2);
        System.out.print("Enter password once again: ");
        do {
            this.password = sc.nextLine();
            if(this.password.compareTo(tmp) != 0){
                System.out.print("Password is false!\nPlease enter again: ");
            }
        }while(this.password.compareTo(tmp) != 0);
        
        System.out.print("Enter phone number: ");
        pattern = Pattern.compile(regPhone);
        do {
            this.phoneNumber = sc.nextLine();
            check2 = pattern.matcher(this.phoneNumber).find();
            if(!check2){
                System.out.print("Enter phone number again: ");
            }
        }while(!check2);
        
        System.out.print("Enter email: ");
        pattern = Pattern.compile(regEmail);
        do {
            this.email = sc.nextLine();
            check2 = pattern.matcher(this.email).find();
            if(!check2){
                System.out.print("Enter email again: ");
            }
        }while(!check2);
        
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.creatAt = simpleDateFormat.format(date);
    }
}
