package registration;

/**
 * This class implements the IJurisdiction interface, and has an excise tax override of 4% the
 * vehicle purchased, plus a $100 fixed fee multiplied by the number of maximum vehicle
 * passengers. The Green Jurisdiction emphasizes reduced carbon footprints.
 */
public class GreenJurisdiction implements IJurisdiction {
  //enjoys renewables and reduced carbon footprint
  @Override
  public double exciseTax(IVehicle vehicle) {
    return vehicle.getPurchasePrice() * 0.04 + vehicle.getMaxPassengers() * 100;
  }

  @Override
  public String toString() {
    return "Green";
  }
}
