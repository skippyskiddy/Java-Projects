import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import registration.Automobile;
import registration.BlueJurisdiction;
import registration.IVehicle;


class BlueJurisdictionTest {

  @Test
  public void testExciseTax() {
    BlueJurisdiction blueJurisdiction = new BlueJurisdiction();
    IVehicle vehicle1 = new Automobile("Ford", 2020, 20000);
    IVehicle vehicle2 = new Automobile("Chevrolet", 1995, 15000);

    double tax1 = blueJurisdiction.exciseTax(vehicle1);
    double tax2 = blueJurisdiction.exciseTax(vehicle2);

    assertEquals(600, tax1, 0.01); // 20000 * 0.03 = 600
    assertEquals(549, tax2, 0.01); // 15000 * 0.03 + 99 = 549
  }

  @Test
  public void testToString() {
    BlueJurisdiction blueJurisdiction = new BlueJurisdiction();
    String blueString = blueJurisdiction.toString();

    assertEquals("Blue", blueString);
  }
}
