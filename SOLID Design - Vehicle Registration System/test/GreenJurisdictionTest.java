import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import registration.Automobile;
import registration.GreenJurisdiction;
import registration.IJurisdiction;
import registration.IVehicle;


class GreenJurisdictionTest {

  @Test
  public void testExciseTax() {
    IVehicle vehicle = new Automobile("Toyota", 2015, 10000);
    IJurisdiction greenJurisdiction = new GreenJurisdiction();

    int maxPassengers = vehicle.getMaxPassengers();
    double expectedTax = 10000 * 0.04 + maxPassengers * 100;
    // Expected tax: 4% of purchase price + 100 per pass
    assertEquals(expectedTax, greenJurisdiction.exciseTax(vehicle), 0.01);
  }

  @Test
  public void testToString() {
    IJurisdiction greenJurisdiction = new GreenJurisdiction();
    assertEquals("Green", greenJurisdiction.toString());
  }
}
