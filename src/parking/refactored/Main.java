package parking.refactored;

/** Composition root: the only existing file to open when a requirement changes. */
public class Main {
    public static void main(String[] args) {
        ParkingService service = new ParkingService(
                new FileReceiptLog("parking.log"),
                new TextReceiptFormatter());


        Vehicle car   = new Vehicle("12345-A-6", "CAR", new Tariff(5,5));
        Vehicle bike  = new Vehicle("67890-B-1", "MOTORBIKE", new Tariff(2,5));
        Vehicle truck = new Vehicle("24680-D-8", "TRUCK", new Tariff(20, 10));

        PaymentMethod cash = new CashPayment();
        PaymentMethod card = new CardPayment("4242");
        RefundablePaymentMethod refundableCard = new CardPayment("4242");

        service.checkout(car, 3, card);
        service.checkout(bike, 2, cash);
        service.checkout(truck, 4, card);

        service.cancelCashAtDesk(bike, 2);
        // service.cancel(bike, 2, cash);   // does not compile: CashPayment is not refundable
        service.cancel(truck, 4, refundableCard);

        System.out.println(service.dailyReport());
    }
}
