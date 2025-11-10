/*
 * 6. Implement a class Polynomial that models a polynomial equation. Use a constructor that takes a variable number of coefficients (using varargs) and initializes the polynomial. Write a method to display the polynomial in a readable format (e.g., 3x^2 + 2x + 1).
 */

class Polynomial{
    String polyString;
    Polynomial(int... coefficient){
        int n = coefficient.length;
        StringBuilder sb = new StringBuilder();
        int degree = n-1;
        for (int i = 0; i < n; i++) {
            if (coefficient[i]==0) {
                degree--;
            } else { 
                if (degree == 0) {
                    sb.append(coefficient[i]);
                }
                else          
                    sb.append(coefficient[i] + "x^" + degree-- + " + ");
            }
        }
        polyString = sb.toString();
    }

    void display(){
        System.out.println(polyString);
    }
}

public class question6 {
    public static void main(String[] args) {
        Polynomial p = new Polynomial(0,5,9,8);
        p.display();
    }
}