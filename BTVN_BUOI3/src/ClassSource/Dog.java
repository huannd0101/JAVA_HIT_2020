package ClassSource;


public class Dog {
    private String name;
    private int MP = 100;
    
    public Dog(){
        
    }
    
    public void InputName(String name){
        this.name = name;
    }
    public void ShowMP(){
        System.out.println("MP: " + this.MP);
    }
    public void Bark(){
        if(this.name == null){
            System.out.println("Xin lỗi bạn chưa điền tên");
        }else {
            this.MP -= 20;
            System.out.println(this.name + " gâu gâu");
        }
    }
}

