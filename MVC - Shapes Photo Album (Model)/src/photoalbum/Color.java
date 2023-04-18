package photoalbum;

/**
 * Enums describing the available colors for the shapes. This is a design choice with pros and
 * cons Colors can be implemented as a class or can alternatively be taken in from Strings as
 * well, but that is less type-safe. With enums, there is less room to set the color as something
 * that is not intended to be in the color field.
 */
public enum Color {
  RED, GREEN, BLUE, PURPLE, PINK, ORANGE, INDIGO, VIOLET,
  YELLOW, CYAN, MAGENTA, WHITE, BLACK, GREY;

  /**
   * Returns the name of the current color in uppercase letters.
   */

  @Override
  public String toString() {

    return this.name().toUpperCase();
  }
}