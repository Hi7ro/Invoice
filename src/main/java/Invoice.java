import java.time.LocalDate;

public class Invoice {
  private String customerName;
  private double amount;
  private LocalDate dueDate = LocalDate.now();
  private boolean paid = false;

  public Invoice(String customerName, double amount, LocalDate dueDate) {
    if (amount <= 0) {
      throw new InvalidAmountException("Amount can't be under 0, was: " + amount);
    }
    if (dueDate == null) {
      throw new IllegalArgumentException("Date must not be Null!");
    }
    this.customerName = customerName;
    this.amount = amount;
    this.dueDate = dueDate;

  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    if (amount <= 0) {
      throw new InvalidAmountException("Amount can't set under 0, was: " + amount);
    }
    this.amount = amount;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  public void setDueDate(LocalDate dueDate) {
    if (dueDate == null) {
      throw new IllegalArgumentException("Date must not be Null!");
    }
    this.dueDate = dueDate;
  }

  public boolean isPaid() {
    return this.paid;
  }

  public boolean isOverdue() {
    return dueDate.isBefore(LocalDate.now()) && paid == false;
  }

  public void markAsPaid() {
    this.paid = true;
  }

  public double applyDiscount(double percentage) {
    if (percentage <= 0 || percentage >= 100) {
      throw new InvalidAmountException("No Discount under or above 0 and 100, was: " + percentage);
    }
    double result = amount * percentage / 100;
    amount -= result;
    return amount;
  }

  @Override
  public String toString() {
    return getCustomerName()
        + ": "
        + getAmount()
        + ", due Date: "
        + getDueDate()
        + ", is paid: "
        + isPaid()
        + ", is overdue?: "
        + isOverdue() + "\n";
  }
}
