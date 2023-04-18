
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import registration.Automobile;
import registration.BlueJurisdiction;
import registration.IJurisdiction;
import registration.IVehicle;
import registration.Person;
import registration.Registration;


class RegistrationTest {

  private IVehicle vehicle1;
  private IJurisdiction blueJurisdiction;
  private int registrationYear1;
  private List<Person> owners1;
  private Registration registration1;

  @Before
  public void setUp() {
    vehicle1 = new Automobile("Ford", 2010, 15000);
    blueJurisdiction = new BlueJurisdiction();
    registrationYear1 = 2021;
    owners1 = Arrays.asList(new Person("Alice", "Jacksonville"));
    registration1 = new Registration(vehicle1, blueJurisdiction, registrationYear1, owners1);
  }

  @Test
  public void testGetRegistrationYear() {
    assertEquals(registrationYear1, registration1.getRegistrationYear());
  }

  @Test
  public void testGetProductionYear() {
    assertEquals(vehicle1.getProductionYear(), registration1.getProductionYear());
  }

  @Test
  public void testGetJurisdiction() {
    assertEquals(blueJurisdiction, registration1.getJurisdiction());
  }

  @Test
  public void testGetOwners() {
    assertEquals(owners1, registration1.getOwners());
  }

  @Test
  public void testGetMaxPassengers() {
    assertEquals(vehicle1.getMaxPassengers(), registration1.getMaxPassengers());
  }

  @Test
  public void testCalculateExciseTax() {
    double expectedTax = blueJurisdiction.exciseTax(vehicle1);
    assertEquals(expectedTax, registration1.calculateExciseTax(), 0.01);
  }

  @Test
  public void testEqualsAndHashCode() { //should equal with name, vehicle, and production year
    // being the same
    IVehicle vehicle2 = new Automobile("Ford", 2010, 15000);
    IJurisdiction jurisdiction2 = new BlueJurisdiction();
    int registrationYear2 = 2021;
    List<Person> owners2 = Arrays.asList(new Person("Alice", "Jacksonville"));
    Registration registration2 =
        new Registration(vehicle2, jurisdiction2, registrationYear2, owners2);

    assertTrue(registration1.equals(registration2) && registration2.equals(registration1));
    assertEquals(registration1.hashCode(), registration2.hashCode());
  }

  @Test
  public void testDoesNotEquals() { //obviously different vehicles but same owner, not equal
    IVehicle vehicle2 = new Automobile("Toyota", 2008, 15000);
    IJurisdiction jurisdiction2 = new BlueJurisdiction();
    int registrationYear2 = 2021;
    List<Person> owners2 = Arrays.asList(new Person("Alice", "Jacksonville"));
    Registration registration2 =
        new Registration(vehicle2, jurisdiction2, registrationYear2, owners2);

    assertFalse(registration1.equals(registration2) && registration2.equals(registration1));
    assertNotEquals(registration1.hashCode(), registration2.hashCode());
  }

  @Test
  public void testToString() {
    String expected = "Registration:\n"
        + "AUTOMOBILE: Ford Year(2010) Price = $15000.00\n"
        + "Owned By: Alice, Jacksonville\n"
        + "Year: 2021\n"
        + "Excise Tax: $" + String.format("%.2f", registration1.calculateExciseTax());
    assertEquals(expected, registration1.toString());
  }
}
