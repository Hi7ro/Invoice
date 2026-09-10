import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice("John Dow", 550.10, LocalDate.of(2026, 12, 31)));
        invoices.add(new Invoice("Michael Mayer", 10.17, LocalDate.of(2025, 5, 29)));
        invoices.add(new Invoice("Jane Fox", 18550.00, LocalDate.of(2026, 9, 10)));
        invoices.add(new Invoice("Mellissa Schober", 2540.55, LocalDate.of(2025, 2, 2)));
        invoices.add(new Invoice("Franziska Von der Weide", 900.27, LocalDate.of(2026, 9, 11)));
        invoices.add(new Invoice("Mitschi", 500, LocalDate.of(2027, 3, 15)));
        Invoice michael = invoices.get(1);
        // try {
        // invoices.getLast().setDueDate(null);
        // } catch (IllegalArgumentException e) {
        // System.out.println(": Error handled!");
        // }

        // System.out.println(invoices.toString());
        // System.out.println(michael.toString());
        michael.markAsPaid();
        // invoices.getLast().setDueDate(null);

        // System.out.println(michael.toString());
        List<Invoice> overdueInvoices = invoices.stream()
                .filter(i -> i.isOverdue())
                .toList();

        invoices.get(3).markAsPaid();
        System.out.println(overdueInvoices.toString());

    }

}
