import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class InvoiceTest {

  @Test
  void invalidAmountTest() {
    assertThrows(InvalidAmountException.class, () -> new Invoice("Test1", 0,
        LocalDate.now().minusDays(4)));
  }

  @Test
  void illegalArgumentTest() {
    assertThrows(IllegalArgumentException.class, () -> new Invoice("Test2", 100,
        null));
  }

  @Test
  void isOverdueToday() {
    Invoice invoice = new Invoice("today", 300, LocalDate.now());
    assertFalse(invoice.isOverdue());
  }

  @Test
  void isOverdueYestrday() {
    Invoice invoice = new Invoice("isOverdueYesterday", 120, LocalDate.now().minusDays(1));
    assertTrue(invoice.isOverdue());
  }

  @Test
  void isOverdueYesterdayAndPaid() {
    Invoice invoice = new Invoice("overDuePaid", 9000, LocalDate.now().minusDays(1));
    assertTrue(invoice.isOverdue());
    invoice.markAsPaid();
    assertFalse(invoice.isOverdue());
  }

  @Test
  void invalidAmountTest2() {
    Invoice invoice = new Invoice("Test3", 100, LocalDate.now());
    assertThrows(InvalidAmountException.class, () -> invoice.setAmount(-20));
    assertEquals(100, invoice.getAmount());
  }

  @Test
  void testPrecentage() {
    Invoice invoice = new Invoice("Test4", 120, LocalDate.now());
    assertThrows(InvalidAmountException.class, () -> new Invoice("Test", 4059, LocalDate.now()).applyDiscount(-10));
    assertEquals(96, invoice.applyDiscount(20));
  }

}
