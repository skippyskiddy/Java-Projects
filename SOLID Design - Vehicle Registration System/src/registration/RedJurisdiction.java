package registration;

/**
 * This class implements the IJurisdiction interface, and has an excise tax override of 5% the
 * vehicle purchased. The Red Jurisdiction emphasizes easy, no frills taxing.
 */
public class RedJurisdiction implements IJurisdiction {
  //no frills no tax jurisdiction
  @Override
  public double exciseTax(IVehicle vehicle) {
    return vehicle.getPurchasePrice() * 0.05;
  }

  @Override
  public String toString() {
    return "Red";
  }
}