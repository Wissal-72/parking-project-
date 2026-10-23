package parking.refactored;

// A vehicle carries its tariff
public record Vehicle(String plate, String type, Tariff tariff) { }
