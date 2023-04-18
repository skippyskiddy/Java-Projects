
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import photoalbum.Color;
import photoalbum.Oval;

class OvalTest {

  @Test
  public void testOvalConstructorAttributes() {
    Oval oval = new Oval("O", 10.0, 20.0, 30.0, 40.0, Color.RED);

    assertEquals("O", oval.getName());
    assertEquals(10.0, oval.getCenter().getX());
    assertEquals(20.0, oval.getCenter().getY());
    assertEquals(30.0, oval.getXRadius());
    assertEquals(40.0, oval.getYRadius());
    assertEquals(Color.RED, oval.getColor());
  }

  @Test
  public void testOvalDescribe() {
    Oval oval = new Oval("O", 10.0, 20.0, 30.0, 40.0, Color.RED);
    String description = oval.describe();

    assertTrue(description.contains("Name: O"));
    assertTrue(description.contains("Type: Oval"));
    assertTrue(description.contains("Center: (10.0,20.0)"));
    assertTrue(description.contains("X radius: 30.0"));
    assertTrue(description.contains("Y radius: 40.0"));
    assertTrue(description.contains("Color: RED"));
  }

  @Test
  public void testOvalSetColor() {
    Oval oval = new Oval("O", 10.0, 20.0, 30.0, 40.0, Color.RED);
    oval.setColor(Color.GREEN);

    assertEquals(Color.GREEN, oval.getColor());
  }

  @Test
  public void testOvalSetXRadius() {
    Oval oval = new Oval("O", 10.0, 20.0, 30.0, 40.0, Color.RED);
    oval.setXRadius(50.0);

    assertEquals(50.0, oval.getXRadius());
  }

  @Test
  public void testOvalSetYRadius() {
    Oval oval = new Oval("O", 10.0, 20.0, 30.0, 40.0, Color.RED);
    oval.setYRadius(60.0);

    assertEquals(60.0, oval.getYRadius());
  }
}

