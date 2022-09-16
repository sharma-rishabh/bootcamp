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
    if (size<=0) {
      throw new InvalidParkingLotSizeException(size);
    }
    return new ParkingLot(size);
  }

  public boolean add(Car car) {
    return this.cars.add(car);
  }

  public boolean contains(Car car) {
    return this.cars.contains(car);
  }

  public boolean isFull() {
    return this.cars.size() == this.size;
  }
}
