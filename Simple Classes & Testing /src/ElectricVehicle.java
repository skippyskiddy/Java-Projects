import java.text.DecimalFormat;

/**
 * Name: Elif Tirkes
 * CS5004 Spring 2023
 * This class represents an electric vehicle, which has a name, battery size, state of charge for
 * the battery, current efficiency, and default efficiency for its vehicle.
 */
public class ElectricVehicle {
  private String name;
  private double batterySize;
  private double stateOfCharge;
  private double currentEfficiency;
  private double defaultEfficiency;

  static double CLAMPED_TEMPERATURE = 15.0;
  static double MINIMUM_TEMPERATURE = 65.0;
  static double MAXIMUM_TEMPERATURE = 77.0;


  /**
   * * This helper method converts the state of charge to its clamped values.
   * @param stateOfCharge The state of charge of the vehicle
   */
  private void stateOfChargeConverter(double stateOfCharge) {
    if (stateOfCharge < 0.15) {
      this.stateOfCharge = 0.15;
    } else if (stateOfCharge >= 0.15 && stateOfCharge <= 1.0) {
      this.stateOfCharge = stateOfCharge;
    } else {
      this.stateOfCharge = 1.0;
    }
  }

  /**
   * updateEfficiency updates the current efficiency of the vehicle object based on the
   * temperature.
   * @param currentTemp temperature, which through certain ranges influences the efficiency of
   *                    the vehicle, and updates the current efficiency attribute.
   */
  public void updateEfficiency(double currentTemp) {

    if (currentTemp > MAXIMUM_TEMPERATURE ) {
      this.currentEfficiency = this.defaultEfficiency * 0.85;
    } else if (currentTemp < MINIMUM_TEMPERATURE && currentTemp >= CLAMPED_TEMPERATURE) {
      this.currentEfficiency =
          this.defaultEfficiency * (1.0 - ((MINIMUM_TEMPERATURE - currentTemp) / 100.0));
    } else if (currentTemp >= MINIMUM_TEMPERATURE && currentTemp <= MAXIMUM_TEMPERATURE) {
      this.currentEfficiency = this.defaultEfficiency;
    } else {
      this.currentEfficiency = 0.5 * this.defaultEfficiency;
    }
  }

  /**
   * Constructs an electric vehicle object.
   * @param name Name of the vehicle. Defaults to "Unknown Ev" if the field is null or missing.
   * @param stateOfCharge State of charge for the electric vehicle (SoC) ranges from 15% to 100%
   *                      and gets clamped for any higher values
   * @param batterySize size of the vehicle's battery between 10.0 - 150.00 kwh, clamped to
   *                    minimum and maximum values for higher or lower input values.
   * @param defaultEfficiency the default efficiency of the vehicle. Min 0.5 Max 4.5, clamped to the
   *                          minimum and maximum values for higher or lower input values.
   */
  public ElectricVehicle(String name, double batterySize, double stateOfCharge,
      double defaultEfficiency) {

    //name
    if (name == null || name.isEmpty()) {
      this.name = "unknown EV";
    } else {
      this.name = name;
    }

    //battery size clamping
    if (batterySize < 10.0) {
      this.batterySize = 10.0;
    } else if (batterySize >= 10.00 && batterySize <= 150.0) {
      this.batterySize = batterySize;
    } else {
      this.batterySize = 150.0;
    }

    this.stateOfChargeConverter(stateOfCharge);

    //default efficiency clamping
    if (defaultEfficiency < 0.5) {
      this.defaultEfficiency = 0.5;
    } else if (defaultEfficiency >= 0.5 && defaultEfficiency <= 4.5) {
      this.defaultEfficiency = defaultEfficiency;
    } else {
      this.defaultEfficiency = 4.5;
    }

    //current efficiency
    this.currentEfficiency = this.defaultEfficiency;
  }

  /**
   * Returns the current efficiency of the vehicle after it is updated by updateEfficiency() and
   * takes into account the temperature.
   * @return the current efficiency attribute of the vehicle
   */
  public double getEfficiency() {
    return this.currentEfficiency;
  }

  /**
   * Return the battery size after it's been clamped by the constructor.
   * @return battery size
   */
  public double getBatterySize() {
    return this.batterySize;
  }

  /**
   * Return the current state of charge.
   * @return the state of charge.
   */
  public double getStateOfCharge() {
    return this.stateOfCharge;
  }

  /**
   * Return the name of the vehicle. Defaults to "Unknown EV" if this field is null.
   * @return string name of te vehicle.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Returns a new clamped value for the state of charge using the starting state of charge.
   * @param stateOfCharge return the updated state of charge after clamping it.
   */
  public void setStateOfCharge(double stateOfCharge) {
    if (stateOfCharge < 0.15) {
      this.stateOfCharge = 0.15;
    } else if (stateOfCharge >= 0.15 && stateOfCharge <= 1.0) {
      this.stateOfCharge = stateOfCharge;
    } else {
      this.stateOfCharge = 1.0;
    }
  }

  /**
   * Calculates the range of the vehicle using the vehicle's current efficiency, state of
   * charge, and battery size.
   * @return Returns range using the multiplied values.
   */
  public double range() {
    return (this.currentEfficiency * this.stateOfCharge * this.batterySize);
  }

  /**
   * Sets a decimal format using the imported DecimalFormat class.
   */
  private static final DecimalFormat df1 = new DecimalFormat( "#.0" );

  /**
   * Returns a string using the state of charge, name, and range of the vehicle.
   * @return String printing the values of the electric vehicle.
   */
  public String toString() {
    return this.name + " SOC: " + df1.format((this.stateOfCharge * 100)) + "% "
        + "Range (miles): " + df1.format(this.range());
  }

}
