
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import photoalbum.ChangeColor;
import photoalbum.Color;
import photoalbum.Oval;
import photoalbum.Shape;

class ChangeColorTest {

  @Test
  public void testChangeColor() {
    Shape shape = new Oval("Oval Red", 10.0, 20.0, 30.0, 40.0, Color.RED);
    ChangeColor changeColor = new ChangeColor(Color.GREEN);

    changeColor.apply(shape);

    assertEquals(Color.GREEN, shape.getColor());
  }
}