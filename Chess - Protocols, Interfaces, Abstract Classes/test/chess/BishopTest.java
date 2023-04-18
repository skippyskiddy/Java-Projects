package chess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BishopTest {
  private Bishop normalWhiteBishop;
  private Bishop normalBlackBishop;

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    normalWhiteBishop = new Bishop(0, 2, Color.WHITE);
    normalBlackBishop = new Bishop(7, 2, Color.BLACK);

  }

  @Test
  void canMoveLeft() {
    Assertions.assertEquals(true, normalWhiteBishop.canMove(2, 0));
  }

  @Test
  void canMoveRight() {
    Assertions.assertEquals(true, normalWhiteBishop.canMove(5, 7));
  }

  @Test
  void shouldNotMoveRight() {
    Assertions.assertEquals(false, normalWhiteBishop.canMove(4, 7));
  }

  @org.junit.jupiter.api.Test
  void getRow() {
    Assertions.assertEquals(0, normalWhiteBishop.getRow());

  }

  @org.junit.jupiter.api.Test
  void getColumn() {
    Assertions.assertEquals(2, normalWhiteBishop.getColumn());
  }

  @org.junit.jupiter.api.Test
  void isEnemy() {
    Assertions.assertEquals(true, normalWhiteBishop.isEnemy(normalBlackBishop));
  }

  @org.junit.jupiter.api.Test
  void canKill() { //4 row 5 col
    normalWhiteBishop = new Bishop(4, 5, Color.WHITE);
    Assertions.assertEquals(true, normalWhiteBishop.canKill(normalBlackBishop));
  }

  @org.junit.jupiter.api.Test
  void getColor() {
    Assertions.assertEquals(Color.WHITE, normalWhiteBishop.getColor());
  }
}