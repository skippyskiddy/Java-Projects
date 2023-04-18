package hw2;

/**
 * Name: Elif Tirkes
 * CS5004 Spring 2023
 * this class represents a mail locker with a max height, max width, max depth, and a mail item
 * to store.
 */
public class Locker {
  private int maxWidth;
  private int maxHeight;
  private int maxDepth;
  private MailItem mailItem;

  /**
   * this helper method returns the mail item currently in the class. Returns null if locker empty.
   */
  public MailItem getMailInLocker() {
    return this.mailItem;
  }


  /**
   * this helper method compares the size of the mail item with the size of the locker to make
   * sure it
   * fits.
   * @param mailItem - mailItem which dimensions will be checked
   * @return bool indicating whether the size of the mail item is appropriate for the locker
   */
  public boolean sizeComparison(MailItem mailItem) {
    return mailItem.getWidth() <= this.maxWidth
        && mailItem.getHeight() <= this.maxHeight
        && mailItem.getDepth() <= this.maxDepth;
  }

  /**
   * this method stores a mail item in a locker, only if the mail is within the dimensions of the
   * locker and if the locker is unoccupied. If either of these cases are true, the item is not
   * added to the locker.
   */
  public void addMail(MailItem mailItem) {
    if (sizeComparison(mailItem) && this.mailItem == null) {
      this.mailItem = mailItem;
    }
  }

  /**
   * this method removes and returns the mail item from the locker under
   * the following conditions: IF there is a mail item in the locker AND the recipient passed to
   * pickup mail matches the recipient of the mail item.
   * If the recipients do not match OR if
   * there is no
   * mail currently in the locker, this method returns null.
   * @param recipient from the hw2.Recipient class
   * @return hw2.MailItem that was picked up
   */
  public MailItem pickupMail(Recipient recipient) {
    if (this.mailItem != null && recipient.equals(mailItem.getRecipient())) {
      MailItem pickedUpMail = this.mailItem;
      this.mailItem = null;
      return pickedUpMail;
    } else {
      return null;
    }
  }


  /**
   * this constructor constructs a locker for a mail item and recipient to pick up their mail
   * from. It determines a max height, width, and depth for the locker, and creates a locker
   * instance. If any of its parameters are less than 1, it throws an illegal argument exception.
   * Mail item is set to null by default.
   */
  public Locker(int maxWidth,  int maxHeight, int maxDepth) throws IllegalArgumentException {
    if (maxHeight < 1 || maxDepth < 1 || maxWidth < 1) {
      throw new IllegalArgumentException("Max depth, height, or width cannot be less than 1 inch.");
    } else {
      this.maxHeight = maxHeight;
      this.maxWidth = maxWidth;
      this.maxDepth = maxDepth;
    }
    this.mailItem = null; //initialize mail item to null

  }

}
