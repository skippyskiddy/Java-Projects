
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import photoalbum.Color;
import photoalbum.Oval;
import photoalbum.Rectangle;
import photoalbum.Scale;
import photoalbum.Shape;

class ScaleTest {
  private Oval oval;
  private Rectangle rectangle;

  @BeforeEach
  void setUp() {
    oval = new Oval("O", 100, 100, 50, 25, Color.RED);
    rectangle = new Rectangle("R", 200, 200, 50, 100, Color.BLUE);
  }

  @Test
  void testScale() {
    Shape shape = new Oval("O", 10.0, 20.0, 30.0, 40.0, Color.RED);
    Scale scale = new Scale(2.0); //double the scale

    scale.apply(shape);

    assertEquals(60.0, ((Oval) shape).getXRadius());
    assertEquals(80.0, ((Oval) shape).getYRadius());
  }

  @Test
  void testScaleNegativeNoError() {
    Scale scale = new Scale(-100.0);
    assertDoesNotThrow(() -> {
      scale.apply(oval); } );
    assertDoesNotThrow(() -> {
      scale.apply(rectangle); } );
  }

  @Test
  void testScaleLarge() {
    Scale scale = new Scale(10.0);
    scale.apply(oval);
    scale.apply(rectangle);

    assertEquals(500.0, oval.getXRadius());
    assertEquals(250.0, oval.getYRadius());
    assertEquals(500.0, rectangle.getWidth());
    assertEquals(1000.0, rectangle.getHeight());
  }

  @Test
  void testScaleNull() {
    Scale scale = new Scale(1.0);
    scale.apply(oval);
    scale.apply(rectangle);

    assertEquals(50.0, oval.getXRadius());
    assertEquals(25.0, oval.getYRadius());
    assertEquals(50.0, rectangle.getWidth());
    assertEquals(100.0, rectangle.getHeight());
  }

  @Test
  void testScaleInvalidSize() { //should be 0 as scale multiplies by 0.
    Scale scale = new Scale(0.0);
    assertDoesNotThrow(() -> {
      scale.apply(oval); } );
    assertDoesNotThrow(() -> {
      scale.apply(rectangle); } );
    assertEquals(0, oval.getXRadius());
    assertEquals(0, oval.getYRadius());
  }
}
