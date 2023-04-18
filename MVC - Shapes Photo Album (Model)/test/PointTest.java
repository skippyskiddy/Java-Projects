
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import photoalbum.Point;

class PointTest {
  private Point point;

  @BeforeEach
  void setUp() {
    point = new Point(10, 20);
  }

  @Test
  void testGetX() {
    assertEquals(10, point.getX());
  }

  @Test
  void testGetY() {
    assertEquals(20, point.getY());
  }

  @Test
  void testCreatePoint() {
    Point newPoint = new Point(-5.5, 30.7);
    assertEquals(-5.5, newPoint.getX());
    assertEquals(30.7, newPoint.getY());
  }
}
