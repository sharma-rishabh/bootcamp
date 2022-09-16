package com.tw.step.assignment4.parking_lot.notification;

import com.tw.step.assignment4.parking_lot.notification.Notifiable;
import com.tw.step.assignment4.parking_lot.notification.Notification;

import java.util.ArrayList;
import java.util.HashMap;

public class Notifier {
  HashMap<Notification, ArrayList<Notifiable>> notificationMap = new HashMap<>();

  public Notifier() {
  }

  public void subscribe(Notifiable receiver, Notification notification) {
    if (notificationMap.containsKey(notification)) {
      ArrayList<Notifiable> receivers = notificationMap.get(notification);
      receivers.add(receiver);
      return;
    }

    ArrayList<Notifiable> receivers = new ArrayList<>();
    receivers.add(receiver);
    notificationMap.put(notification, receivers);
  }

  public void notify(Notification notification, int id) {
    if (!notificationMap.containsKey(notification)) {
      return;
    }

    ArrayList<Notifiable> receivers = notificationMap.get(notification);
    receivers.forEach((receiver)->receiver.receive(notification,id));
  }
}
