package hw2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RecipientTest {

  private Recipient expectedRecipient;
  private Recipient badEmailRecipient;
  private Recipient nullStringRecipient;
  private Recipient emptyStringRecipient;

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    expectedRecipient = new Recipient("Elif", "Tirkes", "elif@gmail.com");
    badEmailRecipient = new Recipient("Bob", "Thebuilder", "5");
  }

  @Test
  void testToStringExpected() {
    Assertions.assertEquals("Elif Tirkes Email:elif@gmail.com", expectedRecipient.toString());
  }

  @Test
  void testToStringBadEmail() {
    Assertions.assertEquals("Bob Thebuilder Email:5", badEmailRecipient.toString());
  }

  @Test
  void testToStringNullException() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      nullStringRecipient = new Recipient(null, "Tirkes", "elif@gmail.com");
    });
  }

  @Test
  void testToStringEmptyException() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      emptyStringRecipient = new Recipient(" ", "Tirkes", "elif@gmail.com");
    });
  }
}
