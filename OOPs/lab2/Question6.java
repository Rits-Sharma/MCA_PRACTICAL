// 6. Create a class Product with static variables to store VAT and discount rates applicable to all products. Implement a static method to calculate the final price of a product based on its base price and the static rates.

class Product {

    static int VAT;          // in percent
    static float discount;   // in percent

    int basePrice;

    // Static block to initialize default values (optional)
    static {
        VAT = 10;        // default VAT 10%
        discount = 5;    // default discount 5%
    }

    // Constructor sets only base price
    public Product(int basePrice) {
        this.basePrice = basePrice;
    }

    // Static method to calculate final price
    static float calculate(int basePrice) {
        return basePrice + (basePrice * VAT / 100f) - (basePrice * discount / 100f);
    }

    void display() {
        System.out.println("Final Price: " + calculate(basePrice));
    }
}

public class Question6 {
    public static void main(String[] args) {
        Product p = new Product(100);
        p.display();
    }
}
