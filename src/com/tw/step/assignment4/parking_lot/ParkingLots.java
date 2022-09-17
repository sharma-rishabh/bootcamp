package com.tw.step.assignment4.parking_lot;

import com.tw.step.assignment4.parking_lot.exception.InvalidParkingLotSizeException;
import com.tw.step.assignment4.parking_lot.notification.Notifier;

public class ParkingLots {
  private static int id = 1;

  public static ParkingLot createParkingLot(int size) {
    if (size <= 0) {
      throw new InvalidParkingLotSizeException(size);
    }

    ParkingLot parkingLot = new ParkingLot(id, size);
    id = id + 1;

    return parkingLot;
  }
}
