
package Bai4;

public class RunMain {
    public static void main(String[] args) {
        Array arr1 = new Array();
        Array arr2 = new Array();
        arr1.InputData();
        double TBC1 = 1.0 * arr1.Sum() / arr1.getN();
        arr2.InputData();
        double TBC2 = 1.0 * arr1.Sum() / arr2.getN();
        if(TBC1 > TBC2)
            System.out.println("Mảng 1 có TBC lớn hơn mảng 2");
        else if(TBC1 < TBC2)
            System.out.println("Mảng 1 có TBC nhỏ hơn mảng 2");
        else 
            System.out.println("Hi");
    }
}
