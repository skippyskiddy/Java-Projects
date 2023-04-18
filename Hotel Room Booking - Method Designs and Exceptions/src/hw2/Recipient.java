package hw2;

/**
 * Name: Elif Tirkes
 * CS5004 Spring 2023
 * This class represents a mail recipent who has a first name, last name, and email.
 */

public class Recipient {

  private String firstName;
  private String lastName;
  private String email;

  /**
  * this constructor creates a recipient instance with a first name, last name, and email. If any
  * fields are null, an exception is raised.
  */

  public Recipient(String firstName, String lastName, String email)
      throws IllegalArgumentException {
    if (firstName == null || firstName.isBlank()) {
      throw new IllegalArgumentException("First name cannot be empty.");
    } else {
      this.firstName = firstName;
    }

    if (lastName == null || lastName.isBlank()) {
      throw new IllegalArgumentException("Last name cannot be empty.");
    } else {
      this.lastName = lastName;
    }

    if (email == null || email.isBlank()) {
      throw new IllegalArgumentException("Email field cannot be empty");
    } else {
      this.email = email;
    }
  }

  /**
  * this toString method presents the recipients in this format:
  * FirstName LastName Email:xxx@yyyy.com.
  */
  public String toString() {
    return this.firstName + " " + this.lastName + " Email:" + this.email;
  }
}
