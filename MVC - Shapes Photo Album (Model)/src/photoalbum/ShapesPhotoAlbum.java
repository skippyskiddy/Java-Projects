package photoalbum;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides functionality for managing and manipulating a collection of shapes.
 * It supports creating snapshots of the current state of the shape collection,
 * adding and removing shapes, applying transformations to the shapes, and retrieving the current
 * state of the album. Is a singleton, and has the option to reset when necessary.
 */
public class ShapesPhotoAlbum {

  private static ShapesPhotoAlbum instance;
  private List<Snapshot> snapshots;
  private List<Shape> shapes;

  /**
   * Creates a new instance of the ShapesPhotoAlbum class with empty
   * lists for snapshots and shapes.
   */
  private ShapesPhotoAlbum() {
    this.snapshots = new ArrayList<>();
    this.shapes = new ArrayList<>(); // Add this line to initialize the shapes list
  }

  /**
   * Returns a singleton instance of the ShapesPhotoAlbum class.
   * @return The singleton instance of the ShapesPhotoAlbum class.
   */
  public static ShapesPhotoAlbum getInstance() {
    //singleton design pattern from hw7
    if (instance == null) {
      instance = new ShapesPhotoAlbum();
    }
    return instance;
  }

  /**
   * Creates a new snapshot of the current state of the shape
   * collection with the specified description (similar to a git commit message!).
   * @param description A string describing the snapshot.
   */
  public void addSnapshot(String description) {
    Snapshot newSnapshot = new Snapshot(description, new ArrayList<>(shapes));
    snapshots.add(newSnapshot);
  }

  /**
   * Adds the specified shape to the shape collection.
   * @param shape The shape to add to the collection.
   */
  public void addShape(Shape shape) {
    shapes.add(shape);
  }

  /**
   * Removes the specified shape from the shape collection.
   * @param shape The shape to add to remove from the collection.
   */
  public void removeShape(Shape shape) {
    shapes.remove(shape);
  }

  /**
   * Applies the specified transformation to all shapes in the collection.
   * Can be one of many transformation on one of many shapes not implemented, but can be
   * implemented in the future using the ITransformation interface and Shape abstract class.
   * @param transformation The transformation to apply to the shapes.
   */
  public void applyTransformation(ITransformation transformation) {
    for (Shape shape : shapes) {
      transformation.apply(shape);
    }
  }

  /**
   * Returns the list of snapshots in the album.
   * @return The list of snapshots currently in the album.
   */
  public List<Snapshot> getSnapshots() {
    return snapshots;
  }


  /**
   * Returns the list of shapes in the album.
   * @return The list of shapes currently in the album.
   */
  public List<Shape> getShapes() {
    return shapes;
  }

  /**
   * Returns a string describing the album by concatenating the description of each snapshot
   * using string builder (which does it more efficiently when there are a large number of
   * strings/snapshots with descriptions).
   * @return A string describing the album.
   */
  public String getAlbumDescription() {
    StringBuilder description = new StringBuilder();
    for (Snapshot snapshot : snapshots) {
      description.append(snapshot.getDescription());
      description.append("\n");
    }
    return description.toString();
  }

  /**
   * Resets and clears the photo album singleton instance.
   */
  public static void reset() {
    instance = null;
  }


}

