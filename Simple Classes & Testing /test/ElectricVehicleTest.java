import static org.junit.jupiter.api.Assertions.assertEquals;

class ElectricVehicleTest {

  private ElectricVehicle expectedEv;
  private ElectricVehicle upperBoundsEv;
  private ElectricVehicle lowerBoundsEv;
  private ElectricVehicle negativeBoundsEv;

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    expectedEv = new ElectricVehicle("Ford", 20, 0.5, 2.0);
    upperBoundsEv = new ElectricVehicle("193814913Hjk!", 1000, 10.0001, 100.00);
    lowerBoundsEv = new ElectricVehicle("", 0, 0.01, 0.1);
    negativeBoundsEv = new ElectricVehicle("null", -10, -1.0, -48);
  }

  //EFFICIENCY
  @org.junit.jupiter.api.Test
  void getNormalEfficiency() {
    assertEquals(2.0, expectedEv.getEfficiency());
  }

  @org.junit.jupiter.api.Test
  void getClampedHighEfficiency() {
    assertEquals(4.5, upperBoundsEv.getEfficiency());
  }

  //BATTERYSIZE
  @org.junit.jupiter.api.Test
  void getNormalBatterySize() {
    assertEquals(20, expectedEv.getBatterySize());
  }

  @org.junit.jupiter.api.Test
  void getHighClampedBatterySize() {
    assertEquals(150.0, upperBoundsEv.getBatterySize());
  }

  //STATE OF CHARGE
  @org.junit.jupiter.api.Test
  void getNormalStateOfCharge() {
    assertEquals(0.5, expectedEv.getStateOfCharge());
  }

  @org.junit.jupiter.api.Test
  void getHighClampedStateofCharge() {
    assertEquals(1.0, upperBoundsEv.getStateOfCharge());
  }


  //NAME
  @org.junit.jupiter.api.Test
  void getNormalName() {
    assertEquals("Ford", expectedEv.getName());
  }

  @org.junit.jupiter.api.Test
  void getNonDigitName() {
    assertEquals("193814913Hjk!", upperBoundsEv.getName());
  }

  @org.junit.jupiter.api.Test
  void getEmptyName() {
    assertEquals("unknown EV", lowerBoundsEv.getName());
  }


  // RANGE     return (this.currentEfficiency * this.stateOfCharge * this.batterySize);
  @org.junit.jupiter.api.Test
  void rangeNormal() {
    assertEquals((2.0 * 0.5 * 20), expectedEv.range());

  }

  @org.junit.jupiter.api.Test
  void rangeUpperClamped() {
    assertEquals((4.5 * 1.0 * 150.0), upperBoundsEv.range());
  }

  @org.junit.jupiter.api.Test
  void rangeNegativeClamped() {
    assertEquals((0.5 * 0.15 * 10.0), negativeBoundsEv.range());
  }


  ///ToString
  @org.junit.jupiter.api.Test
  void testNormalToString() {
    assertEquals("Ford SOC: 50.0% Range (miles): 20.0", expectedEv.toString());
  }

  @org.junit.jupiter.api.Test
  void testUpperBoundsToString() {
    assertEquals("193814913Hjk! SOC: 100.0% Range (miles): 675.0", upperBoundsEv.toString());
  }

  @org.junit.jupiter.api.Test
  void testUpdateLowTempEfficiency() {
    double lowTemp = 1.0;
    assertEquals(2.0, expectedEv.getEfficiency());
    expectedEv.updateEfficiency(lowTemp);
    assertEquals(2.0 * 0.5, expectedEv.getEfficiency());
  }

  @org.junit.jupiter.api.Test
  void testUpdateNegTempEfficiency() {
    double negTemp = -14;
    assertEquals(2.0, expectedEv.getEfficiency());
    expectedEv.updateEfficiency(negTemp);
    assertEquals(2.0 * 0.5, expectedEv.getEfficiency());
  }

  @org.junit.jupiter.api.Test
  void testUpdateHighTempEfficiency() {
    double highTemp = 80.0;
    assertEquals(2.0, expectedEv.getEfficiency());
    expectedEv.updateEfficiency(highTemp);
    assertEquals(2.0 * 0.85, expectedEv.getEfficiency());
  }

  @org.junit.jupiter.api.Test
  void testUpdateNormalTempEfficiency() {
    double normalTemp = 40.0;
    assertEquals(2.0, expectedEv.getEfficiency());
    expectedEv.updateEfficiency(normalTemp);
    assertEquals(2.0 * (1.0 - ((65.0 - normalTemp) / 100.0)), expectedEv.getEfficiency());
  }
}