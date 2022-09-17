package com.tw.step.assignment4.parking_lot;

import com.tw.step.assignment4.parking_lot.notification.Notifiable;
import com.tw.step.assignment4.parking_lot.notification.Notification;
import com.tw.step.assignment4.parking_lot.notification.Notifier;

import java.util.ArrayList;

public class ParkingLot {
  private final ArrayList<Car> cars;
  private final Notifier notifier;
  public int id;
  private final int size;

  ParkingLot(int id, int size) {
    this.notifier = new Notifier();
    this.id = id;
    this.size = size;
    this.cars = new ArrayList<>();
  }

  public void add(Car car) {
    if (this.isFull()) {
      this.notifier.notify(Notification.ALREADY_FULL, this.id);
      return;
    }

    this.cars.add(car);
    this.sendNecessaryNotifications();
  }

  private void sendNecessaryNotifications() {
    if (this.isFull()) {
      this.notifier.notify(Notification.MAX_CAPACITY, this.id);
      return;
    }

    if (this.isEightyPercentFull()) {
      this.notifier.notify(Notification.EIGHTY_PERCENT_FULL, this.id);
      return;
    }

    if (this.isEightyPercentEmpty()) {
      this.notifier.notify(Notification.AT_TWENTY_PERCENT_OR_LESS, this.id);
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

  public void subscribe(Notifiable receiver, Notification notification) {
    this.notifier.subscribe(receiver, notification);
  }

  public void notify(Notification notification, int id) {
    this.notifier.notify(notification, id);
  }

  public void unsubscribe(Notifiable receiver, Notification notification) {
    this.notifier.unsubscribe(receiver, notification);
  }
}
