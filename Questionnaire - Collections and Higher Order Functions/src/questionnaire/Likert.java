package questionnaire;

/**
 * Likert implements the Question interface and creates question instances that can be
 * answered on a fixed, 5-point Likert scale (Strongly Agree, Agree, Neither Agree nor
 * Disagree, Disagree, Strongly Disagree). An OVERRIDE of answer(String) would accept only these
 * precise words as valid answers, but again case-insensitive.
 */
public class Likert implements Question {

  private final boolean required;
  private final String prompt;
  private String answer;

  /**
   * This constructor creates a Likert question that can be answered only on a 5-point likert
   * scale, and inputs a prompt from the user and boolean indicating whether the question is
   * required. Use equalsIgnoreCase() method on the String class to check for case-insensitive
   * String equality
   */
  public Likert(String prompt, boolean required) {
    this.answer = "";
    this.required = required;
    this.prompt = prompt;  // any edge case checks here?
  }


  /**
   * Returns the question in a string format.
   */
  @Override
  public String getPrompt() {
    return this.prompt;
  }

  /**
   * Returns the boolean that indicates whether the question is required or not. True is
   * required, false is optional.
   */
  @Override
  public boolean isRequired() {
    return this.required;
  }


  /**
   * Stores the String answer for the Likert question based on the preset enums.
   */
  @Override
  public void answer(String answer) throws IllegalArgumentException {
    if (answer == null) {
      throw new IllegalArgumentException("Answer should not be null.");
    }

    for (LikertResponseOption option : LikertResponseOption.values()) {
      if (option.getText().equalsIgnoreCase(answer)) {
        this.answer = answer;
        return;
      }
    }

    throw new IllegalArgumentException("Answer does not match any option.");
  }

  /**
   * Returns the set likert scale answer. If the question has no answer, it will be null. If
   * null, returns an empty string.
   */
  @Override
  public String getAnswer() {
    return this.answer;
  }


  @Override
  public Question copy() {
    Question copy = new Likert(this.prompt, this.required);
    if (!answer.isBlank()) {
      copy.answer(this.answer);
    }
    return copy;
  }
}
