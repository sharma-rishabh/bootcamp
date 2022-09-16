package com.tw.step.assignment4.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

  @Test
  void shouldAddACarToParkingLot() {
    ParkingLot parkingLot = new ParkingLot();
    assertTrue(parkingLot.add(new Car()));
  }
}