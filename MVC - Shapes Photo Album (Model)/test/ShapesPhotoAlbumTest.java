import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import photoalbum.Color;
import photoalbum.ITransformation;
import photoalbum.Oval;
import photoalbum.Rectangle;
import photoalbum.Scale;
import photoalbum.ShapesPhotoAlbum;
import photoalbum.Snapshot;


class ShapesPhotoAlbumTest {

  private ShapesPhotoAlbum album;

  @BeforeEach
  void setUp() {
    album = ShapesPhotoAlbum.getInstance();
  }

  @Test
  void testAddShape() {
    ShapesPhotoAlbum.reset(); //resetting for all because its a singleton
    Oval oval = new Oval("O Red", 10.0, 20.0, 30.0, 40.0, Color.RED);
    album.addShape(oval);
    assertTrue(album.getShapes().contains(oval));
  }

  @Test
  void testRemoveShape() {
    ShapesPhotoAlbum.reset();
    Oval oval = new Oval("O", 10.0, 20.0, 30.0, 40.0, Color.RED);
    album.addShape(oval);
    album.removeShape(oval);
    assertFalse(album.getShapes().contains(oval));
  }

  @Test
  void testAddSnapshot() {
    ShapesPhotoAlbum.reset();
    Rectangle rect = new Rectangle("R", 10.0, 20.0, 30.0, 40.0, Color.BLUE);
    album.addShape(rect);
    album.addSnapshot("Initial state");
    Snapshot snapshot = album.getSnapshots().get(0);

    assertNotNull(snapshot);
    assertEquals(1, snapshot.getShapes().size());
    assertEquals(rect, snapshot.getShapes().get(0));
  }

  @Test
  void testApplyTransformation() {
    ShapesPhotoAlbum.reset();
    Oval oval = new Oval("O", 10.0, 20.0, 30.0, 40.0, Color.RED);
    album.addShape(oval);
    ITransformation scale = new Scale(2.0);
    album.applyTransformation(scale);

    Oval transformedOval = (Oval) album.getShapes().get(0);
    assertEquals(60.0, transformedOval.getXRadius());
    assertEquals(80.0, transformedOval.getYRadius());
  }

  @Test
  void testGetAlbumDescription() {
    ShapesPhotoAlbum.reset();
    ShapesPhotoAlbum album = ShapesPhotoAlbum.getInstance();
    Oval oval = new Oval("O", 10.0, 20.0, 30.0, 40.0, Color.RED);
    album.addShape(oval);
    album.addSnapshot("Initial state");
    String albumDescription = album.getAlbumDescription();

    assertNotNull(albumDescription);
    assertTrue(albumDescription.contains("Snapshot ID:"));
    assertTrue(albumDescription.contains("Timestamp:"));
    assertTrue(albumDescription.contains("Description: Initial state"));
    assertTrue(albumDescription.contains("Shape Information:"));
    assertTrue(albumDescription.contains("Name: O"));
    assertTrue(albumDescription.contains("Type: Oval"));
  }

  @Test
  void testAddShapeNullException() {
    ShapesPhotoAlbum.reset();
    ShapesPhotoAlbum album = ShapesPhotoAlbum.getInstance();
    assertThrows(IllegalArgumentException.class, () -> album.addShape(null));
  }

  @Test
  void testRemoveShapeNullException() {
    ShapesPhotoAlbum.reset();
    ShapesPhotoAlbum album = ShapesPhotoAlbum.getInstance();
    assertThrows(IllegalArgumentException.class, () -> album.removeShape(null));
  }

  @Test
  void testRemoveShapeDoesNotExist() {
    ShapesPhotoAlbum.reset();
    ShapesPhotoAlbum album = ShapesPhotoAlbum.getInstance();
    Oval oval = new Oval("O", 10.0, 20.0, 30.0, 40.0, Color.RED);
    assertThrows(IllegalArgumentException.class, () -> album.removeShape(oval));
  }
}
