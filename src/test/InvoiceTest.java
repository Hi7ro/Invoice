package test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class InvoiceTest {

  @Test
  void invoiceDueTodayIsNotOverdue() {
    Invoice invoice = new Invoice("Test Customer", 100.0, LocalDate.now());

    assertFalse(invoice.isOverdue());
  }
}
