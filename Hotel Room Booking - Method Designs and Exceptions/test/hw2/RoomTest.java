package hw2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RoomTest {
  private Room singleRoom;
  private Room unexpectedRoom;
  private Room doubleRoom;
  private Room familyRoom;


  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    singleRoom = new Room(RoomType.SINGLE, 4.0);
    doubleRoom = new Room(RoomType.DOUBLE, 0);
    familyRoom = new Room(RoomType.FAMILY, 4.000);
  }

  @Test
  void isAvailableUnBooked() {
    Assertions.assertEquals(true, singleRoom.isAvailable());
  }

  @Test
  void isAvailableBooked() {
    singleRoom.bookRoom(1);
    Assertions.assertEquals(false , singleRoom.isAvailable());
  }

  @Test
  void isAvailableDoubleBooked() {
    doubleRoom.bookRoom(2);
    Assertions.assertEquals(false , doubleRoom.isAvailable());
  }

  //doesn't let you do anything because price is negative, so might be true
  @Test
  void isAvailableUnexpectedBooked() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      unexpectedRoom = new Room(RoomType.DOUBLE, -50);
      unexpectedRoom.isAvailable();
    });
  }

  @Test
  void bookSingleRoom() {
    singleRoom.bookRoom(1);
    Assertions.assertEquals(1, singleRoom.getNumberOfGuests());
  }

  @Test
  void bookSingleRoomNegative() {
    singleRoom.bookRoom(-1);
    Assertions.assertEquals(0, singleRoom.getNumberOfGuests());
  }

  @Test
  void bookDoubleRoom() {
    doubleRoom.bookRoom(2);
    Assertions.assertEquals(2, doubleRoom.getNumberOfGuests());
  }

  @Test
  void bookFamilyRoom() {
    familyRoom.bookRoom(4);
    Assertions.assertEquals(4, familyRoom.getNumberOfGuests());
  }

  @Test
  void bookUnsuccessfulFamilyRoom() {
    familyRoom.bookRoom(50);
    Assertions.assertEquals(0, familyRoom.getNumberOfGuests());
  }

  @Test
  void getNumberOfGuestsSingleUnbooked() {
    Assertions.assertEquals(0, singleRoom.getNumberOfGuests());
  }

  @Test
  void getNumberOfGuestsSingleBooked() {
    singleRoom.bookRoom(1);
    Assertions.assertEquals(1, singleRoom.getNumberOfGuests());
  }

}