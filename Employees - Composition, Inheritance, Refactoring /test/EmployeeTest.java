import static org.junit.jupiter.api.Assertions.assertEquals;

import employee.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class EmployeeTest {

  private Employee normalHourlyAbove40;
  private Employee normalHourlyBelow40;
  private Employee normalSalary;
  private Employee normalSalary2;
  private Employee brokenHourly;
  private Employee brokenSalary;


  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    normalHourlyAbove40 = new Employee("Bob Hourly", "Bob ID", 50, 500);
    normalHourlyBelow40 = new Employee("Bob Hourly", "Bob ID", 50, 30);
    normalSalary = new Employee("Bob Salary", "Bob ID1", 50000, 4, false);
    normalSalary2 = new Employee("Bob Salary", "Bob ID1", 50000, 2, true);
  }

  @org.junit.jupiter.api.Test
  void throwsExceptionHourly() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      brokenHourly = new Employee("Bob Hourly", "Bob ID", 50, -500);
    });
  }

  @org.junit.jupiter.api.Test
  void throwsExceptionNameEmpty() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      brokenHourly = new Employee("", "Bob ID", 50, 500);
    });
  }

  @org.junit.jupiter.api.Test
  void throwsExceptionPayInterval() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      brokenSalary = new Employee("Bob Salary", "Bob ID1", 50000, 9, false);
    });
  }

  @org.junit.jupiter.api.Test
  void isManager() {
    assertEquals(false, normalSalary.isManager());
    assertEquals(true, normalSalary2.isManager());
  }

  @org.junit.jupiter.api.Test
  void isManagerHourly() {
    assertEquals(false, normalHourlyAbove40.isManager());
  }

  @org.junit.jupiter.api.Test
  void getPaycheckHourlySingleFunctionTest() {
    assertEquals(36500, normalHourlyAbove40.getPaycheck().getTotalPay());
  }

  @org.junit.jupiter.api.Test
  void getPaycheckSalarySingleFunctionTest() {
    assertEquals(normalSalary.getPaycheck().getPayRate() / 13,
        normalSalary.getPaycheck().getTotalPay(), 0.1);
  }

  @org.junit.jupiter.api.Test
  void testToString() {
    assertEquals("Name: Bob Salary\n"
        + "ID: " + "Bob ID1\n"
        + "Payment after taxes: $ 3269.23", normalSalary.toString());
  }
}