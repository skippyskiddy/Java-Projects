package photoalbum;
/**
 * Represents a rectangle shape with a specified width and height.
 * This class extends the Shape class.
 */
public class Rectangle extends Shape {
  private double width;
  private double height;

  /**
   * Creates a new instance of the Rectangle class with the specified name,
   * coordinates, width, height and color.
   * @param name The name of the rectangle shape.
   * @param x The x-coordinate of the bottom-left corner of the rectangle shape.
   * @param y The y-coordinate of the bottom-left corner of the rectangle shape.
   * @param width The width of the rectangle shape.
   * @param height The height of the rectangle shape.
   * @param color The color of the rectangle shape (an enum).
   * */
  public Rectangle(String name, double x, double y,  double width, double height, Color color) {
    super(name, x, y, color);
    this.width = width;
    this.height = height;
  }

  // todo: Getter and setter method

  public double getWidth() {
    return this.width;
  }

  public double getHeight() {
    return this.height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public void setWidth( double width) {
    this.width = width;
  }

  @Override
  public double getArea() {
    return width * height;
  }

  @Override
  public double getPerimeter() {
    return Math.abs(2 * (width + height)); //perimeter cannot be negative
  }

  @Override
  public String describe() {
    return "Name: " + getName() + "\nType: rectangle" + "\nMin corner: (" + getX() + ","
        + getY() + "), Width: " + getWidth() + ", Height: " + getHeight() + ", Color: "
        + getColor().toString() + "\n";
  }

  public Point getCenter() {
    return new Point(getX() , getY());
  }



}