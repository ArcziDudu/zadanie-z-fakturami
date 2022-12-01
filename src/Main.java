
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InvoiceStack invoiceStack = new InvoiceStack();

        Scanner scanner =  new Scanner(System.in);

        while (scanner.hasNext()){
            String command = scanner.nextLine();
            invoiceStack.processInput(command);
        }
    }
}