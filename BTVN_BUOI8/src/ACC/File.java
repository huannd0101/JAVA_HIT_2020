
package ACC;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class File {
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private PrintWriter printWriter;
    private Scanner scanner;
    
    public void OpenFileToWrite(String fileName){
        try{
            fileWriter = new FileWriter(fileName, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
        }catch(IOException ex){
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
        
    }
}
