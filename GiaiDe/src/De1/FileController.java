package De1;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class FileController {
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;
    PrintWriter printWriter;
    Scanner scanner;
    
    public void OpenFileToWrite(String fileName){
        try {
            fileWriter = new FileWriter(fileName);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void CloseFileAfterWrite(){
        try {
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    public void OpenFileToRead(String fileName){
        try {
            scanner = new Scanner(Paths.get(fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void CloseFileAfterRead(){
        scanner.close();
    }
    
    public void WriteProductsToFile(List<Products> list, String fileName){
        OpenFileToWrite(fileName);
        list.forEach((i) -> {
            printWriter.println(i.getId() + "|" + i.getName() + "|" + i.getPrice() + "|" + i.getQuantily());
        });
        CloseFileAfterWrite();
    }
    
    public Products CreateProductFromData(String data){
        String[] a = data.split("\\|");
        Products tmp = new Products(Integer.parseInt(a[0]), a[1], Double.parseDouble(a[2]), Integer.parseInt(a[3]));
        return tmp;
    }
    
    public List<Products> ReadProductsFromFile(String fileName){
        List<Products> list = new ArrayList<>();
        OpenFileToRead(fileName);
        while(scanner.hasNext()){
            list.add(CreateProductFromData(scanner.nextLine()));
        }
        return list;
    }
}
