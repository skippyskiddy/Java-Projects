package registration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * This registration system class is a singleton, has only ONE instance running at any time.
 * It is mostly non-mutable and is used to keep track of registered vehicles and allow/deny
 * vehicles if they meet the requirements for specification.
 */
public class RegistrationSystem {
  // must be a singleton
  private static RegistrationSystem registrationSystem;
  private List<IRegistration> registrationList;

  /**
   * Initializes a registration system with a registration list to keep track of registered
   * 'registration' (vehicle) instances.
   */
  private RegistrationSystem() {
    registrationList = new ArrayList<>(); // Initialize the list
  }

  /**
   * Returns the current registration system, and creates a new registration system
   * instance if there is no registration system that is in use.
   */
  public static RegistrationSystem getInstance() {
    if (registrationSystem == null) { //ensuring one instance only
      registrationSystem = new RegistrationSystem();
    }
    return registrationSystem;
  }

  /**
   * This method creates a vehicle to be registered in the registration system, and runs it
   * through several specifications that are required for successful registration, i.e. making
   * sure the purchase price is positive, and that the production year and owners are valid.
   */
  public IVehicle createVehicle(String type, String make, int productionYear,
      double purchasePrice) {
    if (type == null || type.isEmpty()) {
      throw new IllegalArgumentException("Vehicle type cannot be null or empty string.");
    }
    if (make == null || make.isEmpty()) { //should give a compilation error if non-string
      throw new IllegalArgumentException("Invalid make of vehicle.");
    }
    if (productionYear < 1900 || productionYear > 2023) {
      throw new IllegalArgumentException("Invalid production year for vehicle.");
    }
    if (purchasePrice < 0) {
      throw new IllegalArgumentException("Invalid purchase price, must be greater than 0.");
    }

    switch (type.toUpperCase()) {
      case "MOTORCYCLE":
        return new Motorcycle(make, productionYear, purchasePrice);
      case "AUTO":
        return new Automobile(make, productionYear, purchasePrice);
      case "BOAT":
        return new Boat(make, productionYear, purchasePrice);
      default:
        return null;
    }
  }

  /**
   * Creates a new registration instance to be registered in the registration system's internal
   * list. If there is already an identical (equal) registration instance in the system, the
   * request for registration is ignored. Otherwise, the registration is added.
   */
  public void register(IVehicle vehicle, IJurisdiction jurisdiction, int registrationYear,
      List<Person> owners) {
    IRegistration newRegistration = new Registration(vehicle, jurisdiction, registrationYear,
        owners);
    if (!registrationList.contains(newRegistration)) {
      registrationList.add(newRegistration);
      //contains uses .equals override
    }
  }

  /**
   * Returns all registered vehicles in the system as an unmodifiable list.
   */
  public List<IRegistration> getAllRegistrations() {
    return Collections.unmodifiableList(registrationList);
  }

  /**
   * Filters the list of registered vehicles based on a predicate function, and returns an
   * unmodifiable filtered list of registered vehicles.
   */
  public List<IRegistration> getFilteredList(Predicate<IRegistration> query) {
    List<IRegistration> filteredList = new ArrayList<>();
    for (IRegistration registration : registrationList) {
      if (query.test(registration)) { //if query matches registered vehicle
        filteredList.add(registration); //add to filtered list
      }
    }
    return Collections.unmodifiableList(filteredList);
  }

  /**
   * Clears the whole registration list.
   */
  public void reboot() {
    registrationList.clear(); //clear the registration list
  }

}

