package com.tw.step.assignment4.parking;

import java.util.ArrayList;

public class ParkingLot {
  private final ArrayList<Car> cars;

  public ParkingLot() {
    this.cars = new ArrayList<Car>();
  }

  public boolean add(Car car) {
    return this.cars.add(car);
  }
}
