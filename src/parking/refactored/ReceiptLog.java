package parking.refactored;

/** Log abstraction owned by the business logic. No checked exception: how it stores is not our concern. */
public interface ReceiptLog {
    void log(String line);
}
