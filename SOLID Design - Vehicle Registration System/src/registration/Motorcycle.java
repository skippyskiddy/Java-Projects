package registration;

/**
 * This class implements the IVehicle class and returns a Motorcycle instance. This class
 * returns basic attributes like make, production year, and purchase price, and as a motorcycle
 * has a passenger limit of 2 people.
 */
public class Motorcycle implements IVehicle {
  private String make;
  private int productionYear;
  private double purchasePrice;

  /**
   * Creates and returns a Motorcycle instance based on specifications from the IVehicle
   * interface.
   */
  public Motorcycle(String make, int productionYear, double purchasePrice) {
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
    return 2;
  }

}