package chess;


/**
 * Name: Elif Tirkes
 * CS5004 Spring 2023
 * This class creates a Pawn object on a chess board.
 */
public class Pawn extends ChessPieceImpl {


  /**
   * This constructor creates a Pawn instance. A black pawn cannot be created in row 7, and white
   * pawns cannot be created in row 0. A pawn can only move ahead, not backwards. Its first move
   * OPTIONALLY can be two places, but only one move ahead afterwards. A pawn cannot kill by moving
   * straight, it can onl kill by moving diagonally.
   *
   * @throws IllegalArgumentException if it is also in a royal row.
   */
  public Pawn(int initialRow, int initialColumn, Color color) throws IllegalArgumentException {
    super(initialRow, initialColumn, color);
    if (this.getColor() == Color.BLACK && initialRow == 7
        || this.getColor() == Color.WHITE && initialRow == 0) {
      throw new IllegalArgumentException("Pawn cannot be in a royal row.");
    }
  }

  /**
   * This method overrides the canKill function to indicate whether the pawn can kill the
   * diagonal enemy piece or not.
   * @param piece from the enemy team
   * @return boolean indicating whether the pawn can kill
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    if (!super.isEnemy(piece)) {
      return false;
    } else if ((this.getColor() == Color.BLACK && (Math.abs(piece.getColumn()
        - this.getColumn()) == 1)) && (piece.getRow() - this.getRow() == -1)) {
      return true;
    } else if ((this.getColor() == Color.WHITE && (Math.abs(piece.getColumn()
        - this.getColumn()) == 1)) && (piece.getRow() - this.getRow() == 1)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * This method overrides the canMove method for the pawn.  A pawn can only move ahead, not
   * backwards. Its first move OPTIONALLY can be two places, but only one move ahead afterwards.
   *
   * @param row desired row to move to
   * @param col desired column to move to
   * @return boolean on whether the Pawn can move or not
   */
  @Override
  public boolean canMove(int row, int col) {
    if (!super.canMove(row, col)) {
      return false;
    }

    if (this.getColumn() != col) {
      return false;
    }

    if (this.getColor() == Color.WHITE && this.getRow() == 1
        && (row - this.getRow() == 2 || row - this.getRow() == 1)) {
      return true;
    } else if (this.getColor() == Color.BLACK && this.getRow() == 6
        && (row - this.getRow() == -2 || row - this.getRow() == -1)) {
      return true;
    } else if (this.getColor() == Color.BLACK && (row - this.getRow() == -1)) {
      return true;
    } else if (this.getColor() == Color.WHITE && (row - this.getRow() == 1)) {
      return true;
    } else {
      return false;
    }
  }
}


