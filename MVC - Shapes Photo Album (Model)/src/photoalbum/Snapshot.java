package photoalbum;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a snapshot of a collection of shapes at a specific point in time.
 * Contains a timestamp indicating when the snapshot was taken, a description of the snapshot,
 * and a list of shapes contained in the snapshot.
 */

public class Snapshot {

  private LocalDateTime timestamp;
  private String description;
  private List<Shape> shapes;

  /**
   * Creates a new instance of the Snapshot class with the specified description
   * and list of shapes.
   * The timestamp is automatically set to the current date and time using LocalDateTime.
   * @param description A string describing the snapshot.
   * @param shapes The list of shapes in the snapshot. Makes a defensive copy to make each
   *               snapshot unmodifiable.
   */
  public Snapshot(String description, List<Shape> shapes) {
    this.timestamp = LocalDateTime.now();
    this.description = description;
    this.shapes = new ArrayList<>(shapes);
  }

  /**
   * Returns a string describing the snapshot, including the snapshot ID, timestamp, description,
   * and the description of each shape in the snapshot. Format based on third party
   * specifications (assignment description).
   */
  public String getDescription() {
    StringBuilder sb = new StringBuilder();
    sb.append("Snapshot ID: ").append(getTimestamp().toString())
        .append("\nTimestamp: ").append(getTimestamp().format(DateTimeFormatter
            .ofPattern("dd-MM-yyyy HH:mm:ss")))
        .append("\nDescription: ").append(description)
        .append("\nShape Information:\n");

    for (Shape shape : getShapes()) { //append all descriptions
      sb.append(shape.describe());
    }

    return sb.toString();
  }

  /**
   * Returns the timestamp of the snapshot using the LocalDateTime class.
   * @return The timestamp of the snapshot
   */
  public LocalDateTime getTimestamp() {
    return timestamp;
  }


  /**
   * Returns the list of shapes in the snapshot.
   * @return The list of shapes in the snapshot.
   */
  public List<Shape> getShapes() {
    return shapes;
  }

}



