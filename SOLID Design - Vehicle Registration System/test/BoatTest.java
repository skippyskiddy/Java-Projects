
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import registration.Boat;

class BoatTest {

  @Test
  public void testBoatReturnsCorrect() {
    Boat boat = new Boat("Fish", 1999, 5);

    assertEquals("Fish", boat.getMake());
    assertEquals(1999, boat.getProductionYear());
    assertEquals(5, boat.getPurchasePrice(), 0.001);
    assertEquals(10, boat.getMaxPassengers());
  }
}
