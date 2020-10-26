package Bai2;

import java.util.ArrayList;
import java.util.Scanner;

public class RunMain {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Book> list = new ArrayList<>();
        
        do{
            System.out.println("--------------------Menu----------------------");
            System.out.println("\t1.Add book");
            System.out.println("\t2.Edit book by id");
            System.out.println("\t3.Delete book by id");
            System.out.println("\t4.Sort book by name (ascending)");
            System.out.println("\t5.Sort book by price descending)");
            System.out.println("\t6.Show all books");
            System.out.println("\t0.Exit");
            System.out.println("----------------------------------------------");
            
            System.out.print("Your choise: ");
            int choise = sc.nextInt();
            sc.nextLine();
            
            switch(choise){
                case 1: 
                    AddBook(list);
                    break;
                case 2:
                    ShowBooks(list);
                    EditBookById(list);
                    break;
                case 3:
                    ShowBooks(list);
                    DeleteBookById(list);
                    break;
                case 4:
                    SortBookByName(list);
                    ShowBooks(list);
                    break;
                case 5:
                    SortBookByPrice(list);
                    ShowBooks(list);
                case 6:
                    ShowBooks(list);
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
            
        }while(true);     
    }

    private static void ShowBooks(ArrayList<Book> list) {
        if(list.size() < 1)
            System.out.println("The list is empty");
        else {
            for(Book i : list)
                System.out.println(i);
        }
    }

    private static void AddBook(ArrayList<Book> list) {
        Book x = new Book();
        x.Input();
        
        if(CheckId(list, x.getId())){
            System.out.println("Add book thất bại vì trùng id :v");
        }else {
            list.add(x);
        }
    }

    private static void EditBookById(ArrayList<Book> list) {
        if(list.size() < 1)
            System.out.println("The list is empty");
        else {
            boolean checkId = false;
            System.out.print("Enter id to delete a book: ");
            int id = sc.nextInt();
            checkId = CheckId(list, id);
            
            if(checkId){
                Book book = GetBook(list, id);
                int choise = 0;
                do{
                    System.out.println("1.Edit id");
                    System.out.println("2.Edit name");
                    System.out.println("3.Edit publisher");
                    System.out.println("4.Edit price");
                    System.out.println("5.Edit numOfPage");
                    System.out.println("6.Edit author");
                    
                    System.out.print("Your choise: ");
                    choise = sc.nextInt();
                    
                    switch(choise){
                        case 1:
                            System.out.print("Enter id: ");
                            int idToEdit = 0;
                            do {
                               idToEdit = sc.nextInt();
                               if(CheckId(list, idToEdit))
                                    System.out.print("Enter id again: ");
                            }while(CheckId(list, idToEdit));
                            book.setId(idToEdit);
                            break;
                        case 2:
                            System.out.print("Enter name: ");
                            String name = sc.nextLine();
                            book.setName(name);
                            break;
                        case 3:
                            System.out.print("Enter publisher: ");
                            String publisher = sc.nextLine();
                            book.setPublisher(publisher);
                            break;
                        case 4:
                            System.out.print("Enter price");
                            double price = sc.nextDouble();
                            book.setPrice(price);
                            break;
                        case 5:
                            System.out.print("Enter numOfPage: ");
                            int numOfPage = sc.nextInt();
                            book.setNumOfPage(numOfPage);
                            break;
                        case 6:
                            System.out.print("Enter author: ");
                            String author = sc.nextLine();
                            book.setAuthor(author);
                            break;
                    }
                }while(choise < 1 || choise > 6);
            }else {
                System.out.println("Không có id này trong list book");
            }
        }
    }

    private static void DeleteBookById(ArrayList<Book> list) {
        if(list.size() < 1)
            System.out.println("The list is empty");
        else {
            boolean checkId = false;
            System.out.println("Enter id to delete a book: ");
            int id = sc.nextInt();
            checkId = CheckId(list, id);
            if(checkId){
                for(Book i : list)
                    if(i.getId() == id){
                        list.remove(i);
                        break;
                    }
            }else{
                System.out.println("Không có id này để xóa book");
            }
        }
    }

    private static void SortBookByName(ArrayList<Book> list) {
        if(list.size() < 1)
            System.out.println("The list is empty");
        else {
            for(int i = 0; i < list.size() - 1; i++){
                for(int j = list.size() - 1; j > i; j--){
                    if(list.get(j - 1).getName().compareToIgnoreCase(list.get(j).getName()) > 0){
                        Book temp = list.get(j - 1);
                        list.set(j - 1, list.get(j));
                        list.set(j, temp);
                    }
                }
            }
        }
    }

    private static void SortBookByPrice(ArrayList<Book> list) {
        if(list.size() < 1)
            System.out.println("The list is empty");
        else {
            for(int i = 0; i < list.size() - 1; i++){
                for(int j = list.size() - 1; j > i; j--){
                    if(list.get(j - 1).getPrice() < list.get(j).getPrice()){
                        Book temp = list.get(j - 1);
                        list.set(j - 1, list.get(j));
                        list.set(j, temp);
                    }
                }
            }
        }
    }
    
    private static boolean CheckId(ArrayList<Book> list, int id){
        for(Book i : list)
            if(i.getId() == id)
                return true;
        return false;
    }
    
    private static Book GetBook(ArrayList<Book> list, int id){
        for(Book i : list)
            if(i.getId() == id)
                return i;
        return null;
    }
}
