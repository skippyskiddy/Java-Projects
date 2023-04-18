package registration;

/**
 * This class implements the IJurisdiction interface, and has an excise tax override of 3% the
 * vehicle purchased, plus a $99 fixed fee if the vehicle is produced before the year 2000. The
 * Blue Jurisdiction emphasizes new vehicle purchases and economy stimulation.
 */
public class BlueJurisdiction implements IJurisdiction {
  @Override
  public double exciseTax(IVehicle vehicle) {
    double tax = vehicle.getPurchasePrice() * 0.03;
    if (vehicle.getProductionYear() < 2000) {
      tax += 99;
    }
    return tax;
  }

  @Override
  public String toString() {

    return "Blue";
  }
}
