import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import photoalbum.Color;
import photoalbum.Oval;
import photoalbum.Rectangle;
import photoalbum.Shape;
import photoalbum.Snapshot;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

class SnapshotTest {

  @Test
  public void testSnapshotSingletonCreation() {
    Shape shape = new Oval("O", 10.0, 20.0, 30.0, 40.0, Color.RED);
    List<Shape> shapes = Arrays.asList(shape);
    Snapshot snapshot = new Snapshot("Test snapshot", shapes);

    assertNotNull(snapshot);
    assertTrue(snapshot.getTimestamp().isBefore(LocalDateTime.now())); //check if snapshot
    //is properly stored historically
    assertEquals("Test snapshot", snapshot.getDescription());
    assertEquals(1, snapshot.getShapes().size());
    assertSame(shape, snapshot.getShapes().get(0));
  }

  @Test
  public void testSnapshotEmptyShapes() {
    List<Shape> shapes = Arrays.asList();
    Snapshot snapshot = new Snapshot("Empty Shapes", shapes);

    assertNotNull(snapshot);
    assertTrue(snapshot.getTimestamp().isBefore(LocalDateTime.now()));
    assertEquals("Empty Shapes", snapshot.getDescription());
    assertEquals(0, snapshot.getShapes().size());
  }

  @Test
  public void testSnapshotMultipleShapeDescriptions() {
    Shape oval = new Oval("O", 10.0, 20.0, 30.0, 40.0, Color.RED);
    Shape rectangle = new Rectangle("R", 100.0, 200.0, 300.0, 400.0, Color.BLUE);
    List<Shape> shapes = Arrays.asList(oval, rectangle);
    Snapshot snapshot = new Snapshot("Test snapshot", shapes);

    String description = snapshot.getDescription();

    assertNotNull(description);
    assertTrue(description.contains("Name: O"));
    assertTrue(description.contains("Type: oval"));
    assertTrue(description.contains("Name: R"));
    assertTrue(description.contains("Type: rectangle"));
  }

  @Test
  public void testSnapshotDescriptionNoShapes() {
    List<Shape> shapes = Arrays.asList();
    Snapshot snapshot = new Snapshot("Test snapshot", shapes);

    String description = snapshot.getDescription();

    assertNotNull(description);
    assertFalse(description.contains("Shape Information:"));
  }

}
