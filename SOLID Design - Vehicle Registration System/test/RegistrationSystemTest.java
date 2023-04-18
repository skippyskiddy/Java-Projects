import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import registration.Automobile;
import registration.BlueJurisdiction;
import registration.IJurisdiction;
import registration.IRegistration;
import registration.IVehicle;
import registration.Person;
import registration.RedJurisdiction;
import registration.RegistrationSystem;


class RegistrationSystemTest {
  private RegistrationSystem registrationSystem;
  private Person owner;
  private IVehicle vehicle;

  @BeforeEach
  public void setUpNormal() {
    registrationSystem = RegistrationSystem.getInstance();
    owner = new Person("John Doe", "123456789");
    vehicle = new Automobile("Toyota", 2010, 20000.0);
  }

  @Test
  public void testCreateVehicle() {
    IVehicle newVehicle = registrationSystem.createVehicle("auto", "Honda", 2015, 15000.0);
    assertEquals("Honda", newVehicle.getMake());
    assertEquals(2015, newVehicle.getProductionYear());
    assertEquals(15000.0, newVehicle.getPurchasePrice(), 0.001);
  }

  @Test
  public void testCreateVehicleInvalidType() {
    IVehicle newVehicle = registrationSystem.createVehicle("invalid", "Honda", 2015, 15000.0);
    assertEquals(null, newVehicle);
  }

  @Test
  public void testCreateVehicleInvalidTypeError() {
    assertDoesNotThrow(() -> {
      IVehicle newVehicle = registrationSystem.createVehicle("AUTO", "Honda", 2015, 15000.0);
    });
    //acceptable variables as pegs
    assertThrows(IllegalArgumentException.class, () -> {
      IVehicle newVehicle = registrationSystem.createVehicle("", "Honda", 2015, 15000.0);
    });
    //empty string error
    assertThrows(IllegalArgumentException.class, () -> {
      IVehicle newVehicle = registrationSystem.createVehicle("AUTO", "", 2015, 15000.0);
    });
    // empty make string error
    assertThrows(IllegalArgumentException.class, () -> {
      IVehicle newVehicle = registrationSystem.createVehicle("AUTO", "Honda", -10, 15000.0);
    });
    //out of range production year error
    assertThrows(IllegalArgumentException.class, () -> {
      IVehicle newVehicle = registrationSystem.createVehicle("", "Honda", 2015, -10);
    });
    //out of range price error
  }

  @Test
  public void testRegister() {
    registrationSystem.register(vehicle, new BlueJurisdiction(), 2022, Arrays.asList(owner));
    assertEquals(1, registrationSystem.getAllRegistrations().size());
  }

  @Test
  public void testRegisterPreventDuplicate() {
    registrationSystem.register(vehicle, new BlueJurisdiction(), 2022, Arrays.asList(owner));
    registrationSystem.register(vehicle, new BlueJurisdiction(), 2022, Arrays.asList(owner));
    assertEquals(1, registrationSystem.getAllRegistrations().size());
    //check that there is only 1
  }

  @Test
  public void testGetAllRegistrations() {
    registrationSystem.register(vehicle, new BlueJurisdiction(), 2022, Arrays.asList(owner));
    assertEquals(1, registrationSystem.getAllRegistrations().size());
  }

  @Test
  public void testGetFilteredList() {
    RegistrationSystem registrationSystem = RegistrationSystem.getInstance();
    IVehicle auto1 = registrationSystem.createVehicle("AUTO", "Ford", 2020, 20000);
    IVehicle auto2 = registrationSystem.createVehicle("AUTO", "Chevrolet", 2015, 15000);
    // initialize various vehicles and registration system
    IJurisdiction blueJurisdiction = new BlueJurisdiction();
    IJurisdiction redJurisdiction = new RedJurisdiction();
    List<Person> owners = new ArrayList<>();
    owners.add(new Person("kevin", "BOB"));
    IVehicle motorcycle1 = registrationSystem.createVehicle("MOTORCYCLE", "Yamaha", 2018, 8000);
    IVehicle boat1 = registrationSystem.createVehicle("BOAT", "Bayliner", 2005, 25000);

    registrationSystem.register(auto1, blueJurisdiction, 2021, owners);
    registrationSystem.register(auto2, redJurisdiction, 2021, owners);
    registrationSystem.register(motorcycle1, blueJurisdiction, 2021, owners);
    registrationSystem.register(boat1, blueJurisdiction, 2021, owners);
    //register instances

    Predicate<IRegistration> autoFilter = reg -> {
      if (reg.getJurisdiction() instanceof BlueJurisdiction) {
        return reg.getRegistrationYear() == 2021;
      }
      return false;
    };
    //filter vehicles with blue jurisdiction

    List<IRegistration> filteredList = registrationSystem.getFilteredList(autoFilter);

    assertEquals(3, filteredList.size()); //should return three vehicles
  }

  @Test
  public void testReboot() {
    registrationSystem.register(vehicle, new BlueJurisdiction(), 2022, Arrays.asList(owner));
    assertEquals(1, registrationSystem.getAllRegistrations().size());
    registrationSystem.reboot();
    assertEquals(0, registrationSystem.getAllRegistrations().size());
  }
}
