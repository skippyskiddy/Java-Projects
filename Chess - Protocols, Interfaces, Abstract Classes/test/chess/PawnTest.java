package chess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PawnTest {
  private Pawn normalWhitepawn;
  private Pawn normalBlackPawn;
  private Pawn exceptionWhitePawn;
  private Pawn exceptionBlackPawn;
  private Pawn whiteCanKillPawn;
  private Pawn blackCanKillPawn;
  private Bishop normalWhiteBishop;

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    normalWhitepawn  = new Pawn(1, 4, Color.WHITE);
    normalBlackPawn = new Pawn(6, 6, Color.BLACK);
    whiteCanKillPawn  = new Pawn(2, 5, Color.BLACK);
    blackCanKillPawn = new Pawn(5, 5, Color.WHITE);
    normalWhiteBishop = new Bishop(0, 2, Color.WHITE);
  }


  @Test
  void canMoveStraight() {
    Assertions.assertEquals(true, normalWhitepawn.canMove(2, 4));
  }

  @Test
  void whiteCanMoveTwo() {
    Assertions.assertEquals(true, normalWhitepawn.canMove(3, 4));
  }

  @Test
  void whiteShouldNotMoveColumn() {
    Assertions.assertEquals(false, normalWhitepawn.canMove(2, 5));
  }

  @Test
  void whiteShouldNotMoveBack() {
    Assertions.assertEquals(false, normalWhitepawn.canMove(1, 4));
  }

  @Test
  void blackCanMoveStraight() {
    Assertions.assertEquals(true, normalBlackPawn.canMove(5, 6));
  }

  @Test
  void blackCanMoveTwo() {
    Assertions.assertEquals(true, normalBlackPawn.canMove(4, 6));
  }

  @Test
  void blackShouldNotMoveColumn() {
    Assertions.assertEquals(false, normalBlackPawn.canMove(5, 5));
  }

  @Test
  void blackShouldNotMoveBack() {
    Assertions.assertEquals(false, normalBlackPawn.canMove(7, 6));
  }

  @Test
  void exceptionWhitePawn() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      exceptionWhitePawn = new Pawn(8, 0 , Color.WHITE);
    });
  }

  @Test
  void exceptionBlackPawnRoyalRow() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      exceptionBlackPawn = new Pawn(7, 0 , Color.BLACK);
    });
  }


  @Test
  void whiteCanKill() {
    Assertions.assertEquals(true, normalWhitepawn.canKill(whiteCanKillPawn));
  }

  @Test
  void whiteCannotKillDueToColor() {
    Assertions.assertEquals(false, normalWhitepawn.canKill(normalWhiteBishop));
  }

  @Test
  void blackCanKill() {
    Assertions.assertEquals(true, normalBlackPawn.canKill(blackCanKillPawn));
  }

  @Test
  void blackCannotKill() {
    Assertions.assertEquals(false, normalBlackPawn.canKill(normalWhitepawn));
  }

}