package questionnaire;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

class YesNoTest {
  private Question required;

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    required = new YesNo("required", true);
  }

  @org.junit.jupiter.api.Test
  void testInvalidOption() {
    assertThrows(IllegalArgumentException.class, () -> required.answer("bad option"));
    assertThrows(IllegalArgumentException.class, () -> required.answer(null));
  }

  @org.junit.jupiter.api.Test
  void testValidOptionCorrectCase() {
    required.answer("Yes");
    assertEquals("Yes", required.getAnswer());
  }

  @org.junit.jupiter.api.Test
  void testValidOptionIncorrectCase() {
    required.answer("YES");
    assertEquals("YES", required.getAnswer());
  }

  @org.junit.jupiter.api.Test
  void testCopy() {
    Question copy = required.copy();
    assertNotSame(required, copy); //check if instances are the same instance
    assertEquals(required.getAnswer(), copy.getAnswer());
    assertEquals(required.getPrompt(), copy.getPrompt());
  }

  @org.junit.jupiter.api.Test
  void testCopyWithAnswer() {
    required.answer("Yes");
    Question copy = required.copy();
    assertNotSame(required, copy);
    assertEquals(required.getAnswer(), copy.getAnswer());
    assertEquals(required.getPrompt(), copy.getPrompt());

    // make sure changes to the original do not affect the copy
    required.answer("No");
    assertNotEquals(required.getAnswer(), copy.getAnswer());
  }
}