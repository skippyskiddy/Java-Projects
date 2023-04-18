import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import registration.Automobile;


class AutomobileTest {

  @Test
  public void testAutomobileReturnsCorrect() {
    Automobile automobile = new Automobile("Toyota", 2010, 20000.0);

    assertEquals("Toyota", automobile.getMake());
    assertEquals(2010, automobile.getProductionYear());
    assertEquals(20000.0, automobile.getPurchasePrice(), 0.001);
    assertEquals(5, automobile.getMaxPassengers());
  }
}
