package chess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QueenTest {
  private Queen normalWhiteQueen;
  private Queen normalBlackQueen;

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    normalWhiteQueen = new Queen(0, 3 , Color.WHITE);
    normalBlackQueen = new Queen(7, 3 , Color.BLACK);
  }

  @Test
  void canMoveDiagonallyRight() {
    Assertions.assertEquals(true, normalWhiteQueen.canMove(4, 7));
  }

  @Test
  void canMoveDiagonallyLeft() {
    Assertions.assertEquals(true, normalWhiteQueen.canMove(3, 0));
  }

  @Test
  void canMoveDiagonallyLeftBlack() {
    Assertions.assertEquals(true, normalBlackQueen.canMove(3, 7));
  }

  @Test
  void canMoveStraightForward() {
    Assertions.assertEquals(true, normalBlackQueen.canMove(0, 3));
  }

  @Test
  void canMoveStraightBlack() {
    normalWhiteQueen = new Queen(4, 4 , Color.WHITE);
    Assertions.assertEquals(true, normalWhiteQueen.canMove(0, 4));
  }

  @Test
  void cannotMoveLikeKnight() {
    normalWhiteQueen = new Queen(0, 3 , Color.WHITE);
    Assertions.assertEquals(false, normalWhiteQueen.canMove(3, 2));
  }

  @Test
  void canKillOpponentQueen() {
    Assertions.assertEquals(true, normalWhiteQueen.canKill(normalBlackQueen));
  }

  @Test
  void cannotKillOpponentQueen() {
    normalBlackQueen = new Queen(3, 5 , Color.BLACK);
    Assertions.assertEquals(false, normalWhiteQueen.canKill(normalBlackQueen));
  }
}