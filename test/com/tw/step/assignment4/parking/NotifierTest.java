package com.tw.step.assignment4.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotifierTest {

  @Test
  void shouldNotifyRegisteredNotifiables() {
    final Notification[] receivedNotification = new Notification[1];
    Notifier notifier = new Notifier();
    Notifiable notifiable = notification -> receivedNotification[0] = notification;

    notifier.add(notifiable,Notification.MAX_CAPACITY);
    notifier.notify(Notification.MAX_CAPACITY);

    assertEquals(receivedNotification[0],Notification.MAX_CAPACITY);
  }

}