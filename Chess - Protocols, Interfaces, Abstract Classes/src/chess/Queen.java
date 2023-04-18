package chess;


/**
 * Name: Elif Tirkes
 * CS5004 Spring 2023
 * This class creates a Queen object on a chess board.
 */
public class Queen extends ChessPieceImpl {

  /**
   * This constructor creates a Queen object. A queen can move horizontally,
   * vertically and diagonally.
   * It can kill any opponent’s piece if it can move to its place., and kill any
   * opponent’s piece if it can move to its place.
   */
  public Queen(int initialRow, int initialColumn, Color color) throws IllegalArgumentException {
    super(initialRow, initialColumn, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    if (!super.canMove(row, col)) {
      return false;
    } else if ((Math.abs(row - this.getRow()) == Math.abs(col - this.getColumn()))
        || (this.getRow() == row || this.getColumn() == col)) {
      return true;
    }
    return false;
  }
}
