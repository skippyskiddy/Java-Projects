package chess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class KingTest {

  private King normalBlackKing;
  private King exceptionWhiteKing;
  private King normalWhiteKing;

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    normalBlackKing = new King(7, 3, Color.BLACK);
    normalWhiteKing = new King(0,3, Color.WHITE);
  }

  @Test
  void canMoveLeft() {
    Assertions.assertEquals(true, normalBlackKing.canMove(6, 2));
  }

  @Test
  void shouldNotMove() {
    Assertions.assertEquals(false, normalBlackKing.canMove(5, 2));
  }

  @Test
  void canMoveRight() {
    Assertions.assertEquals(true, normalWhiteKing.canMove(1, 4));
  }


  @Test
  void badWhiteKing() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      exceptionWhiteKing = new King( -1 ,3, Color.WHITE);
    });
  }
}