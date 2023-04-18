package chess;

/**
 * Name: Elif Tirkes
 * CS5004 Spring 2023
 * This class implements the ChessPiece interface and standardizes shared
 * functions between
 * different chess pieces, including color setting, killing enemy pieces, and checking if the
 * piece can move in the board to a certain position, and returning column, row, and color.
 */
public abstract class ChessPieceImpl implements ChessPiece {

  protected int currentRow;
  protected int currentColumn;
  protected Color currentColor;

  /**
   * This method creates a chess piece that takes in an initial position and initial color,
   * qualities that are used across all chest pieces. It's limited to 0-7, raises Illegal argument
   * exception if it is not.
   */

  public ChessPieceImpl(int initialRow, int initialColumn, Color color)
      throws IllegalArgumentException {
    if (initialRow >= 0 && initialRow <= 7) {
      this.currentRow = initialRow;
    } else {
      throw new IllegalArgumentException("Row cannot be less than 0 and greater than 7.");
    }

    if (initialColumn >= 0 && initialColumn <= 7) {
      this.currentColumn = initialColumn;
    } else {
      throw new IllegalArgumentException("Column cannot be less than 0 and greater than 7.");
    }
    this.currentColor = color;
  }

  @Override
  public int getRow() {
    return this.currentRow;
  }

  @Override
  public int getColumn() {
    return this.currentColumn;
  }

  @Override
  public boolean canMove(int row, int col) {
    if (row < 0 || row > 7) {
      return false;
    } else if (col < 0 || col > 7) {
      return false;
    } else if (col == this.getColumn() && row == this.getRow()) {
      return false;
    } else {
      return true;
    }
  }



  /**
   * This method checks if the opposite piece is an enemy. Returns true if the other piece is an
   * enemy.
   */
  protected boolean isEnemy(ChessPiece piece) {
    if (this.getColor() == piece.getColor()) {
      return false;
    } else {
      return true;
    }
  }


  @Override
  public boolean canKill(ChessPiece piece) {
    return this.canMove(piece.getRow(), piece.getColumn()) && this.isEnemy(piece);
  }

  @Override
  public Color getColor() {
    return this.currentColor;
  }
}
