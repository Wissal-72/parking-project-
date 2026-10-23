package parking.refactored;


public class Tariff {
    private final double baseFee;
    private final double ratePerHour; //Fixed base fee plus an hourly rate.

    public Tariff(double baseFee, double ratePerHour) {
        this.baseFee = baseFee;
        this.ratePerHour = ratePerHour;
    }

    public double fee(int hours) { return baseFee + hours * ratePerHour; }
}
