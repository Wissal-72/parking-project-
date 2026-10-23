package parking.refactored;

import java.util.ArrayList;
import java.util.List;


public class ParkingService {
    private final ReceiptLog log;
    private final ReceiptFormatter formatter;
    private final List<Receipt> receipts = new ArrayList<>();
    private double total;

    public ParkingService(ReceiptLog log, ReceiptFormatter formatter) {
        this.log = log;
        this.formatter = formatter;
    }

    public double fee(Vehicle vehicle, int hours) {
        return vehicle.tariff().fee(hours);
    }

    public void checkout(Vehicle vehicle, int hours, PaymentMethod method) {
        double amount = fee(vehicle, hours);
        method.pay(amount);
        total += amount;

        Receipt receipt = new Receipt(vehicle.plate(), vehicle.type(), hours, amount, method.name());
        receipts.add(receipt);
        log.log(formatter.line(receipt));
    }

    public void cancel(Vehicle vehicle, int hours, RefundablePaymentMethod method) {
        double amount = fee(vehicle, hours);
        method.refund(amount);
        total -= amount;
    }

    public void cancelCashAtDesk(Vehicle vehicle, int hours) {
        double amount = fee(vehicle, hours);
        total -= amount;
    }

    public String dailyReport() {
        return formatter.report(receipts, total);
    }
}
