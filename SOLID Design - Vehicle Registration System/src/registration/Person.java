package registration;

/**
 * This class initializes persons to be used in registering ownership of vehicles. Each person
 * requires a name and an address to be be initialized and have a vehicle registered under them.
 */
public class Person {
  private String name;
  private String address;

  /**
   * Create an instance of the person class, any valid string as name and address works to
   * initialize the person.
   */
  public Person(String name, String address) {
    this.name = name;
    this.address = address;
  }

  public String getName() {
    return this.name;
  }

  public String getAddress() {
    return this.address;
  }

  @Override
  public String toString() {
    return name + ", " + address;
  }
}