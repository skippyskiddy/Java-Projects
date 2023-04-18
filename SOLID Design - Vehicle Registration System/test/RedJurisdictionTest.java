import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import registration.Automobile;
import registration.IJurisdiction;
import registration.IVehicle;
import registration.RedJurisdiction;

class RedJurisdictionTest {

  @Test
  public void testExciseTax() {
    IVehicle vehicle = new Automobile("Toyota", 2015, 10000);
    IJurisdiction redJurisdiction = new RedJurisdiction();

    double expectedTax = 10000 * 0.05; // Expected tax: 5% of purchase price
    //writing it in a variable just to see if it differs in result
    assertEquals(expectedTax, redJurisdiction.exciseTax(vehicle), 0.01);
  }

  @Test
  public void testToString() {
    IJurisdiction redJurisdiction = new RedJurisdiction();
    assertEquals("Red", redJurisdiction.toString());
  }
}
