package photoalbum;

/**
 * Represents a point in two-dimensional space with x and y coordinates.
 * Used to store the coordinates of the shape objects' center, which is made up of the shape's
 * X and Y coordinate.
 */
public class Point {
  private double x;
  private double y;

  /**
   * Initializes a coordinate, intended to be used with the X and Y of each shape instance.
   */
  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }
}
