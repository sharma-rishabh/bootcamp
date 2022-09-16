package com.tw.step.assignment4.parking;

import java.util.ArrayList;

public class ParkingLot {
  private final ArrayList<Car> cars;
  private final int size;

  public ParkingLot(int size) {
    this.size = size;
    this.cars = new ArrayList<Car>();
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
