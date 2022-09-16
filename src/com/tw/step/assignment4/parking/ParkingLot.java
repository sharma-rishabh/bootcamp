package com.tw.step.assignment4.parking;

import com.tw.step.assignment4.parking.exception.InvalidParkingLotSizeException;

import java.util.ArrayList;

public class ParkingLot {
  private final ArrayList<Car> cars;
  private final int size;
  private final Notifier notifier;

  private ParkingLot(int size, Notifier notifier) {
    this.size = size;
    this.notifier = notifier;
    this.cars = new ArrayList<>();
  }

  public static ParkingLot createParkingLot(int size, Notifier notifier) {
    if (size <= 0) {
      throw new InvalidParkingLotSizeException(size);
    }
    return new ParkingLot(size, notifier);
  }

  public void add(Car car) {
    if (this.isFull()) {
      notifier.notify(Notification.ALREADY_FULL);
      return;
    }

    this.cars.add(car);
    this.sendNecessaryNotifications();
  }

  private void sendNecessaryNotifications() {
    if (this.isFull()) {
      notifier.notify(Notification.MAX_CAPACITY);
      return;
    }

    if (this.isEightyPercentFull()) {
      notifier.notify(Notification.EIGHTY_PERCENT_FULL);
      return;
    }

    if (this.isEightyPercentEmpty()) {
      notifier.notify(Notification.AT_TWENTY_PERCENT_OR_LESS);
    }
  }

  private boolean isEightyPercentEmpty() {
    return (double) this.cars.size() / size <= 0.2;
  }

  private boolean isEightyPercentFull() {
    return  (double) this.cars.size()/size >= 0.8;
  }

  public boolean contains(Car car) {
    return this.cars.contains(car);
  }

  public boolean isFull() {
    return this.cars.size() == this.size;
  }
}
