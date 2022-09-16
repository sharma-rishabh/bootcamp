package com.tw.step.assignment4.parking;

import com.tw.step.assignment4.parking.exception.InvalidParkingLotSizeException;

public class ParkingLots {
  private static int id = 1;

  public static ParkingLot createParkingLot(int size, Notifier notifier) {
    if (size <= 0) {
      throw new InvalidParkingLotSizeException(size);
    }
    ParkingLot parkingLot = new ParkingLot(id, size, notifier);
    id++;
    return parkingLot;
  }
}
