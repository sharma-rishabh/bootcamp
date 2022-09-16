package com.tw.step.assignment4.parking_lot;

import com.tw.step.assignment4.parking_lot.exception.InvalidParkingLotSizeException;
import com.tw.step.assignment4.parking_lot.notification.Notifiable;
import com.tw.step.assignment4.parking_lot.notification.Notification;
import com.tw.step.assignment4.parking_lot.notification.Notifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

  @Test
  void shouldThrowInvalidParkingLotSizeExceptionIfSizeIsLessThanOne() {
    assertThrows(InvalidParkingLotSizeException.class,()->ParkingLots.createParkingLot(-1, new Notifier()));
  }

  @Test
  void shouldAddACarToParkingLot() {
    ParkingLot parkingLot = ParkingLots.createParkingLot(1, new Notifier());
    Car car = new Car();

    parkingLot.add(car);

    assertTrue(parkingLot.contains(car));
  }

  @Test
  void shouldTellIfCarIsInParkingLot() {
    ParkingLot parkingLot = ParkingLots.createParkingLot(2, new Notifier());
    Car firstCar = new Car();
    Car secondCar = new Car();

    parkingLot.add(firstCar);

    assertTrue(parkingLot.contains(firstCar));
    assertFalse(parkingLot.contains(secondCar));
  }

  @Test
  void shouldTellIfParkingLotIsFull() {
    ParkingLot parkingLot = ParkingLots.createParkingLot(2 , new Notifier());
    Car firstCar = new Car();
    Car secondCar = new Car();

    parkingLot.add(firstCar);
    assertFalse(parkingLot.isFull());

    parkingLot.add(secondCar);
    assertTrue(parkingLot.isFull());
  }

  @Test
  void shouldNotifyParkingLotIsFullAfterAddingACar() {
    final Notification[] receivedNotification = new Notification[1];

    Notifier notifier = new Notifier();
    Notifiable notifiable = (notification, id) -> receivedNotification[0] = notification;
    notifier.subscribe(notifiable, Notification.MAX_CAPACITY);

    ParkingLot parkingLot = ParkingLots.createParkingLot(1, notifier);
    parkingLot.add(new Car());

    assertEquals(receivedNotification[0],Notification.MAX_CAPACITY);
  }

  @Test
  void shouldNotifyParkingLotIsEightyFullAfterAddingACar() {
    final Notification[] receivedNotification = new Notification[1];

    Notifier notifier = new Notifier();
    Notifiable notifiable = (notification, id) -> receivedNotification[0] = notification;
    notifier.subscribe(notifiable, Notification.EIGHTY_PERCENT_FULL);

    ParkingLot parkingLot = ParkingLots.createParkingLot(5, notifier);
    parkingLot.add(new Car());
    parkingLot.add(new Car());
    parkingLot.add(new Car());
    parkingLot.add(new Car());

    assertEquals(receivedNotification[0],Notification.EIGHTY_PERCENT_FULL);
  }
  @Test
  void shouldNotifyParkingLotIsEightyEmptyAfterAddingACar() {
    final Notification[] receivedNotification = new Notification[1];

    Notifier notifier = new Notifier();
    Notifiable notifiable = (notification, id) -> receivedNotification[0] = notification;
    notifier.subscribe(notifiable, Notification.AT_TWENTY_PERCENT_OR_LESS);

    ParkingLot parkingLot = ParkingLots.createParkingLot(5, notifier);
    parkingLot.add(new Car());

    assertEquals(receivedNotification[0],Notification.AT_TWENTY_PERCENT_OR_LESS);
  }

  @Test
  void shouldNotifyParkingLotIsFullBeforeAddingACar() {
    final Notification[] receivedNotification = new Notification[1];

    Notifier notifier = new Notifier();
    Notifiable notifiable = (notification, id) -> receivedNotification[0] = notification;
    notifier.subscribe(notifiable, Notification.ALREADY_FULL);

    ParkingLot parkingLot = ParkingLots.createParkingLot(1, notifier);
    parkingLot.add(new Car());
    parkingLot.add(new Car());

    assertEquals(receivedNotification[0],Notification.ALREADY_FULL);
  }

}