package com.tw.step.assignment4.parking_lot;

import com.tw.step.assignment4.parking_lot.exception.MaxCapacityReachedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttendantTest {
  @Test
  void shouldAddParkingLot() {
    ParkingLot parkingLot = ParkingLots.createParkingLot(1);
    Attendant attendant = new Attendant();

    assertTrue(attendant.attend(parkingLot));
  }

  @Test
  void shouldParkCarInParkingLot() throws MaxCapacityReachedException {
    ParkingLot parkingLot = ParkingLots.createParkingLot(1);
    Car car = new Car();

    Attendant attendant = new Attendant();
    attendant.attend(parkingLot);
    attendant.park(car);
    assertTrue(parkingLot.contains(car));
  }

  @Test
  void shouldThrowMaxCapacityReachedExceptionWhenNoParkingSpaceIsAvailable() throws MaxCapacityReachedException {
    ParkingLot parkingLot = ParkingLots.createParkingLot(1);
    Car car = new Car();

    Attendant attendant = new Attendant();
    attendant.attend(parkingLot);
    attendant.park(car);
    assertThrows(MaxCapacityReachedException.class, () -> attendant.park(new Car()));
  }
}