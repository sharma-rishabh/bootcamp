package com.tw.step.assignment4.parking_lot.notification;

public interface Notifiable {
  void receive(Notification notification, int id);
}
