package photoalbum;

/**
 * Defines a contract for applying transformations to Shape objects.
 * Classes that implement this interface must provide an implementation for the apply method, which
 * takes a Shape object as a parameter and performs a transformation on it. Can be used to extend
 * to more types of shapes beyond the given two (Oval and Rectangle).
 */
public interface ITransformation {

  /**
   * Applies a transformation to the specified Shape object, like changing color, moving, or
   * scaling the shape.
   * @param shape The Shape object to transform.
   */
  void apply(Shape shape);
}