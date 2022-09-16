package com.tw.step.assignment4.parking_lot;

import com.tw.step.assignment4.parking_lot.exception.MaxCapacityReachedException;
import com.tw.step.assignment4.parking_lot.notification.Notifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotAttendantTest {

  @Test
  void shouldParkCarInParkingLot() throws MaxCapacityReachedException {
    ParkingLot firstParkingLot = ParkingLots.createParkingLot(1, new Notifier());
    Car car = new Car();

    ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant(new ParkingLot[]{firstParkingLot});
    parkingLotAttendant.park(car);
    assertTrue(firstParkingLot.contains(car));
  }

  @Test
  void shouldThrowMaxCapacityReachedExceptionWhenNoParkingSpaceIsAvailable() throws MaxCapacityReachedException {
    ParkingLot firstParkingLot = ParkingLots.createParkingLot(1, new Notifier());
    Car car = new Car();

    ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant(new ParkingLot[]{firstParkingLot});
    parkingLotAttendant.park(car);
    assertThrows(MaxCapacityReachedException.class, () -> parkingLotAttendant.park(new Car()));
  }
}