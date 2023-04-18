package questionnaire;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


class LikertTest {
  private Likert requiredLikert;
  private Likert optionalLikert;

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    requiredLikert = new Likert("required", true);
    optionalLikert = new Likert("optional", false);
  }


  @org.junit.jupiter.api.Test
  void testRequired() {
    assertTrue(requiredLikert.isRequired());
  }

  @org.junit.jupiter.api.Test
  void testOptional() {
    assertFalse(optionalLikert.isRequired());
  }

  @org.junit.jupiter.api.Test
  void testNullAnswer() {
    assertEquals(requiredLikert.getAnswer(), "");
  }

  @org.junit.jupiter.api.Test
  void testInvalidOption() {
    assertThrows(IllegalArgumentException.class, () -> requiredLikert.answer("bad option"));
    assertThrows(IllegalArgumentException.class, () -> requiredLikert.answer(null));
  }

  @org.junit.jupiter.api.Test
  void testValidOptionCorrectCase() {
    requiredLikert.answer("Strongly Disagree");
    assertEquals("Strongly Disagree", requiredLikert.getAnswer());
  }

  @org.junit.jupiter.api.Test
  void testValidOptionWeirdCase() {
    requiredLikert.answer("sTroNgly DisAGrEe");
    assertEquals("sTroNgly DisAGrEe", requiredLikert.getAnswer());
  }

  @org.junit.jupiter.api.Test
  void testCopy() {
    Question copy = requiredLikert.copy();
    assertNotSame(requiredLikert, copy);
    assertEquals(requiredLikert.getAnswer(), copy.getAnswer());
    assertEquals(requiredLikert.getPrompt(), copy.getPrompt());
  }

  @org.junit.jupiter.api.Test
  void testCopyWithAnswer() {
    requiredLikert.answer("Strongly Agree");
    Question copy = requiredLikert.copy();
    assertNotSame(requiredLikert, copy);
    assertEquals(requiredLikert.getAnswer(), copy.getAnswer());
    assertEquals(requiredLikert.getPrompt(), copy.getPrompt());

    // make sure changes to the original do not affect the copy
    requiredLikert.answer("Strongly Disagree");
    assertNotEquals(requiredLikert.getAnswer(), copy.getAnswer());
  }
}