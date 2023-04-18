package photoalbum;

/**
 * Represents an oval shape with a specified x and y radius.
 * This class extends the Shape class.
 */

public class Oval extends Shape {
  private double xRadius;
  private double yRadius;

  /**
   * Creates a new instance of the Oval class with the specified name,
   * coordinates, radius values and color.
   * @param name The name of the oval shape.
   * @param x The x-coordinate of the center of the oval shape.
   * @param y The y-coordinate of the center of the oval shape.
   * @param xRadius The radius value in the x-direction of the oval shape.
   * @param yRadius The radius value in the y-direction of the oval shape.
   * @param color The color of the oval shape (an enum).
   */
  public Oval(String name, double x, double y, double xRadius, double yRadius, Color color) {
    super(name, x, y, color);
    this.xRadius = xRadius;
    this.yRadius = yRadius;
  }

  public double getXRadius() {

    return this.xRadius;
  }

  public double getYRadius() {
    return this.yRadius;
  }

  public Point getCenter() {
    return new Point(getX(), getY());
  }

  public void setXRadius(double newXRadius) {
    this.xRadius = newXRadius;
  }

  public void setYRadius(double newYRadius) {
    this.yRadius = newYRadius;
  }

  @Override
  public double getArea() {
    return Math.PI * xRadius * yRadius;
  }

  @Override
  public double getPerimeter() {
    return 2 * Math.PI * Math.sqrt((xRadius * xRadius + yRadius * yRadius) / 2);
  }

  @Override
  public String describe() {
    return "Name: " + getName() + "\nType: Oval" + "\nCenter: (" + getX() + "," + getY() + "), "
        + "X radius: " + getXRadius() + ", Y radius: " + getYRadius() + ", Color: "
        + getColor().toString() + "\n";
  }


}
