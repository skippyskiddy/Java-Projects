package questionnaire;

/**
 * This interface states all common behaviors that must be shared among question objects, including
 * interactions with attributes like answer, optionality, and copying the question with all of
 * its stored attributes.
 */

public interface Question {

  /**
   * Returns the String text of the question.
   */
  public String getPrompt();

  /**
   * Returns the status of a question that indicates whether the question is
   * required or optional. Returns true if the question is required.
   */
  public boolean isRequired();

  /**
   *  Allows the user to enter an answer to the question as a string. Takes in and stores a
   *  string answer to that question.
   */
  public void answer(String answer);

  /**
   * Returns the user's stored answer to the question, most likely input through the answer();
   * method above. Returns empty string if there is no answer.
   */
  public String getAnswer();

  /**
   * Returns a copy of the question, with all of its attributes replicated.
   */
  public Question copy();
}
