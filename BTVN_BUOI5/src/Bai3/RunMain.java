
package Bai3;

import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Phieu phieu = new Phieu();
        
        phieu.InputPhieu();
        System.out.println("----------------------------------------------------------------------------------");
        phieu.OutputPhieu();
    }
}
