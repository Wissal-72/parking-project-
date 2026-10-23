package parking;

import java.io.IOException;

public class TestQst4 {
    public static void main(String[] args) throws IOException {
        ParkingGarage garage = new ParkingGarage();

        Vehicle truck = new Vehicle("00000-D-0", "TRUCK");

        PaymentMethod card = new CardPayment("0000");

        garage.checkout(truck, 4, card);

        System.out.println(garage.dailyReport());
    }
}
