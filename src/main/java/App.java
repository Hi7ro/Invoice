import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        LocalDate today = LocalDate.now();
        LocalDate oneDayAgo = today.minusDays(1);
        LocalDate threeDaysAgo = today.minusDays(3);

        List<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice("John Dow", 550.10, LocalDate.of(2026, 12, 31)));
        invoices.add(new Invoice("Michael Mayer", 10.17, LocalDate.of(2025, 5, 29)));
        invoices.add(new Invoice("Jane Fox", 18550.00, LocalDate.of(2026, 9, 10)));
        invoices.add(new Invoice("Mellissa Schober", 2540.55, LocalDate.of(2025, 2, 2)));
        invoices.add(new Invoice("Franziska Von der Weide", 900.27, LocalDate.of(2026, 9, 11)));
        invoices.add(new Invoice("Mitschi", 500, LocalDate.of(2027, 3, 15)));
        invoices.add(new Invoice("Felix", 3000, oneDayAgo));
        invoices.add(new Invoice("Jenny", 355.70, today));
        invoices.add(new Invoice("Karlos", 300, oneDayAgo));
        Invoice michael = invoices.get(1);
        Invoice karlos = invoices.get(8);
        Invoice mellissa = invoices.get(3);
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

        mellissa.markAsPaid();
        karlos.markAsPaid();

        System.out.println(overdueInvoices.toString());
        System.out.println("___________________________");
        System.out.println(invoices.toString());

    }

}
