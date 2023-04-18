
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import photoalbum.Color;
import photoalbum.Move;
import photoalbum.Oval;
import photoalbum.Rectangle;
import photoalbum.Shape;


class MoveTest {

  private Move move;
  private Oval oval;
  private Rectangle rectangle;

  @BeforeEach
  public void setUp() {
    oval = new Oval("O", 50.0, 50.0, 30.0, 20.0, Color.RED);
    rectangle = new Rectangle("R", 100.0, 100.0, 60.0, 40.0, Color.BLUE);
  }

  @Test
  public void testMove() {
    Shape shape = new Oval("O", 10.0, 20.0, 30.0, 40.0, Color.RED);
    Move move = new Move(5.0, -10.0);

    move.apply(shape);

    assertEquals(15.0, shape.getCenter().getX());
    assertEquals(10.0, shape.getCenter().getY());
  }


  @Test
  public void testMoveShapePositive() {
    move = new Move(10.0, 20.0);
    move.apply(oval);
    move.apply(rectangle);

    assertEquals(60.0, oval.getX());
    assertEquals(70.0, oval.getY());
    assertEquals(110.0, rectangle.getX());
    assertEquals(120.0, rectangle.getY());
  }

  @Test
  public void testMoveShapeNegative() {
    move = new Move(-20.0, -30.0);
    move.apply(oval);
    move.apply(rectangle);

    assertEquals(30.0, oval.getX());
    assertEquals(20.0, oval.getY());
    assertEquals(80.0, rectangle.getX());
    assertEquals(70.0, rectangle.getY());
  }

  @Test
  public void testMoveShapeZero() {
    move = new Move(0, 0);
    move.apply(oval);
    move.apply(rectangle);

    assertEquals(50.0, oval.getX());
    assertEquals(50.0, oval.getY());
    assertEquals(100.0, rectangle.getX());
    assertEquals(100.0, rectangle.getY());
  }

  @Test
  public void testMoveShapeLargeNumber() {
    move = new Move(1000000.0, 1000000.0);
    move.apply(oval);
    move.apply(rectangle);

    assertEquals(1000050.0, oval.getX());
    assertEquals(1000050.0, oval.getY());
    assertEquals(1000100.0, rectangle.getX());
    assertEquals(1000100.0, rectangle.getY());
  }

  @Test
  public void testMoveShapeSmallNumber() {
    move = new Move(0.001, 0.001);
    move.apply(oval);
    move.apply(rectangle);

    assertEquals(50.001, oval.getX(), 1e-6);
    assertEquals(50.001, oval.getY(), 1e-6);
    assertEquals(100.001, rectangle.getX(), 1e-6);
    assertEquals(100.001, rectangle.getY(), 1e-6);
  }
}