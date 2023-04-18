package chess;


/**
 * Name: Elif Tirkes
 * CS5004 Spring 2023
 * This class creates a Knight object on a chess board.
 */
public class Knight extends ChessPieceImpl {

  /**
   * This constructor creates a Knight object. A knight can only move in an L shape, and kill any
   * opponent’s piece if it can move to its place.
   */
  public Knight(int initialRow, int initialColumn, Color color) throws IllegalArgumentException {
    super(initialRow, initialColumn, color);
  }

  /**
   * This method overrides the canMove function for the knight. If the knight can move two spots
   * horizontally and vertically and one spot horizontally or vertically, then it moves in an L
   * shape every return.
   * @param row to move to.
   * @param col to move to.
   * @return boolean on whether the move is possible.
   */
  @Override
  public boolean canMove(int row, int col) {
    if (!super.canMove(row, col)) {
      return false;
    } else if (this.getRow() == row || this.getColumn() == col) {
      //check if the new cords are the same.
      return false;
    } else {
      return ((Math.abs(this.getRow() - row) == 2) && (Math.abs(this.getColumn() - col) == 1))
          || (Math.abs(this.getColumn() - col) == 2) && (Math.abs(this.getRow() - row) == 1);
    }
  }
}
