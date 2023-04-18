
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import photoalbum.Color;
import photoalbum.Point;
import photoalbum.Rectangle;


class RectangleTest {
  private Rectangle rectangle;

  @BeforeEach
  void setUp() {
    rectangle = new Rectangle("R", 10, 20, 30, 40, Color.BLUE);
  }

  @Test
  void testGetWidth() {
    assertEquals(30, rectangle.getWidth());
  }

  @Test
  void testGetHeight() {
    assertEquals(40, rectangle.getHeight());
  }

  @Test
  void testGetArea() {
    assertEquals(1200, rectangle.getArea());
  }

  @Test
  void testGetPerimeter() {
    assertEquals(140, rectangle.getPerimeter());
  }

  @Test
  void testRectangleDescribe() {
    String description = rectangle.describe();
    assertEquals("Name: R\nType: rectangle\nMin corner: "
        + "(10.0,20.0), Width: 30.0, Height: 40.0, Color: BLUE\n", description);
  }

  @Test
  void testGetCenter() {
    Point center = rectangle.getCenter();
    assertEquals(10, center.getX());
    assertEquals(20, center.getY());
  }

  // Edge cases
  @Test
  void testZeroSizeRectangle() {
    Rectangle zeroSizeRectangle = new Rectangle("Zero", 0, 0, 0, 0, Color.RED);
    assertEquals(0, zeroSizeRectangle.getArea());
    assertEquals(0, zeroSizeRectangle.getPerimeter());
  }

  @Test
  void testNegativeSizeRectangle() {
    Rectangle negativeSizeRectangle = new Rectangle("Negative", -10, -20,
        -30, -40, Color.GREEN);
    assertEquals(-30, negativeSizeRectangle.getWidth());
    assertEquals(-40, negativeSizeRectangle.getHeight());
    assertEquals(1200, negativeSizeRectangle.getArea());
    assertEquals(140, negativeSizeRectangle.getPerimeter());
  }
}

