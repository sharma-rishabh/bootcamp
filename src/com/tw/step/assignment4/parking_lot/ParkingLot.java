package com.tw.step.assignment4.parking_lot;

import com.tw.step.assignment4.parking_lot.notification.Notification;
import com.tw.step.assignment4.parking_lot.notification.Notifier;

import java.util.ArrayList;

public class ParkingLot {
  private final ArrayList<Car> cars;
  public int id;
  private final int size;
  private final Notifier notifier;

  ParkingLot(int id, int size, Notifier notifier) {
    this.id = id;
    this.size = size;
    this.notifier = notifier;
    this.cars = new ArrayList<>();
  }

  public void add(Car car) {
    if (this.isFull()) {
      notifier.notify(Notification.ALREADY_FULL, this.id);
      return;
    }

    this.cars.add(car);
    this.sendNecessaryNotifications();
  }

  private void sendNecessaryNotifications() {
    if (this.isFull()) {
      notifier.notify(Notification.MAX_CAPACITY, this.id);
      return;
    }

    if (this.isEightyPercentFull()) {
      notifier.notify(Notification.EIGHTY_PERCENT_FULL, this.id);
      return;
    }

    if (this.isEightyPercentEmpty()) {
      notifier.notify(Notification.AT_TWENTY_PERCENT_OR_LESS, this.id);
    }
  }

  private boolean isEightyPercentEmpty() {
    return (double) this.cars.size() / size <= 0.2;
  }

  private boolean isEightyPercentFull() {
    return (double) this.cars.size() / size >= 0.8;
  }

  public boolean contains(Car car) {
    return this.cars.contains(car);
  }

  public boolean isFull() {
    return this.cars.size() == this.size;
  }

  public boolean isSameLot(int lotId) {
    return this.id == lotId;
  }
}
