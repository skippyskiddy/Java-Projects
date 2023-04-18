package registration;

/**
 * This class implements the IVehicle class and returns an Automobile instance. This class
 * returns basic attributes like make, production year, and purchase price, and as an automobile
 * has a passenger limit of 5 people.
 */
public class Automobile implements IVehicle {
  private String make;
  private int productionYear;
  private double purchasePrice;

  /**
   * Creates and returns an automobile instance based on specifications from the IVehicle
   * interface.
   */
  public Automobile(String make, int productionYear, double purchasePrice) {
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
    return 5;
  }

}
