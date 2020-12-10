package De1;

import java.util.*;

public class DataController {
    Scanner sc = new Scanner(System.in);
    List<Products> listPro = new ArrayList<>();
    FileController fileController = new FileController();
    
    public List<Products> Input(int n){
        for(int i = 0; i < n; i++){
            Products temp = new Products();
            temp.Input();
            listPro.add(temp);
        }
        return listPro;
    }
    
    public void Display(List<Products> list){
        list.forEach((i) -> {
            System.out.println(i);
        });
    }
    
    public void DeleteAProduct(List<Products> list){
        System.out.print("Enter the id of product to delete: ");
        int id = sc.nextInt();
        boolean check = false;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getId() == id){
                list.remove(i);
                check = true;
                break;
            }
        }
        if(!check){
            System.out.println("This product is not contain");
        }
    }
    
    public void Edit(List<Products> list){
        System.out.print("Enter the id of product to edit: ");
        int id = sc.nextInt();
        boolean check = false;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getId() == id){
                System.out.println("1. Edit a new name");
                System.out.println("2. Edit a new price");
                System.out.println("3. Edit a new quantily");
                System.out.print("Enter the choise: ");
                int choise = sc.nextInt();
                sc.nextLine();
                switch(choise){
                    case 1:
                        System.out.print("Enter a new name: ");
                        list.get(i).setName(sc.nextLine());
                        break;
                    case 2:
                        System.out.print("Enter a new price: ");
                        list.get(i).setPrice(sc.nextDouble());
                        break;
                    case 3:
                        System.out.print("Enter a new quantily: ");
                        list.get(i).setQuantily(sc.nextInt());
                        break;
                    default:
                        System.out.println("your choise is not available");
                }
                check = true;
                break;
            }
        }
        if(!check){
            System.out.println("This product is not contain");
        }
    }
    
    public void SearchProductByName(List<Products> list){
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        boolean check = false;
        
        for(Products i : list){
            if(i.getName().compareTo(name) == 0){
                check = true;
                break;
            }
        }
        
        if(check){
            list.forEach((i) -> {
                if(i.getName().compareTo(name) == 0)
                    System.out.println(i);
            });
        }else {
            System.out.println("Without this product");
        }
    }
    
    public void SortProductsByPrice(List<Products> list){
        list.sort((o1, o2) -> {
            if(o1.getPrice() < o2.getPrice())
                return -1;
            else if(o1.getPrice() > o2.getPrice())
                return 1;
            else 
                return 0;
        });
    }
    
    public void WriteProductsToFile(List<Products> list, String fileName){
        fileController.WriteProductsToFile(list, fileName);
    }
    
    public void ReadProductsFromFile(String fileName){
        List<Products> list = fileController.ReadProductsFromFile(fileName);
        list.forEach((i) -> {
            System.out.println(i);
        });
    }
}
