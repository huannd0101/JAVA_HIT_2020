package De1;

import java.util.*;

public class RunMain {
    
    static List<Products> listPro = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static DataController dataController = new DataController();
    
    public static void main(String[] args) {
        do {
            System.out.println("----------------------------------------------------");
            System.out.println("1. Add products");
            System.out.println("2. Display products");
            System.out.println("3. Delete a product");
            System.out.println("4. Edit a product");
            System.out.println("5. Search for product by name");
            System.out.println("6. Sort product by price");
            System.out.println("7. Save products to text/binary file");
            System.out.println("8. Load products from the seved file");
            System.out.println("----------------------------------------------------");
            int choise = 0;
            System.out.print("Enter your choise: ");
            try {
                choise = sc.nextInt();
            }catch(Exception e){
                System.out.println("Choise is not a number");
            }

            switch(choise){
                case 1:
                    System.out.print("Enter the number n = ");
                    int n = sc.nextInt();
                    listPro = dataController.Input(n);
                    break;
                case 2:
                    dataController.Display(listPro);
                    break;
                case 3:
                    dataController.DeleteAProduct(listPro);
                    break;
                case 4:
                    dataController.Edit(listPro);
                    break;
                case 5:
                    dataController.SearchProductByName(listPro);
                    break;
                case 6:
                    dataController.SortProductsByPrice(listPro);
                    break;
                case 7:
                    dataController.WriteProductsToFile(listPro, "PRODUCT.txt");
                    break;
                case 8:
                    dataController.ReadProductsFromFile("PRODUCT.txt");
                    break;
                case 0:    
                    System.exit(0);
            }
        }while(true);
    }
}
