
package bai2;

import ClassSource.Dog;


public class RunMain {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        dog1.InputName("NameOfDog");
        for(int i = 0; i < 3; i++){
            dog1.Bark();
            dog1.ShowMP();
        }
    }
}
