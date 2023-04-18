package chess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class KnightTest {

  private Knight normalBlackKnight;
  private Knight normalWhiteKnight;


  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    normalBlackKnight = new Knight(7, 1, Color.BLACK);
    normalWhiteKnight = new Knight(0, 6, Color.WHITE);
  }

  @Test
  void canMoveRight() {
    Assertions.assertEquals(true, normalBlackKnight.canMove(5, 2));
  }

  @Test
  void canMoveRightLong() {
    Assertions.assertEquals(true, normalBlackKnight.canMove(6, 3));
  }

  @Test
  void shouldNotMove() {
    Assertions.assertEquals(false, normalBlackKnight.canMove(4, 1));
  }

  @Test
  void canMoveLeft() {
    Assertions.assertEquals(true, normalWhiteKnight.canMove(2, 5));
  }

  @Test
  void canMoveLeftLong() {
    Assertions.assertEquals(true, normalWhiteKnight.canMove(1, 4));
  }

}