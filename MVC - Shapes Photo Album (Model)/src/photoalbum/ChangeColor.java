package photoalbum;

/**
 * Implements the ITransformation interface to change the color of a Shape object.
 * This class provides a constructor to specify the new color
 * and methods to get and set the new color. Uses Color enums to change color.
 */

public class ChangeColor implements ITransformation {
  private Color newColor;

  /**
   * Creates a new instance of the change color class with the specified new color enum.
   * @param newColor new color to set.
   */
  public ChangeColor(Color newColor) {

    this.newColor = newColor;
  }

  /**
   * Applies the color transformation to the specified Shape
   * object by setting its old color to the new color enum.
   * @param shape The Shape object to transform.
   */
  @Override
  public void apply(Shape shape) {
    shape.setColor(newColor);
  }

  /**
   * Sets new color to specified color.
   */
  public void setNewColor(Color newColor) {
    this.newColor = newColor;
  }

  /**
   * Returns the pending color that will replace the current color of the shape object.
   */
  public Color getNewColor() {
    return newColor;
  }

}
