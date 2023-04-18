package chess;

/**
 * This class creates a King object on a chess board.
 */
public class King extends ChessPieceImpl {


  /**
   * This constructor creates a King object. Similar to a queen,
   * a king can move horizontally, vertically and diagonally.
   * However, kings are limited in that they can only move one
   * space at a time, in any of those directions. It can kill
   * any opponent’s piece if it can move to its place.
   */
  public King(int initialRow, int initialColumn, Color color) throws IllegalArgumentException {
    super(initialRow, initialColumn, color);
  }

  /**
   * This method overrides the canMove function to allow the King to move diagonally and
   * horizontally, but only one cell at a time.
   */
  @Override
  public boolean canMove(int row, int col) {
    if (!super.canMove(row, col)) {
      return false;
    } else {
      return ((Math.abs(row - this.getRow()) == 1 && Math.abs(col - this.getColumn()) == 1)
          || (Math.abs(row - this.getRow()) == 0 && Math.abs(col - this.getColumn()) == 1)
          || (Math.abs(row - this.getRow()) == 1 && Math.abs(col - this.getColumn()) == 0));
    }
  }
}
