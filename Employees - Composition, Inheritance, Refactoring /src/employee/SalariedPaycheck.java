package employee;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * This class creates a salaried paycheck for a salaried employee.
 */
public class SalariedPaycheck implements IPaycheck {
  private double payRate;
  private int payInterval;
  private static final DecimalFormat df1 = new DecimalFormat( "0.00" );


  /**
   * This constructor creates a salaried paycheck instance for a salaried employee. Throws
   * illegal argument exception if the pay interval is not 1, 2, or 4 and if the pay rate is
   * negative.
   */
  public SalariedPaycheck(double payRate, int payInterval) throws IllegalArgumentException {

    if (payRate < 0) {
      throw new IllegalArgumentException("Pay rate cannot be less than 0");
    } else {
      this.payRate = payRate;
    }

    if (payInterval != 1 && payInterval != 2 && payInterval != 4) {
      throw new IllegalArgumentException("Pay Interval must be integers 1, 2, or 4");
    } else {
      this.payInterval = payInterval;
    }

  }

  @Override
  public double getTotalPay() {
    return this.payRate / (52.0 / this.payInterval);
  }

  @Override
  public double getPayAfterTaxes() {
    double paymentAfterTaxes;
    if (this.getTotalPay() < 400) {
      paymentAfterTaxes = this.getTotalPay() - (this.getTotalPay() * 0.1);
    } else {
      paymentAfterTaxes = this.getTotalPay() - (this.getTotalPay() * 0.15);
    }

    if (paymentAfterTaxes < 0.01 && paymentAfterTaxes > 0) {
      paymentAfterTaxes = 0.01;
    }
    return paymentAfterTaxes;
  }

  @Override
  public double getPayRate() {
    return this.payRate;
  }

  /**
   * Paychecks return a String representing the current payment AFTER taxes are assessed.
   * The string representation should be in the form of US dollars with text as illustrated below:
   * Payment after taxes: $ ###.##
   */
  @Override
  public String toString() {
    return ("Payment after taxes: $ " +  df1.format(this.getPayAfterTaxes()));

  }

}
