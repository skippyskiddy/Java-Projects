package photoalbum;

/**
 * The Shape class is an abstract base class for shapes with a name, x and y coordinates, and a
 * color (an enum).
 * Provides common methods for getting and setting these properties, as well as abstract methods
 * for calculating the area and perimeter of a shape, describing the shape, and getting the center
 * point of the shape. Designed to be extended by any new shape type adhering to the method
 * described below. Oval and Rectangle classes are provided as an example.
 */
public abstract class Shape {
  private String name;
  private double x;
  private double y;
  private Color color;

  /**
   * Creates a new instance of the Shape class with the specified name, coordinates, and color.
   * @param name The name of the shape.
   * @param x The x-coordinate of the shape.
   * @param y The y-coordinate of the shape.
   * @param color The color of the shape.
   */
  public Shape(String name, double x, double y, Color color) {
    this.name = name;
    this.x = x;
    this.y = y;
    this.color = color;
  }

  /**
   * Returns name of the shape.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the current X coordinate of the shape. In combination with the Y coordinate, makes
   * the shape's center.
   */
  public double getX() {
    return x;
  }


  /**
   * Returns the current Y coordinate of the shape. In combination with the X coordinate, makes
   * the shape's center.
   */
  public double getY() {
    return y;
  }


  /**
   * Returns the current color of the shape.
   */
  public Color getColor() {
    return color;
  }


  /**
   * Sets the name of the shape to a new name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Manually sets a new X coordinate for the shape without using the Move class.
   */
  public void setX(double x) {
    this.x = x;
  }

  /**
   * Manually sets a new Y coordinate for the shape without using the Move class.
   */
  public void setY(double y) {
    this.y = y;
  }


  /**
   * Manually sets a new Color for the shape without using the ChangeColor class.
   */
  public void setColor(Color color) {
    this.color = color;
  }


  // abstract methods left as abstract as implementation will be different for each shape type

  /**
   * Calculates and returns the area of the shape.
   * @return The area of the shape.
   */
  public abstract double getArea();

  /**
   * Calculates and returns the perimeter of the shape.
   * @return The perimeter of the shape.
   */
  public abstract double getPerimeter();

  /**
   * Returns a string describing the properties of the shape in a specified format.
   * @return A string describing the properties of the shape.
   */
  public abstract String describe();

  /**
   * Returns the center point of the shape, the x and y coordinate joined together using an
   * independent Point class.
   */
  public abstract Point getCenter();

}

