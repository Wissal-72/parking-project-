package parking.refactored;

/** Only methods that can really be refunded promise refund(). */
public interface RefundablePaymentMethod extends PaymentMethod {
    void refund(double amount);
}
