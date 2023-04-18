package chess;

/**
 * Name: Elif Tirkes
 * CS5004 Spring 2023
 * This class creates a Bishop object on a chess board.
 */
public class Bishop extends ChessPieceImpl {

  /**
   * This constructor creates a Bishop object. A bishop can only move diagonally, and kill any
   * opponent’s piece if it can move to its place.
   */
  public Bishop(int initialRow, int initialColumn, Color color) throws IllegalArgumentException {
    super(initialRow, initialColumn, color);
  }

  /**
   * This method overrides the canMove method and prevents the bishop from moving anywhere except
   * diagonally by making sure that the difference between the horizontal and vertical distance
   * in the board is proportional.
   *
   * @param row new row to move to
   * @param col new row to move to
   * @return boolean indicating whether it can move or not.
   */
  @Override
  public boolean canMove(int row, int col) {
    if (!super.canMove(row, col)) {
      return false;
    } else if (this.getRow() == row || this.getColumn() == col) {
      //check if the new cords are the same.
      return false;
    } else
      return Math.abs(row - this.getRow()) == Math.abs(col - this.getColumn());
  }

}

