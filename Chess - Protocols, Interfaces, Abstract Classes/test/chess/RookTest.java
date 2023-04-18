package chess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RookTest {
  private Rook normalBlackRook;
  private Rook normalWhiteRook;
  private King normalWhiteKing;

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    normalBlackRook = new Rook(7, 7, Color.BLACK);
    normalWhiteRook = new Rook(0, 7, Color.WHITE);
    normalWhiteKing = new King(0,3, Color.WHITE);
  }

  @Test
  void canMoveRight() {
    normalWhiteRook = new Rook(0, 0, Color.WHITE);
    Assertions.assertEquals(true, normalWhiteRook.canMove(0, 7));
  }

  @Test
  void cannotMoveSameSpot() {
    normalWhiteRook = new Rook(0, 7, Color.WHITE);
    Assertions.assertEquals(false, normalWhiteRook.canMove(0, 7));
  }

  @Test
  void canMoveLeft() {
    Assertions.assertEquals(true, normalWhiteRook.canMove(0, 0));

  }

  @Test
  void canMoveBack() {
    normalWhiteRook = new Rook(4, 4, Color.WHITE);
    Assertions.assertEquals(true, normalWhiteRook.canMove(0, 4));
  }

  @Test
  void canMoveStraight() {
    Assertions.assertEquals(true, normalBlackRook.canMove(5, 7));
  }

  @Test
  void canKillKingStraight() {
    Assertions.assertEquals(true, normalBlackRook.canKill(normalWhiteRook));
  }
}