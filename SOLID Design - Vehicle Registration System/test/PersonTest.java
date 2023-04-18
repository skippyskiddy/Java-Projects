
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import registration.Person;

class PersonTest {
  //another class with mostly getters, so basic tests

  @Test
  public void testGetName() {
    Person person = new Person("Jason Derulo", "123 Main St");
    assertEquals("Jason Derulo", person.getName());
  }

  @Test
  public void testGetAddress() {
    Person person = new Person("Britney Spears", "123 Main St");
    assertEquals("123 Main St", person.getAddress());
  }

  @Test
  public void testToString() {
    Person person = new Person("John Doe", "1412 Main St");
    assertEquals("John Doe, 1412 Main St", person.toString());
  }
}
