package com.tw.step.assignment4.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

  @Test
  void shouldThrowInvalidParkingLotSizeExceptionIfSizeIsLessThanOne() {
  }

  @Test
  void shouldAddACarToParkingLot() {
    ParkingLot parkingLot = ParkingLot.createParkingLot(1);
    assertTrue(parkingLot.add(new Car()));
  }

  @Test
  void shouldTellIfCarIsInParkingLot() {
    ParkingLot parkingLot = ParkingLot.createParkingLot(2);
    Car firstCar = new Car();
    Car secondCar = new Car();

    parkingLot.add(firstCar);

    assertTrue(parkingLot.contains(firstCar));
    assertFalse(parkingLot.contains(secondCar));
  }

  @Test
  void shouldTellIfParkingLotIsFull() {
    ParkingLot parkingLot = ParkingLot.createParkingLot(2);
    Car firstCar = new Car();
    Car secondCar = new Car();

    parkingLot.add(firstCar);
    assertFalse(parkingLot.isFull());

    parkingLot.add(secondCar);
    assertTrue(parkingLot.isFull());
  }
}