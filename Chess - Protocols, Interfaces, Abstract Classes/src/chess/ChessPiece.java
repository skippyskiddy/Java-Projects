package chess;

/**
 * This interface specifies the basic methods that all Chess Pieces should employ.
 */
public interface ChessPiece {

  /**
   * Returns the current row number of the piece.
   */
  int getRow();

  /**
   * Returns the current column number of the piece.
   */
  int getColumn();

  /**
   * This method determines whether the chess piece can move to a specified cell. It's limited to
   * 0-7 for all pieces.
   */
  boolean canMove(int row, int col);

  /**
   * This method determines if the chess piece can kill another chess piece from its current
   * location, based on whether the piece is an enemy and is reachable by the current piece's
   * moving abilities.
   */
  boolean canKill(ChessPiece piece);

  /**
   * This method allows the chess piece to return its current chess square as an Enum Color.
   */
  Color getColor();

}
