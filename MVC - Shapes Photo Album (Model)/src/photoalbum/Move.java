package photoalbum;

/**
 * Implements the ITransformation interface to move a Shape object by a specified amount in the x
 * and y directions.
 * Provides a constructor to specify the amount to move in each direction.
 */
public class Move implements ITransformation {
  private double newX;
  private double newY;

  /**
   * Creates a new instance of the Move class with the specified amount to move in each direction.
   * @param newX The amount to move in the x direction.
   * @param newY The amount to move in the y direction.
   */
  public Move(double newX, double newY) {
    this.newX = newX;
    this.newY = newY;
  }

  /**
   * Applies the move transformation to the Shape instance
   * by adjusting its x and y coordinates by the
   * amount specified in the constructor.
   * @param shape The Shape object to transform.
   */
  @Override
  public void apply(Shape shape) {
    shape.setX(shape.getX() + newX);
    shape.setY(shape.getY() + newY);
  }
}