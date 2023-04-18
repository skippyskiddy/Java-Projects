package questionnaire;

/**
 * Creates an identifier instance for each question so that the questionnaire can organize and
 * compare questions them.
 */
public class IdentifiedQuestion {
  private final Question question;
  private final String identifier;

  /**
   * Returns the Question and its identifier.
   */
  public IdentifiedQuestion(Question question, String identifier) {
    this.question = question;
    this.identifier = identifier;
  }

  public Question getQuestion() {
    return question;
  }

  public String getIdentifier() {
    return identifier;
  }
}
