package hw2;

/**
 * Name: Elif Tirkes
 * CS5004 Spring 2023
 * this class represents a mail item who has a width, depth, height, and recipient.
 */

public class MailItem {

  private int width;
  private int height;
  private int depth;
  private Recipient recipient;

  public Recipient getRecipient() {
    return this.recipient;
  }

  public int getWidth() {
    return this.width;
  }

  public int getHeight() {
    return this.height;
  }

  public int getDepth() {
    return this.depth;
  }

  /**
   * this constructor creates an instance of a mail item with the item's width, depth, height,
   * and intended recipient from the recipient class. Throws an illegal argument exception if
   * width or height are less than 1 inches.
   */

  //Might want to check below whether the dimensions are empty for the future.
  public MailItem(int width, int height, int depth, Recipient recipient)
      throws IllegalArgumentException {
    if (width < 1 || height < 1 || depth < 1) {
      throw new IllegalArgumentException("Width, Depth, and Height cannot be less than 1 inch.");
    } else {
      this.width = width;
      this.height = height;
      this.depth = depth;
    }

    if (recipient == null) {
      throw new IllegalArgumentException("Recipient field cannot be empty");
    } else {
      this.recipient = recipient;
    }

  }
}
