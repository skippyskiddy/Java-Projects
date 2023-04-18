package questionnaire;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

class QuestionnaireImplTest {

  private Questionnaire questionnaire;

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    questionnaire = new QuestionnaireImpl();
  }

  @org.junit.jupiter.api.Test
  void testAddQuestion() {
    assertThrows(IndexOutOfBoundsException.class, () -> questionnaire.getQuestion(0));
    Question q1 = new ShortAnswer("prompt", true);
    Question q2 = new YesNo("yes", true);
    Question q3 = new Likert("Agree", false);
    questionnaire.addQuestion("i1", q1);
    questionnaire.addQuestion("i2", q2);
    questionnaire.addQuestion("i3", q3);
    assertEquals(2, questionnaire.getRequiredQuestions().size());
    assertEquals(1, questionnaire.getOptionalQuestions().size());
  }

  @org.junit.jupiter.api.Test
  void testAddDuplicateIdentifier() {
    Question q1 = new ShortAnswer("prompt", true);
    Question q2 = new YesNo("yes", true);
    questionnaire.addQuestion("i1", q1);
    assertThrows(IllegalArgumentException.class, () -> questionnaire.addQuestion("i1", q2));
  }

  @org.junit.jupiter.api.Test
  void testAddBadIdentifier() {
    Question q1 = new ShortAnswer("prompt", true);
    assertThrows(IllegalArgumentException.class, () -> questionnaire.addQuestion("", q1));
    assertThrows(IllegalArgumentException.class, () -> questionnaire.addQuestion(null, q1));
  }

  @org.junit.jupiter.api.Test
  void testRemoveQuestion() {
    Question q1 = new ShortAnswer("prompt", true);
    Question q2 = new YesNo("yes", true);
    questionnaire.addQuestion("i1", q1);
    questionnaire.addQuestion("i2", q2);
    assertEquals(2, questionnaire.getRequiredQuestions().size());
    questionnaire.removeQuestion("i1");
    assertEquals(1, questionnaire.getRequiredQuestions().size());
    assertEquals(q2, questionnaire.getQuestion(1));
    questionnaire.removeQuestion("i2");
    assertEquals(0, questionnaire.getRequiredQuestions().size());
  }

  @org.junit.jupiter.api.Test
  void testRemoveQuestionNonExistent() {
    assertThrows(NoSuchElementException.class, () -> questionnaire.removeQuestion("i1"));
  }

  @org.junit.jupiter.api.Test
  void testGetQuestionNum() {
    Question q1 = new ShortAnswer("prompt", true);
    questionnaire.addQuestion("i1", q1);
    assertEquals(q1, questionnaire.getQuestion(1));
  }

  @org.junit.jupiter.api.Test
  void testGetQuestionNumOutOfBounds() {
    Question q1 = new ShortAnswer("prompt", true);
    questionnaire.addQuestion("i1", q1);
    assertThrows(IndexOutOfBoundsException.class, () -> questionnaire.getQuestion(0));
    assertThrows(IndexOutOfBoundsException.class, () -> questionnaire.getQuestion(2));
  }

  @org.junit.jupiter.api.Test
  void testGetQuestionIdentifier() {
    Question q1 = new ShortAnswer("prompt", true);
    questionnaire.addQuestion("i1", q1);
    assertEquals(q1, questionnaire.getQuestion("i1"));
  }

  @org.junit.jupiter.api.Test
  void testGetQuestionIdentifierNotFound() {
    Question q1 = new ShortAnswer("prompt", true);
    questionnaire.addQuestion("i1", q1);
    assertThrows(NoSuchElementException.class, () -> questionnaire.getQuestion("i2"));
  }

  @org.junit.jupiter.api.Test
  void testGetRequiredQuestions() {
    Question q1 = new ShortAnswer("prompt", true);
    Question q2 = new ShortAnswer("prompt", true);
    Question q3 = new ShortAnswer("prompt", false);
    questionnaire.addQuestion("i1", q1);
    questionnaire.addQuestion("i2", q2);
    questionnaire.addQuestion("i3", q3);
    assertEquals(2, questionnaire.getRequiredQuestions().size());
  }

  @org.junit.jupiter.api.Test
  void testGetRequiredQuestionsEmpty() {
    assertEquals(0, questionnaire.getRequiredQuestions().size());
  }

  @org.junit.jupiter.api.Test
  void testGetOptionalQuestions() {
    Question q1 = new ShortAnswer("prompt", true);
    Question q2 = new ShortAnswer("prompt", true);
    Question q3 = new ShortAnswer("prompt", false);
    questionnaire.addQuestion("i1", q1);
    questionnaire.addQuestion("i2", q2);
    questionnaire.addQuestion("i3", q3);
    assertEquals(1, questionnaire.getOptionalQuestions().size());
  }

  @org.junit.jupiter.api.Test
  void testGetOptionalQuestionsEmpty() {
    assertEquals(0, questionnaire.getOptionalQuestions().size());
  }

  @org.junit.jupiter.api.Test
  void testIsCompleteTrue() {
    Question q1 = new ShortAnswer("prompt", true);
    q1.answer("val");
    Question q2 = new ShortAnswer("prompt", true);
    q2.answer("val");
    questionnaire.addQuestion("i1", q1);
    questionnaire.addQuestion("i2", q2);
    Question q3 = new ShortAnswer("prompt", false);
    questionnaire.addQuestion("i3", q3);
    assertTrue(questionnaire.isComplete());
  }

  @org.junit.jupiter.api.Test
  void testIsCompleteFalse() {
    Question q1 = new ShortAnswer("prompt", true);
    Question q3 = new ShortAnswer("prompt", false);
    q1.answer("val");
    q3.answer("val");
    questionnaire.addQuestion("i1", q1);
    Question q2 = new ShortAnswer("prompt", true);
    questionnaire.addQuestion("i2", q2);
    questionnaire.addQuestion("i3", q3);
    assertFalse(questionnaire.isComplete());
  }

  @org.junit.jupiter.api.Test
  void testGetResponses() {
    Question q1 = new ShortAnswer("prompt", true);
    Question q2 = new ShortAnswer("prompt", true);
    q1.answer("val1");
    q2.answer("val2");
    questionnaire.addQuestion("i1", q1);
    questionnaire.addQuestion("i2", q2);
    List<String> responses = questionnaire.getResponses();
    assertEquals(q1.getAnswer(), ((List<?>) responses).get(0));
    assertEquals(q2.getAnswer(), responses.get(1));
  }

  @org.junit.jupiter.api.Test
  void testFilter() {
    Question q1 = new ShortAnswer("include", true);
    Question q2 = new ShortAnswer("exclude", true);
    questionnaire.addQuestion("i1", q1);
    questionnaire.addQuestion("i2", q2);
    Questionnaire filtered = questionnaire.filter(q -> q.getPrompt().contains("include"));
    assertEquals(1, filtered.getRequiredQuestions().size());
    assertEquals("include", filtered.getQuestion(1).getPrompt());
  }

  @org.junit.jupiter.api.Test
  void testFilterNull() {
    assertThrows(IllegalArgumentException.class, () -> questionnaire.filter(null));
  }

  @org.junit.jupiter.api.Test
  void testSort() {
    Question q1 = new ShortAnswer("longer", true);
    Question q2 = new ShortAnswer("short", true);
    questionnaire.addQuestion("i1", q1);
    questionnaire.addQuestion("i2", q2);
    assertEquals("longer", questionnaire.getQuestion(1).getPrompt());
    // sort makes second be placed before first
    questionnaire.sort(Comparator.comparingInt(o -> o.getPrompt().length()));
    assertEquals("short", questionnaire.getQuestion(1).getPrompt());
  }

  @org.junit.jupiter.api.Test
  void testSortNull() {
    assertThrows(IllegalArgumentException.class, () -> questionnaire.sort(null));
  }

  @org.junit.jupiter.api.Test
  void testFold() {
    Question q1 = new ShortAnswer("longer", true);
    Question q2 = new ShortAnswer("short", true);
    questionnaire.addQuestion("i1", q1);
    questionnaire.addQuestion("i2", q2);
    int totalText = questionnaire.fold((q, seed) -> q.getPrompt().length() + seed, 0);
    assertEquals(11, totalText);
  }

  @org.junit.jupiter.api.Test
  void testFoldNull() {
    assertThrows(IllegalArgumentException.class, () -> questionnaire.fold(null, 0));
    assertThrows(IllegalArgumentException.class, () -> questionnaire.fold((q, seed) -> 0, null));
  }

  @org.junit.jupiter.api.Test
  void testToString() {
    Question q1 = new ShortAnswer("longer", true);
    Question q2 = new ShortAnswer("short", true);
    q2.answer("answer");
    questionnaire.addQuestion("i1", q1);
    questionnaire.addQuestion("i2", q2);
    String expected = "";
    expected += "Question: " + q1.getPrompt() + "\n\n";
    expected += "Answer: " + q1.getAnswer();
    expected += "\n\nQuestion: " + q2.getPrompt() + "\n\n";
    expected += "Answer: " + q2.getAnswer();
    assertEquals(expected, questionnaire.toString());
  }
}