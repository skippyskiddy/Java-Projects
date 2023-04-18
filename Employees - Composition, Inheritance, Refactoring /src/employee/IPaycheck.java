package employee;

/**
 * The following interface creates a paycheck type to get total pay, pay after taxes, and pay rate.
 */
public interface IPaycheck {

  /**
   * Returns the total pay for the employee in that pay period. This
   * method does NOT round the value of the payment to USD format. It returns the raw value for
   * calculations without rounding.
   */
  double getTotalPay();

  /**
   * Returns the amount paid the employee after a flat tax
   * is deducted based on this scale:
   * > If the employee total payment is less than $400, deduct 10% of the total payment to obtain
   * "payment after taxes"
   * > If the employee total payment is $400 or more, deduct 15% of the total payment to obtain
   * "payment after taxes"
   * Note: This method should NOT round the value of the payment to USD format.
   */
  double getPayAfterTaxes();

  /**
   * Returns the pay rate of the employee. It is a salaried worker's yearly salary,
   * and hourly rate for the hourly employee.
   */
  double getPayRate();

}
