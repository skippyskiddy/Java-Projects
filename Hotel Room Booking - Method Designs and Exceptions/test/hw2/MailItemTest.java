package hw2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MailItemTest {

  private MailItem mailItemExpected;
  private MailItem mailItemBig;
  private MailItem mailItemNegative;
  private Recipient expectedRecipient;
  private Recipient expectedRecipient2;


  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    expectedRecipient = new Recipient("Elif", "Tirkes", "elif@gmail.com");
    expectedRecipient2 = new Recipient("Steve", "Tirkes", "elif@gmail.com");

    mailItemExpected = new MailItem(5, 4 ,6, expectedRecipient);
    mailItemBig = new MailItem(600 , 300, 50, expectedRecipient2);

  }

  @Test
  void getRecipient() {
    Assertions.assertEquals(expectedRecipient, mailItemExpected.getRecipient());
  }

  @Test
  void getRecipientBig() {
    Assertions.assertEquals(expectedRecipient2, mailItemBig.getRecipient());
  }

  @Test
  void getRecipientError() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      mailItemNegative = new MailItem(-3,2 , -4, expectedRecipient);
      mailItemNegative.getRecipient();
    });
  }

  @Test
  void getWidth() {
    Assertions.assertEquals(5, mailItemExpected.getWidth());
  }

  @Test
  void getHeight() {
    Assertions.assertEquals(4, mailItemExpected.getHeight());
  }

  @Test
  void getHeightBig() {
    Assertions.assertEquals(300, mailItemBig.getHeight());
  }

  @Test
  void getDepth() {
    Assertions.assertEquals(6, mailItemExpected.getDepth());
  }

  @Test
  void getDepthError() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      mailItemNegative = new MailItem(-3,2 , -4, expectedRecipient);
      mailItemNegative.getDepth();
    });
  }
}