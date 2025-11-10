class Outer{

    private String message = "This is outer class";
    
    void OuterMethod(){
        System.out.println("Outer method");
    }
    class Inner{
        private String message = "This is inner class";

        void show(){
            System.out.println("Inner message: " + this.message);
            System.out.println("Outer message: " + Outer.this.message);
            Outer.this.OuterMethod();
        }
    }
}

public class ques9 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.show();
    }
}
