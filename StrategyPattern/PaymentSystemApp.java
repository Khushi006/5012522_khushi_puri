public class PaymentSystemApp {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Using Credit Card payment strategy
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456", "123", "12/24"));
        context.pay(100.0);

        System.out.println();

        // Using PayPal payment strategy
        context.setPaymentStrategy(new PayPalPayment("user@example.com", "password"));
        context.pay(200.0);
    }
}

// Step 2: Define Strategy Interface
interface PaymentStrategy {
    void pay(double amount);
}

// Step 3: Implement Concrete Strategies
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cvv;
    private String expiryDate;

    public CreditCardPayment(String cardNumber, String cvv, String expiryDate) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying Rupee " + amount + " using Credit Card.");
        // Implementation of credit card payment processing
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying Rupee " + amount + " using PayPal.");
        // Implementation of PayPal payment processing
    }
}

// Step 4: Implement Context Class
class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount) {
        if (paymentStrategy != null) {
            paymentStrategy.pay(amount);
        } else {
            System.out.println("No payment strategy set.");
        }
    }
}
