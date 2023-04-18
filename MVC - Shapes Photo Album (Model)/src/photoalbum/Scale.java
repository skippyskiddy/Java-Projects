package photoalbum;

/**
 * Implements the ITransformation interface to scale a Shape object by a specified amount in the
 * scale factor, a double.
 * Provides a constructor to specify the amount to scale the shape by.
 */
public class Scale implements ITransformation {
  private double scaleFactor;

  /**
   * Creates a new instance of the Scale class with the specified scale factor.
   * @param scaleFactor The amount to scale the shape by.
   */
  public Scale(double scaleFactor) {
    this.scaleFactor = scaleFactor;
  }

  @Override
  public void apply(Shape shape) {
    if (shape instanceof Rectangle) {
      Rectangle rectangle = (Rectangle) shape;
      rectangle.setWidth(rectangle.getWidth() * scaleFactor);
      rectangle.setHeight(rectangle.getHeight() * scaleFactor);
    } else if (shape instanceof Oval) {
      Oval oval = (Oval) shape;
      oval.setXRadius(oval.getXRadius() * scaleFactor);
      oval.setYRadius(oval.getYRadius() * scaleFactor);
    }
  }
}
