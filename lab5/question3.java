/*
 * 3. Design a class ComplexNumber that models complex numbers. Write a copy constructor that takes another ComplexNumber object and initializes the current object’s real and imaginary parts with the copied values. 
 */

class ComplexNumber{
    double a,b;
    public ComplexNumber(double a, double b){
        this.a = a;
        this.b = b;
    }
    public ComplexNumber(ComplexNumber complexNumber){
        this.a = complexNumber.a;
        this.b = complexNumber.b;
    }
    void display(){
        System.out.println(a + " + " + b + "i");
    }
}

public class question3 {
    public static void main(String[] args) {
        ComplexNumber c = new ComplexNumber(5,2);
        ComplexNumber copy = new ComplexNumber(c);
        c.display();
        copy.display();
    }
}
