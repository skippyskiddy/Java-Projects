package registration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * The Registration class gives concrete implementations for the IRegistration interface and
 * extends the capabilities of vehicles to be registered in the registration system by overriding
 * .equals() and .hashcode() to defend against duplicate registrations.
 */
public class Registration implements IRegistration {
  ///to SOLID (single responsibility principle) RegistrationSystem,
  // Registration implements IRegistration
  private IVehicle vehicle;
  private IJurisdiction jurisdiction;
  private int registrationYear;
  private List<Person> owners; //can have multiple owners

  /**
   * Initializes a registration, which requires a vehicle, designated jurisdiction, registration
   * year, and a list of owners for the vehicle. This registration instance is then input into
   * the registration system and approved if it fits requirements and specifications.
   */
  public Registration(IVehicle vehicle, IJurisdiction jurisdiction, int registrationYear,
      List<Person> owners) {
    this.vehicle = vehicle;
    this.jurisdiction = jurisdiction;
    this.registrationYear = registrationYear;
    this.owners = new ArrayList<>(owners);
  }

  @Override
  public int getRegistrationYear() {
    return registrationYear;
  }

  @Override
  public int getProductionYear() {
    return vehicle.getProductionYear();
  }

  @Override
  public IJurisdiction getJurisdiction() {
    return jurisdiction;
  }

  @Override
  public List<Person> getOwners() {
    return Collections.unmodifiableList(owners);
  }

  @Override
  public int getMaxPassengers() {
    return vehicle.getMaxPassengers();
  }

  @Override
  public double calculateExciseTax() {
    return jurisdiction.exciseTax(vehicle);
  }

  @Override
  public boolean equals(Object obj) {
    //to be used in the registrationsystem class
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Registration other = (Registration) obj;
    return registrationYear == other.registrationYear
        && Objects.equals(vehicle, other.vehicle)
        && Objects.equals(owners, other.owners);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vehicle, registrationYear, owners);
  }

  @Override
  public String toString() {
    StringBuilder ownerList = new StringBuilder();
    for (Person owner : owners) {
      if (ownerList.length() > 0) {
        ownerList.append("; ");
      }
      ownerList.append(owner.toString());
    }
    return "Registration:\n" + vehicle.getClass().getSimpleName().toUpperCase() + ": "
        + vehicle.getMake() + " Year(" + vehicle.getProductionYear()
        + ") Price = $" + String.format("%.2f", vehicle.getPurchasePrice())
        + "\n" + "Owned By: " + ownerList.toString() + "\n"
        + "Year: " + registrationYear + "\n"
        + "Excise Tax: $" + String.format("%.2f", calculateExciseTax());
  }
}
