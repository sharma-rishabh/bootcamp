package com.tw.step.assignment4.parking_lot;

import com.tw.step.assignment4.parking_lot.notification.Notifiable;
import com.tw.step.assignment4.parking_lot.notification.Notification;
import com.tw.step.assignment4.parking_lot.notification.Notifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotifierTest {

  @Test
  void shouldNotifyRegisteredNotifiables() {
    final Notification[] receivedNotification = new Notification[1];
    Notifier notifier = new Notifier();
    Notifiable notifiable = (notification, id) -> receivedNotification[0] = notification;

    notifier.subscribe(notifiable,Notification.MAX_CAPACITY);
    notifier.notify(Notification.MAX_CAPACITY,0);

    assertEquals(receivedNotification[0],Notification.MAX_CAPACITY);
  }

}