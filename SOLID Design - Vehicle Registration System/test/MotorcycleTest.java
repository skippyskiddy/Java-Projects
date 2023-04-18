
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import registration.Motorcycle;

class MotorcycleTest {

  @Test
  public void testProblematicMotorcycleReturnsCorrect() {
    Motorcycle motorcycle = new Motorcycle("akjdf", 4940, 500000.52);
    //doesn't matter if it's a problematic range, can still be created, but won't register
    //in registration system

    assertEquals("akjdf", motorcycle.getMake());
    assertEquals(4940, motorcycle.getProductionYear());
    assertEquals(500000.52, motorcycle.getPurchasePrice(), 0.001);
    assertEquals(2, motorcycle.getMaxPassengers());
  }
}
