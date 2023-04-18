package questionnaire;

/**
 * ShortAnswer implements the Question interface and creates question instances that can
 * be answered in at most 280 characters, including spaces.
 */
public class ShortAnswer implements Question {
  private final String prompt;
  private final boolean required;

  private String answer;

  /**
   * This constructor creates a Short answer question that can be answered in at most 280
   * characters including spaces, and inputs a prompt from the user and boolean indicating whether
   * the question is required. Use equalsIgnoreCase() method on the String class to check for
   * case-insensitive String equality.
   */
  public ShortAnswer(String prompt, boolean required) {
    this.prompt = prompt;
    this.required = required;
    this.answer = "";
  }

  @Override
  public String getPrompt() {
    return this.prompt;
  }

  @Override
  public boolean isRequired() {
    return this.required;
  }

  @Override
  public void answer(String answer) {
    if (answer == null) {
      throw new IllegalArgumentException("Answer should not be null.");
    }

    if (answer.length() > 280) {
      throw new IllegalArgumentException("Answer is too long");
    }

    this.answer = answer;
  }

  @Override
  public String getAnswer() {
    return this.answer;
  }

  @Override
  public Question copy() {
    Question copy = new ShortAnswer(this.prompt, this.required);
    if (!this.answer.isBlank()) {
      copy.answer(this.answer);
    }
    return copy;
  }
}
