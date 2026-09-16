import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class InvoiceTest {

  @Test
  void invoiceDueTodayIsNotOverdue() {
    Invoice invoice = new Invoice("Test 1", 100.0, LocalDate.now());
    assertFalse(invoice.isOverdue());
  }

  @Test
  void invoiceDueYesterdayIsOverdue() {
    Invoice invoice = new Invoice("Test 2", 300.0, LocalDate.now().minusDays(1));
    assertTrue(invoice.isOverdue());

  }

  @Test
  void invalidInvoice() {
    assertThrows(InvalidAmountException.class, () -> new Invoice("Test 3", 0, LocalDate.now()));
  }

  @Test
  void illegalArgument() {
    assertThrows(IllegalArgumentException.class, () -> new Invoice("Test 4", 90, null));
  }
}
