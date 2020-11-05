
package Bai2;

public class RunMain {
    public static void main(String[] args) {
        Ishape[] shapes = new Ishape[3];
        shapes[0] = new Rectangle(3.4, 5.3);
        shapes[1] = new Circle(5.5);
        shapes[2] = new Rectangle(7.4, 4.3);
        
        for(int i = 0; i < 3; i++){
            System.out.println("Area of shapes[" + i + "]: " + shapes[i].getArea());
            System.out.println("Perimeter of shapes[" + i + "]: " + shapes[i].getPerimeter());
            System.out.println("");
        }  
    }
}
