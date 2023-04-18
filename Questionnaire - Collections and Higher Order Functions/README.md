## Summary


This assignment is an implementation of a questionnaire that contains different types of questions: YesNo, ShortAnswer, and Likert, and they have common aspects like text, whether it is required or optional, answer string, and method to get answer. 

The YesNo, ShortAnswer, and Likert classes has constructors that take in the question prompt as a String and a boolean where true means the question is required, and false means optional. The answer method in each of these classes enforces the answer requirements for that question type. 

The implementation includes an interface, Questionnaire, which represents a collection of questions. The QuestionnaireImpl class implements the Questionnaire interface and uses the List interface to store the questions.

