package registration;


/**
 * This class implements the IVehicle class and returns an Boat instance. This class
 * returns basic attributes like make, production year, and purchase price, and as a boat,
 * has a passenger limit of 10 people.
 */
public class Boat implements IVehicle {
  private String make;
  private int productionYear;
  private double purchasePrice;

  /**
   * Creates and returns a boat instance based on specifications from the IVehicle
   * interface.
   */
  public Boat(String make, int productionYear, double purchasePrice) {
    this.make = make;
    this.productionYear = productionYear;
    this.purchasePrice = purchasePrice;
  }

  public String getMake() {
    return make;
  }

  public int getProductionYear() {
    return productionYear;
  }

  public double getPurchasePrice() {
    return purchasePrice;
  }

  public int getMaxPassengers() {
    return 10;
  }

}