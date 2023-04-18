package employee;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * This class creates an hourly paycheck instance for an hourly employee, calculating any surplus
 * hours and increasing the pay rate as needed.
 */
public class HourlyPaycheck implements IPaycheck {

  private double payRate;
  private double hoursWorked;
  private double hoursAdded;
  private static final DecimalFormat df1 = new DecimalFormat("0.00");


  /**
   * This constructor creates an hourly paycheck instance, and throws an exception if pay rate and /
   * or hours worked is negative.
   */
  public HourlyPaycheck(double payRate, double hoursWorked) throws IllegalArgumentException {

    if (payRate < 0 || hoursWorked < 0) {
      throw new IllegalArgumentException("Pay rate or hours worked cannot be less than 0");
    } else {
      this.payRate = payRate;
      this.hoursWorked = hoursWorked;
    }
  }

  @Override
  public double getTotalPay() {
    double basePay;
    basePay = this.payRate * 40.0;

    if (this.hoursWorked > 40.0) {
      return ((this.hoursWorked - 40.0) * (this.payRate * 1.5)) + basePay;
    } else {
      return this.payRate * this.hoursWorked;
    }
  }

  @Override
  public double getPayAfterTaxes() {
    double paymentAfterTaxes;
    if (this.getTotalPay() < 400.0) {
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
   * This method adds a new amount of hours to the amount already worked to the week. Adding
   * negative hours is permitted as long as total hours does not fall below 0.
   */
  public void addHoursWorked(double hoursAdded) {
    if (this.hoursWorked + hoursAdded > 0) {
      this.hoursWorked = this.hoursWorked + hoursAdded;
    } else {
      this.hoursWorked = 0;
    }
  }

  /**
   * Resets the paycheck to zero hours for the employee.
   */
  public void resetHoursWorked() {
    this.hoursWorked = 0;
  }


  /**
   * Returns the number of hours an Hourly employee worked for the current paycheck.
   */
  public double getHoursWorked() {
    return this.hoursWorked;
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
