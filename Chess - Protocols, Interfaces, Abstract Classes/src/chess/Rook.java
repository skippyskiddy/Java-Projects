package chess;

/**
 * Name: Elif Tirkes
 * CS5004 Spring 2023
 * This class creates a Rook object on a chess board.
 */
public class Rook extends ChessPieceImpl {

  /**
   * This constructor creates a Rook object. A Rook can move horizontally or vertically, and kill
   * any opponent’s piece if it can move to its place.
   */
  public Rook(int initialRow, int initialColumn, Color color) throws IllegalArgumentException {
    super(initialRow, initialColumn, color);
  }

  /**
   * This method overrides the canMove method to ensure the Rook can only move horizontally or
   * vertically, meaning that either the column or the row has to remain the same.
   */
  @Override
  public boolean canMove(int row, int col) {
    if (!super.canMove(row, col)) {
      return false;
    } else {
      return (this.getRow() == row || this.getColumn() == col);
    }

  }
}
