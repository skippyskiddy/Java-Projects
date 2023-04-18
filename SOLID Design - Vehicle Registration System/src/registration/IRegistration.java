package registration;

import java.util.List;

//implement tostring and equals for concerete instances.

/**
 * This interface outlines the necessary functions for a vehicle registration to be successful.
 * This class has many parts that exist and are moved around in the RegistrationSystem class, and
 * is used to determine whether each registration is successful or not.
 */
public interface IRegistration {

  /**
   * Returns the vehicle's registration year.
   */
  public int getRegistrationYear();

  /**
   * Returns the vehicle's production year.
   */
  public int getProductionYear();

  /**
   * Returns the vehicle's designated jurisdiction.
   */
  public IJurisdiction getJurisdiction();

  /**
   * Returns the vehicle's owners as a list containing multiple instances of the person class.
   * Vehicles can have multiple owners. Must be non-mutable to prevent external manipulation.
   */
  public List<Person> getOwners();      // return NON-MUTABLE list

  /**
   * Returns the vehicle's maximum number of passengers.
   */
  public int getMaxPassengers();

  /**
   * Calculates the vehicle's excise tax using implementing classes of the IJurisdiction class.
   */
  public double calculateExciseTax();
}
