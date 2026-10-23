package parking.refactored;

/** What every payment method can do. */
public interface PaymentMethod {
    String name();
    void pay(double amount);
}
