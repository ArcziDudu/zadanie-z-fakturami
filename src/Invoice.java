import java.math.BigDecimal;

public class Invoice {
    private final String id;
    private final BigDecimal amount;

    public Invoice(String id, BigDecimal amount) {
        this.id = id;
        this.amount = amount;
    }

    @Override
    public String toString() {
        String sb = "Invoice{" + "id='" + id + '\'' +
                ", amount=" + amount +
                '}';
        return sb;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
