package employee;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * This class creates an employee with overloaded constructors based on the number of parameters
 * that the employee has. The number of paramaters determines if the employee is salaried or
 * hourly.
 */
public class Employee {

  private String name;
  private String id;
  private double payRate;
  private int payInterval;
  private final boolean isManager;
  private double hoursWorked;
  private IPaycheck paycheck;
  private static final DecimalFormat df1 = new DecimalFormat( "0.00" );


  /**
   * The constructor below creates a salaried worker employee. It takes 5 parameters:
   * name, id, pay rate, pay interval, and a boolean flag to indicate if the employee is
   * manager or not. The pay rate for salaried employees is their yearly salary.
   * The pay interval determines how frequently the employee is paid: weekly (1 time per week),
   * bi-weekly (1 time every two weeks) or quad-weekly (1 time every four weeks).
   * We are using the integer values 1, 2, and 4 to represent those three pay intervals.
   * If an invalid pay interval is provided, the constructor throws an IllegalArgumentException.
   * Throw an IllegalArgumentException if either
   * the name or ID are null OR if they are empty strings
   * (length = 0) when creating employees.
   * It is also illegal for Pay rate and hours worked to be negative.
   */
  public Employee(String name, String id, double payRate, int payInterval, boolean isManager )
      throws IllegalArgumentException {

    if ( name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Name cannot be empty or NULL");
    } else {
      this.name = name;
    }

    if ( id == null || id.isEmpty()) {
      throw new IllegalArgumentException("ID cannot be empty or NULL");
    } else {
      this.id = id;
    }

    if (payInterval == 1 || payInterval == 2 || payInterval == 4) {
      this.payInterval = payInterval;
    } else {
      throw new IllegalArgumentException("Pay interval can be represented in integers 1, 2, or 4.");
    }

    if ( payRate < 0 ) {
      throw new IllegalArgumentException("Pay rate cannot be less than 0");
    } else {
      this.payRate = payRate;
    }

    this.isManager = isManager;

    this.paycheck = new SalariedPaycheck(this.payRate, this.payInterval);

  }

  /**
   * This constructor creates an hourly paid employee. In this case, the pay rate represents
   * the hourly rate, and hours worked represents the number of hours the employee
   * has worked. Hourly employees are paid at their rate * hours if the number of hours worked is
   * 40 or less. If the hours worked exceeds 40, the employee is paid at an overtime rate
   * of 1.5x for all of the hours in excess of 40.
   * Throw an IllegalArgumentException if either
   * the name or ID are null OR if they are empty strings
   * (length = 0) when creating employees.
   * It is also illegal for Pay rate and hours worked to be negative.
   */
  public Employee(String name, String id, double payRate, double hoursWorked)
      throws IllegalArgumentException {

    if ( name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Name cannot be empty or NULL");
    } else {
      this.name = name;
    }

    if ( id == null || id.isEmpty()) {
      throw new IllegalArgumentException("ID cannot be empty or NULL");
    } else {
      this.id = id;
    }

    if ( payRate < 0 ) {
      throw new IllegalArgumentException("Pay rate cannot be less than 0");
    } else {
      this.payRate = payRate; // deal with excess in the Paycheck function
    }

    if (hoursWorked < 0 ) {
      throw new IllegalArgumentException("Hours worked cannot be less than 0");
    } else {
      this.hoursWorked = hoursWorked;
    }

    this.isManager = false; // hourly workers cannot be managers

    this.paycheck = new HourlyPaycheck(this.payRate, this.hoursWorked);

  }

  /**
   * This method below is required for employees to answer if they are a manager or not.
   * True if they are a manager, false if they are just an employee.
   */
  public boolean isManager() {
    return this.isManager;
  }

  /**
   * Returns a paycheck instance simulating getting paid for the pay period.
   */
  public IPaycheck getPaycheck() {
    return this.paycheck;
  }

  /**
   * Employee return a String representing Employee returns a String,
   * allowing Employee objects to be represented by the employee name, ID,
   * and current week's payment after taxes are assessed.
   * if an employee earned more than 0 but less than 1 cent, we will pay them the 1 cent.
   * Name: Clark Kent
   * ID: SUPS-111
   * Payment after taxes: $ 416.50
   */
  @Override
  public String toString() {
    return ("Name: " + this.name + "\n" + "ID: " + this.id + "\n"
        + "Payment after taxes: $ " + df1.format(this.paycheck.getPayAfterTaxes()));
  }

}
