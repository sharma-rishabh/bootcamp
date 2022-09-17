package com.tw.step.assignment4.parking_lot.notification;

import java.util.ArrayList;
import java.util.HashMap;

public class Notifier {
  HashMap<Notification, ArrayList<Notifiable>> notificationMap = new HashMap<>();

  public Notifier() {
  }

  private boolean isRegistered(Notification notification) {
    return notificationMap.containsKey(notification);
  }

  public void subscribe(Notifiable receiver, Notification notification) {
    if (isRegistered(notification)) {
      ArrayList<Notifiable> receivers = notificationMap.get(notification);
      receivers.add(receiver);
      return;
    }

    ArrayList<Notifiable> receivers = new ArrayList<>();
    receivers.add(receiver);
    notificationMap.put(notification, receivers);
  }

  public void notify(Notification notification, int id) {
    if (!isRegistered(notification)) {
      return;
    }

    ArrayList<Notifiable> receivers = notificationMap.get(notification);
    receivers.forEach((receiver) -> receiver.receive(notification, id));
  }

  public void unsubscribe(Notifiable receiver,Notification notification) {
    if (!isRegistered(notification)) {
      return;
    }
    ArrayList<Notifiable> receivers = notificationMap.get(notification);
    receivers.remove(receiver);
  }

}
