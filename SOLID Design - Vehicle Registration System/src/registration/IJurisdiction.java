package registration;

/**
 * This interfaces outlines the necessary methods for each jurisdiction in a registration system.
 * Every jurisdiction implementation needs to have a specific excise tax method that calculates
 * vehicle tax costs based on the jurisdiction's priorities.
 */
public interface  IJurisdiction {
  //jurisdictions are function objects so override tostring

  /**
   * Takes in a vehicle type and calculates the correct excise tax for the vehicle based on its
   * attributes and based on the specifications of each jurisdiction implementation. Returns a
   * double, which represents the excise tax.
   */
  default double exciseTax(IVehicle vehicle) {
    return 0.0;
  }
}