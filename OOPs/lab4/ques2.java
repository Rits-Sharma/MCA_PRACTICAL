// package assignment;

class rectangle{
    int width, height;

    public rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }
    public rectangle(int width){
        this(width,20);
    }
    public void display(){
        System.out.println("Width: " + width + ", Height: " + height);
    }
}


public class ques2 {
    public static void main(String[] args) {
        rectangle rect1 = new rectangle(10, 30);
        rectangle rect2 = new rectangle(15);

        rect1.display();
        rect2.display();
    }    
}