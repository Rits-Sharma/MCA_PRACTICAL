/*
 * 9. Create an interface PaymentMethod with a method void pay(double amount). 
 Implement this interface in two classes: CreditCardPayment and PayPalPayment. 
 Write a class OnlineStore that accepts a PaymentMethod in its constructor and uses it to process a payment.
 */

interface PaymentMethod{
    void pay(double amount);

}

class CreditCardPayment implements PaymentMethod{
    public void pay(double amount){
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentMethod{
    public void pay(double amount){
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

class OnlineStore{
    public PaymentMethod pMethod;
    public OnlineStore(PaymentMethod pMethod){
        this.pMethod = pMethod;
    }
    void buy(double amount){
        System.out.println("Requesting payment");
        pMethod.pay(amount);

    }
}

public class question9 {
    public static void main(String[] args) {
        PaymentMethod pMethod = new PayPalPayment();
        PaymentMethod pMethod1 = new CreditCardPayment();
        OnlineStore oStore = new OnlineStore(pMethod);
        OnlineStore oStore1 = new OnlineStore(pMethod1);
        oStore.buy(1500);
        oStore1.buy(11500);
    }
}
