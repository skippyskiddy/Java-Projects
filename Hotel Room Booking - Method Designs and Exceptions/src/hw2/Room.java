package hw2;

/**
 * Name: Elif Tirkes
 * CS5004 Spring 2023
 * This class represents a hotel room, which has a room constructor with several room types, and
 * assisting methods to book rooms, check if they are available, and return a number of guests.
 * All rooms have:
 * 1. A maximum occupancy - This is the maximum number of people that can stay in the room.
 * 2. A price - The cost of a single night’s stay. The price of a room cannot be negative.
 * (We may decide to give people free ("comp") rooms as a perk if they're Diamond members).
 * 3. A number of guests - The number of guests currently booked into the room.
 * This value should be set to 0 when the room is first created in the system
 */

public class Room {

  private int maximumOccupancy;
  private double roomPrice; // cannot be negative
  private int currentNumberOfGuests; // set to 0

  /**
   * An isAvailable method. This method returns (answers) a boolean true if the room
   * is available and false if the room is unavailable (currently occupied).
   * A room is considered available if the current number of guests assigned to the room is 0.
   * A room is unavailable if a room currently has 1 or more guests assigned to it.
   * @returns
   */
  public boolean isAvailable() {
    if (this.currentNumberOfGuests == 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * A bookRoom method. This method takes one parameter:
   * the number of guests that will be assigned to the room (integer).
   * If the booking is valid (the room is available AND the number of
   * guests passed to this method is greater than 0 but less-than-or-equal-to
   * the maximum occupancy for the room type), this method sets the room's
   * number of guests to the value of the parameter passed in.
   * @param possibleGuests that want to book the room
   */
  public void bookRoom(int possibleGuests) {
    if (this.isAvailable() && possibleGuests <= maximumOccupancy && possibleGuests > 0) {
      this.currentNumberOfGuests = possibleGuests;
    }
  }

  /**
   * A getNumberOfGuests method that returns (answers)
   * an integer value representing the number of guests currently assigned to the room.
   * @returns the number of guests that are currently in the room.
   */
  public int getNumberOfGuests() {
    return this.currentNumberOfGuests;
  }

  /**
   * A hw2.Room constructor that takes two parameters:
   * the type of room being instantiated (hw2.Room.RoomType), and the price of the room (double).
   * hw2.Room.RoomType is a user-defined type that is described below.
   * If the price parameter is negative, raise an IllegalArgumentException.
   * @param type (room capacity based on type), price (price of the room)
   * @returns An instance of the room class
   */
  public Room(RoomType type, double price) throws IllegalArgumentException {

    //occupancy
    switch (type) {
      case SINGLE: this.maximumOccupancy = 1;
      break;
      case DOUBLE: this.maximumOccupancy = 2;
      break;
      case FAMILY: this.maximumOccupancy = 4;
      break;
    }

    ///price
    if (price < 0) {
      throw new IllegalArgumentException("Price must be greater than or equal to 0.");
    } else {
      this.roomPrice = price;
    }

    ///numberofguests
    this.currentNumberOfGuests = 0;

  }

}


