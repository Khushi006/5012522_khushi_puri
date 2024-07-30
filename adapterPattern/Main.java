public class Main {
    public static void main(String[] args) {
        // Creating instances of the payment gateways
        PayPal payPal = new PayPal();
        Stripe stripe = new Stripe();
        Square square = new Square();

        // Creating adapters for the payment gateways
        PaymentProcessor payPalAdapter = new PayPalAdapter(payPal);
        PaymentProcessor stripeAdapter = new StripeAdapter(stripe);
        PaymentProcessor squareAdapter = new SquareAdapter(square);

        // Processing payments using the adapters
        payPalAdapter.processPayment(100.0);
        stripeAdapter.processPayment(200.0);
        squareAdapter.processPayment(300.0);
    }
}

interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPal {
    public void makePayment(double amount) {
        System.out.println("Processing payment of rupee " + amount + " through PayPal.");
    }
}

class Stripe {
    public void sendPayment(double amount) {
        System.out.println("Processing payment of rupee " + amount + " through Stripe.");
    }
}

class Square {
    public void pay(double amount) {
        System.out.println("Processing payment of rupee " + amount + " through Square.");
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    @Override
    public void processPayment(double amount) {
        payPal.makePayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {
        stripe.sendPayment(amount);
    }
}

class SquareAdapter implements PaymentProcessor {
    private Square square;

    public SquareAdapter(Square square) {
        this.square = square;
    }

    @Override
    public void processPayment(double amount) {
        square.pay(amount);
    }
}
