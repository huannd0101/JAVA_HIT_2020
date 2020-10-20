
package Bai4;

import java.util.ArrayList;
import java.util.Scanner;

public class RunMain {
    
    public static ArrayList<SinhVien> myList = new ArrayList<>();
    
    public static void main(String[] args) {
        Menu();
     
    }         

    public static void Title(){
        System.out.println("-----------------------------Menu-----------------------------");
        System.out.println("| 1. Add student.                                            |");
        System.out.println("| 2. Edit student by id.                                     |");
        System.out.println("| 3. Delete student by id.                                   |");
        System.out.println("| 4. Sort students by gpa.                                   |");
        System.out.println("| 5. Sort students by name.                                  |");
        System.out.println("| 6. Show students.                                          |");
        System.out.println("| 0. Exit.                                                   |");
        System.out.println("--------------------------------------------------------------");
    }
    
    private static void Menu() {
        Scanner sc = new Scanner(System.in);
        char c;
        do {
            Title();
            System.out.print("\nNhập lựa chọn: ");
            int luaChon = sc.nextInt();
            sc.nextLine();
            switch(luaChon){
                case 1:
                    AddStudent();
                    break;
                case 2:
                    EditStudentById(); 
                    break;
                case 3:
                    DeleteStudentById();      
                    break;
                case 4: 
                    SortStudentsByGpa();
                    break;
                case 5:
                    SortStudentsByName();
                    break;
                case 6:
                    ShowStudents();
                    break;
                case 0:
                    System.exit(0);
            }
            System.out.print("\nBạn có muốn tiếp tục không? (c/k): ");
            c = sc.next().charAt(0);
            if(c == 'k')
                System.out.println("\n-------------Chào hẹn gặp lại Huân nhé <3-------------");
        }while(c != 'k');
    }
    
    private static void AddStudent() {
        SinhVien x = new SinhVien();
        boolean check = true;
        do{
            x.Input();
            for(int i = 0; i < myList.size(); i++){
                if(myList.get(i).getId().compareTo(x.getId()) == 0){
                    System.out.println("Id bị trùng yêu cầu nhập lại thông tin sinh viên này :v");
                    check = false;
                    break;
                }else {
                    check = true;
                }
            }
        }while(!check);
        myList.add(x);
    }

    private static void EditStudentById() {
        Scanner sc = new Scanner(System.in);
        if(myList.size() <= 0){
            System.out.println("Không có sinh viên nào trong danh sách để sửa cả :v");
        }else {
            boolean check = false;
            int pos = 0;
            System.out.print("Nhập ID của sinh viên cần sửa: ");
            String SearchById = sc.nextLine();
            for(int i = 0; i < myList.size(); i++){
                if(myList.get(i).getId().compareTo(SearchById) == 0){
                    check = true;
                    pos = i;
                    break;
                }
            }
            if(check){
                SinhVien x = new SinhVien();
                x.Input();
                myList.remove(pos);
                myList.add(pos, x);
            }else {
                System.out.println("Không có mã sinh viên này :v");
            }
        }
    }

    private static void DeleteStudentById() {
        Scanner sc = new Scanner(System.in);
        if(myList.size() <= 0){
            System.out.println("Không có sinh viên nào trong danh sách để xóa");
        }else {
            boolean check = true;
            System.out.print("Nhập ID của sinh viên cần xóa: ");
            String searchStudentById = sc.nextLine();
            for(int i = 0; i < myList.size(); i++){
                if(myList.get(i).getId().compareTo(searchStudentById) == 0){
                    myList.remove(i);
                    check = false;
                    break;
                }  
            }
            if(check){
                System.out.println("Không có mã sinh viên này!!!!");
            }
        }
    }

    private static void SortStudentsByGpa() {
        if(myList.size() < 1){
            System.out.println("Không có sinh viên nào để sắp xếp!!!");
        }else {
            for(int i = 0; i < myList.size() - 1; i++){
                if(myList.get(i).getGpa() > myList.get(i + 1).getGpa()){
                    SinhVien temp = myList.get(i);
                    myList.set(i, myList.get(i + 1));
                    myList.set(i + 1, temp);
                }
            }
        }
    }

    private static void SortStudentsByName() {
        if(myList.size() < 1){
            System.out.println("Không có sinh viên nào để sắp xếp!!!");
        }else {
            for(int i = 0; i < myList.size() - 1; i++){
                if(myList.get(i).getName().compareToIgnoreCase(myList.get(i + 1).getName()) > 0){
                    SinhVien temp = myList.get(i);
                    myList.set(i, myList.get(i + 1));
                    myList.set(i + 1, temp);
                }
            }
        }
    }

    private static void ShowStudents() {
        if(myList.size() < 1)
            System.out.println("Danh sách rỗngggggggggggg");
        else {
            System.out.printf("%20s %30s %10s %30s %15s\n", "ID", "Name", "Age", "Address", "Gpa");
            for(SinhVien i : myList){
                i.Output();
            }
        }
    }
}
