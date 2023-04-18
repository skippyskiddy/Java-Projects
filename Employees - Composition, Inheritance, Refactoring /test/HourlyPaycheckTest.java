import static org.junit.jupiter.api.Assertions.assertEquals;

import employee.HourlyPaycheck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class HourlyPaycheckTest {

  private HourlyPaycheck normalHourlyAbove40;
  private HourlyPaycheck normalHourlyBelow40;
  private HourlyPaycheck totalLessThan400;
  private HourlyPaycheck brokenHourly;

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    normalHourlyAbove40 = new HourlyPaycheck(400, 500);
    normalHourlyBelow40 = new HourlyPaycheck(50, 30);
    totalLessThan400 = new HourlyPaycheck(10, 10);
  }


  @org.junit.jupiter.api.Test
  void throwsExceptionPayRateNegative() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      brokenHourly = new HourlyPaycheck(-4, 10);
    });
  }

  @org.junit.jupiter.api.Test
  void getTotalPayAbove40() {
    assertEquals(292000, normalHourlyAbove40.getTotalPay());
  }

  @org.junit.jupiter.api.Test
  void getTotalPayBelow40() {
    assertEquals( 1500, normalHourlyBelow40.getTotalPay());
  }

  @org.junit.jupiter.api.Test
  void getPayAfterTaxes() {
    assertEquals( 248200, normalHourlyAbove40.getPayAfterTaxes());
  }

  @org.junit.jupiter.api.Test
  void getPayAfterTaxesBelow400() {
    assertEquals( 90, totalLessThan400.getPayAfterTaxes());
  }

  @org.junit.jupiter.api.Test
  void getPayRate() {
    assertEquals( 50, normalHourlyBelow40.getPayRate());
  }

  @org.junit.jupiter.api.Test
  void addHoursWorked() {
    assertEquals( 30, normalHourlyBelow40.getHoursWorked());
    normalHourlyBelow40.addHoursWorked(50);
    assertEquals( 80, normalHourlyBelow40.getHoursWorked());
  }

  @org.junit.jupiter.api.Test
  void addHoursWorkedImpactRateCalculation() {
    assertEquals( 30, normalHourlyBelow40.getHoursWorked());
    assertEquals( normalHourlyBelow40.getPayRate() * normalHourlyBelow40.getHoursWorked(),
        normalHourlyBelow40.getTotalPay());

    normalHourlyBelow40.addHoursWorked(50);
    assertEquals( 80, normalHourlyBelow40.getHoursWorked());
    assertEquals( ((normalHourlyBelow40.getHoursWorked() - 40.0)
        * (normalHourlyBelow40.getPayRate() * 1.5)) + normalHourlyBelow40.getPayRate()
        * 40.0, normalHourlyBelow40.getTotalPay());
  }

  @org.junit.jupiter.api.Test
  void resetHoursWorked() {
    assertEquals( 30, normalHourlyBelow40.getHoursWorked());
    normalHourlyBelow40.resetHoursWorked();
    assertEquals( 0, normalHourlyBelow40.getHoursWorked());
  }

  @org.junit.jupiter.api.Test
  void getHoursWorked() {
    assertEquals( 30, normalHourlyBelow40.getHoursWorked());
    assertEquals( 10, totalLessThan400.getHoursWorked());
  }

  @org.junit.jupiter.api.Test
  void testToString() {
    assertEquals( "Payment after taxes: $ 248200.00", normalHourlyAbove40.toString());

  }

}