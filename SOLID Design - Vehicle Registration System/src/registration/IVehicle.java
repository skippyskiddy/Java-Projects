package registration;

/**
 * This interface outlines the necessary methods to return the attributes of each vehicle's
 * instances,and is used to create different vehicle types.
 */
public interface IVehicle {

  /**
   * Return the make of the vehicle as a string.
   */
  String getMake();

  /**
   * Return the production year of the vehicle.
   */
  int getProductionYear();

  /**
   * Return the purchase price of the vehicle.
   */
  double getPurchasePrice();

  /**
   * Return the maximum passengers of the vehicle type.
   */
  int getMaxPassengers();
}

