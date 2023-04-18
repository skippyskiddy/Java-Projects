package questionnaire;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Questionnaire that creates a LIST of several types of questions created with the Question
 * interface.
 */
public class QuestionnaireImpl implements Questionnaire {

  /**
   * In order to track identifiers for questions, we keep
   * use a class that wraps the question.
   */
  private final List<IdentifiedQuestion> questions;

  /**
   * Constructs a Questionnaire instance that can hold several types of questions in an array list.
   */
  public QuestionnaireImpl() {
    this.questions = new ArrayList<>();
  }

  @Override
  public void addQuestion(String identifier, Question q) throws IllegalArgumentException {
    if (identifier == null || identifier.isBlank() || q == null) {
      throw new IllegalArgumentException("Identifier and question must be valid values");
    }

    for (IdentifiedQuestion iq : questions) {
      if (iq.getIdentifier().equals(identifier)) {
        throw new IllegalArgumentException("Identifier already exists");
      }
    }

    questions.add(new IdentifiedQuestion(q, identifier));
  }

  /**
   * Removes questions with matching identifier.
   */
  @Override
  public void removeQuestion(String identifier) throws NoSuchElementException {
    for (int i = 0; i < questions.size(); i++) {
      if (questions.get(i).getIdentifier().equals(identifier)) {
        questions.remove(i);
        return;
      }
    }

    throw new NoSuchElementException("Question not found");
  }

  @Override
  public Question getQuestion(int num) throws IndexOutOfBoundsException {
    if (num < 1 || num > this.questions.size()) {
      throw new IndexOutOfBoundsException("Question does not exist.");
    }
    return this.questions.get(num - 1).getQuestion();
  }

  @Override
  public Question getQuestion(String identifier) throws NoSuchElementException {
    for (IdentifiedQuestion question : questions) {
      if (question.getIdentifier().equals(identifier)) {
        return question.getQuestion();
      }
    }

    throw new NoSuchElementException("Question not found");
  }

  @Override
  public List<Question> getRequiredQuestions() {
    return this.questions.stream()
        .map(IdentifiedQuestion::getQuestion)
        .filter(Question::isRequired)
        .collect(Collectors.toList());
  }

  @Override
  public List<Question> getOptionalQuestions() {
    return this.questions.stream()
        .map(IdentifiedQuestion::getQuestion)
        .filter(q -> !q.isRequired())
        .collect(Collectors.toList());
  }

  @Override
  public boolean isComplete() {
    return this.getRequiredQuestions().stream().noneMatch(q -> q.getAnswer().isBlank());
  }

  @Override
  public List<String> getResponses() {
    return this.questions.stream()
        .map(q -> q.getQuestion().getAnswer())
        .collect(Collectors.toList());
  }

  @Override
  public Questionnaire filter(Predicate<Question> pq) throws IllegalArgumentException {
    if (pq == null) {
      throw new IllegalArgumentException("Predicate must not be null");
    }

    Questionnaire filtered = new QuestionnaireImpl();

    for (IdentifiedQuestion q : questions) {
      if (pq.test(q.getQuestion())) {
        filtered.addQuestion(q.getIdentifier(), q.getQuestion().copy());
      }
    }

    return filtered;
  }

  @Override
  public void sort(Comparator<Question> comp) {
    if (comp == null) {
      throw new IllegalArgumentException("Comparator must not be null");
    }

    this.questions.sort((q1, q2) -> comp.compare(q1.getQuestion(), q2.getQuestion()));
  }

  @Override
  public <R> R fold(BiFunction<Question, R, R> bf, R seed) {
    if (bf == null || seed == null) {
      throw new IllegalArgumentException("BiFunction and Seed must not be null");
    }

    return this.questions.stream()
        .map(IdentifiedQuestion::getQuestion)
        .reduce(seed,
            (accum, question) -> bf.apply(question, accum),
            (a, b) -> b);
  }

  @Override
  public String toString() {
    String questionnaireString = "";
    for (IdentifiedQuestion q : this.questions) {
      if (!questionnaireString.isBlank()) {
        questionnaireString += "\n\n";
      }
      questionnaireString += "Question: " + q.getQuestion().getPrompt() + "\n\n";
      questionnaireString += "Answer: " + q.getQuestion().getAnswer();
    }
    return questionnaireString;
  }
}
