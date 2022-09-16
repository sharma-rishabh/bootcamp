package com.tw.step.assignment4.parking;

import com.tw.step.assignment4.parking.exception.InvalidParkingLotSizeException;

import java.util.ArrayList;

public class ParkingLot {
  private final ArrayList<Car> cars;
  private final int size;

  private ParkingLot(int size) {
    this.size = size;
    this.cars = new ArrayList<Car>();
  }

  public static ParkingLot createParkingLot(int size) {
    if (size <= 0) {
      throw new InvalidParkingLotSizeException(size);
    }
    return new ParkingLot(size);
  }

  public ParkingNotification add(Car car) {
    if (this.isFull()) {
      return new ParkingNotification(false,true);
    }

    this.cars.add(car);
    boolean isFull = this.isFull();
    return new ParkingNotification(true,isFull);
  }

  public boolean contains(Car car) {
    return this.cars.contains(car);
  }

  public boolean isFull() {
    return this.cars.size() == this.size;
  }
}
