import static org.junit.jupiter.api.Assertions.assertEquals;

import employee.SalariedPaycheck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SalariedPaycheckTest {

  private SalariedPaycheck normalSalary;
  private SalariedPaycheck lowSalary2;
  private SalariedPaycheck brokenSalary;
  private SalariedPaycheck payRateOne;



  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    normalSalary = new SalariedPaycheck(30000, 2);
    lowSalary2 = new SalariedPaycheck(400, 4);
    payRateOne = new SalariedPaycheck(.003, 4);


  }

  @Test
  void throwsExceptionPayRateNegative() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      brokenSalary = new SalariedPaycheck(200, 10);
    });
  }

  @Test
  void getTotalPayLow() {
    assertEquals(lowSalary2.getPayRate() / 13, lowSalary2.getTotalPay());
  }

  @Test
  void getPayRateLessThanOne() {
    assertEquals(0.01, payRateOne.getPayAfterTaxes());
  }

  @Test
  void getPayAfterTaxes() {
    assertEquals(27.69, lowSalary2.getPayAfterTaxes(), 0.1);

  }

  @Test
  void getPayRate() {
    assertEquals(30000, normalSalary.getPayRate());
  }

  @Test
  void testToString() {
    assertEquals( "Payment after taxes: $ 980.77", normalSalary.toString());
  }
}