package hw2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LockerTest {
  private Recipient expectedRecipient;
  private Recipient expectedRecipient2;
  private MailItem mailItemExpected;
  private MailItem mailItemBig;
  private Locker lockerExpected;
  private Locker lockerBig;
  private Locker lockerNegative;

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    expectedRecipient = new Recipient("Elif", "Tirkes", "elif@gmail.com");
    expectedRecipient2 = new Recipient("Steve", "Tirkes", "elif@gmail.com");

    mailItemExpected = new MailItem(5, 4 ,6, expectedRecipient);
    mailItemBig = new MailItem(600 , 300, 50, expectedRecipient2);

    lockerExpected = new Locker(6, 9,8);
    lockerBig = new Locker(1000, 500,800);
  }

  @Test
  void sizeComparisonExpected() {
    Assertions.assertEquals(true, lockerExpected.sizeComparison(mailItemExpected) );
  }

  @Test
  void sizeComparisonTooBig() {
    Assertions.assertEquals(false, lockerExpected.sizeComparison(mailItemBig) );
  }

  @Test
  void lockerWithException() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      lockerNegative = new Locker(-6, 5,8);
      lockerNegative.addMail(mailItemExpected);
    });
  }

  @Test
  void addMailLockerEmpty() {
    Assertions.assertEquals(null, lockerExpected.getMailInLocker()); //check if empty
    lockerExpected.addMail(mailItemExpected);
    Assertions.assertEquals(mailItemExpected, lockerExpected.getMailInLocker() );
  }

  @Test
  void doNotAddMailLockerFull() {
    Assertions.assertEquals(null, lockerExpected.getMailInLocker()); //check if empty
    lockerExpected.addMail(mailItemExpected);
    Assertions.assertEquals(mailItemExpected, lockerExpected.getMailInLocker());
    lockerExpected.addMail(mailItemBig); // do not add here because its full
    Assertions.assertEquals(mailItemExpected, lockerExpected.getMailInLocker() );
  }

  @Test
  void pickupMailSuccess() {
    Assertions.assertEquals(null, lockerExpected.getMailInLocker());
    lockerExpected.addMail(mailItemExpected);
    Assertions.assertEquals(mailItemExpected, lockerExpected.getMailInLocker());

    MailItem pickedUpMail = lockerExpected.pickupMail(expectedRecipient); // store results
    Assertions.assertEquals(pickedUpMail, mailItemExpected); // returns successful pickup
    Assertions.assertEquals(null, lockerExpected.getMailInLocker()); // checks if locker empty
  }

  @Test
  void pickupMailFail() {
    Assertions.assertEquals(null, lockerBig.getMailInLocker());
    lockerBig.addMail(mailItemBig);
    Assertions.assertEquals(mailItemBig, lockerBig.getMailInLocker());

    lockerBig.pickupMail(expectedRecipient); // wrong recipient tries to pick up
    Assertions.assertEquals(mailItemBig, lockerBig.getMailInLocker()); // the mail is not picked up

  }
}