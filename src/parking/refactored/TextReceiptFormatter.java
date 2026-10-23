package parking.refactored;

import java.util.List;

public class TextReceiptFormatter implements ReceiptFormatter {

    public String line(Receipt r) {
        return r.plate() + " | " + r.type() + " | " + r.hours() + " h | " + r.amount()
                + " MAD | " + r.method();
    }


    public String report(List<Receipt> receipts, double total) {
        StringBuilder sb = new StringBuilder("=== Daily report ===\n");
        for (Receipt r : receipts) sb.append(line(r)).append("\n");
        sb.append("Total: ").append(total).append(" MAD");
        return sb.toString();
    }
}
