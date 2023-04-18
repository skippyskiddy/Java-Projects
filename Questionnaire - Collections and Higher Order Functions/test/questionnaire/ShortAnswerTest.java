package questionnaire;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

class ShortAnswerTest {
  private Question required;

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    required = new ShortAnswer("required", true);
  }

  @org.junit.jupiter.api.Test
  void testTooLong() {
    char[] zeroes = new char[281];
    Arrays.fill(zeroes, '0'); // makes an array full of 0's to test
    String tooLong = new String(zeroes);
    assertThrows(IllegalArgumentException.class, () -> required.answer(tooLong));
  }

  @org.junit.jupiter.api.Test
  void testNullAnswer() {
    assertThrows(IllegalArgumentException.class, () -> required.answer(null));
  }

  @org.junit.jupiter.api.Test
  void testValidAnswer() {
    required.answer("some reasonable answer");
    assertEquals("some reasonable answer", required.getAnswer());
  }

  @org.junit.jupiter.api.Test
  void testCopy() {
    Question copy = required.copy();
    assertNotSame(required, copy);
    assertEquals(required.getAnswer(), copy.getAnswer());
    assertEquals(required.getPrompt(), copy.getPrompt());
  }

  @org.junit.jupiter.api.Test
  void testCopyWithAnswer() {
    required.answer("first");
    Question copy = required.copy();
    assertNotSame(required, copy);
    assertEquals(required.getAnswer(), copy.getAnswer());
    assertEquals(required.getPrompt(), copy.getPrompt());

    // make sure changes to the original do not affect the copy
    required.answer("second");
    assertNotEquals(required.getAnswer(), copy.getAnswer());
  }
}
