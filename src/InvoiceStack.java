import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.Deque;

public class InvoiceStack {
    private static Integer counter = 1;
    private static Deque<Invoice> invoiceStack = new ArrayDeque<>();

    public void processInput(String command) {
        if (command.contains("CEO")) {
            processCEOInput(command);
        } else if ("ACCOUNTANT: PROCESS INVOICE".equals(command)) {
            processAccountantInput(command);
        } else {
            System.out.println("O co ci chodzi?");
        }
    }

    private void processCEOInput(String command) {
        BigDecimal stringAmount = new BigDecimal(command.substring(command.indexOf("(") + 1, command.indexOf(")")));
        Integer year = LocalDate.now().getYear();
        String id = counter + "/" + year;
        counter++;

        Invoice invoice = new Invoice(id, stringAmount);
        invoiceStack.push(invoice);

        System.out.printf("%n%s%n", command);
        System.out.printf("CEO added invoice: ID: %s, amount: %s %n",id, stringAmount);
        System.out.printf("Current invoices amount: %s. Invoices: %s%n",getInvoicesSum(), invoiceStack);
    }

    private void processAccountantInput(String command) {
        if (invoiceStack.isEmpty()) return;
        Invoice invoice = invoiceStack.pop();
        System.out.printf("%n%s%n", command);
        System.out.printf("ACCOUNTANT processed invoice: %s%n",invoice);
        System.out.printf("Current invoices amount: %s. Invoices: %s%n",getInvoicesSum(), invoiceStack);
    }

    private String getInvoicesSum() {
        BigDecimal sum = BigDecimal.ZERO;
        for (Invoice invoice : invoiceStack) {
            sum = sum.add(invoice.getAmount());
        }
        return sum.toString();
    }
}
