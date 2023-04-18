package questionnaire;

/**
 * YesNo is a type of class that implements question that would accept "Yes" or "No" as valid
 * answers, but is case-insensitive, so "yes" or "NO" are also be valid.
 */
public class YesNo implements Question {
  private final String prompt;
  private final boolean required;
  private String answer;


  /**
   * This constructor creates a Yes/No question that can be answered only with a case insensitive
   * yes/n, and inputs a prompt from the user and boolean indicating whether the question is
   * required. Use equalsIgnoreCase() method on the String class to check for case-insensitive
   * String equality
   */
  public YesNo(String prompt, boolean required) {
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
  public void answer(String answer) throws  IllegalArgumentException {
    if (answer == null) {
      throw new IllegalArgumentException("Answer should not be null.");
    }

    if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no")) {
      this.answer = answer;
      return;
    }

    throw new IllegalArgumentException("Answer does not match any option.");
  }

  @Override
  public String getAnswer() {
    return this.answer;
  }

  @Override
  public Question copy() {
    Question copy = new YesNo(this.prompt, this.required);
    if (!this.answer.isBlank()) {
      copy.answer(this.answer);
    }
    return copy;
  }
}
