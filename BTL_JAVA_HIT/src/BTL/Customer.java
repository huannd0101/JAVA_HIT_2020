
package BTL;

import java.util.Scanner;

public class Customer {
    private int customerId;
    private String customerName;
    private int age;
    private String customerPhoneNumber;
    private String customerAddress;
    private String gender;
    private String userName;

    public Customer() {
    }

    public Customer(int customerId, String customerName, int age, String customerPhoneNumber, String customerAddress, String gender, String userName) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.age = age;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerAddress = customerAddress;
        this.gender = gender;
        this.userName = userName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Customer{" + 
                "customerId=" + customerId + 
                ", customerName=" + customerName + 
                ", age=" + age + 
                ", customerPhoneNumber=" + customerPhoneNumber + 
                ", customerAddress=" + customerAddress + 
                ", gender=" + gender + 
                ", userName=" + userName + '}';
    }
    
    public void Input(){
        Scanner sc  = new Scanner(System.in);
        System.out.print("Enter customer id: ");
        CheckAll checkAll = new CheckAll();
        boolean check = true;
        do {
            this.customerId = sc.nextInt();
            sc.nextLine();
            check = checkAll.CheckIdCustomer(this.customerId);
            if(check){
                System.out.print("Enter customer id again: ");
            }
        }while(check);
        
        System.out.print("Enter customer name: ");
        this.customerName = sc.nextLine();
        System.out.print("Enter customer age: ");
        this.age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter customer phone number: ");
        this.customerPhoneNumber = sc.nextLine();
        System.out.print("Enter customer address: ");
        this.customerAddress = sc.nextLine();
        System.out.print("Enter customer gender: ");
        this.gender = sc.nextLine();
        System.out.print("Enter customer UserName: ");
        this.userName = sc.nextLine();
    }
}
