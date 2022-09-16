package com.tw.step.assignment4.parking_lot;

import com.tw.step.assignment4.parking_lot.exception.MaxCapacityReachedException;
import com.tw.step.assignment4.parking_lot.notification.Notifiable;
import com.tw.step.assignment4.parking_lot.notification.Notification;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingLotAttendant implements Notifiable {

  private final List<ParkingLot> parkingLots;

  public ParkingLotAttendant(ParkingLot[] parkingLots) {
    this.parkingLots = Arrays.asList(parkingLots);
  }

  public void park(Car car) throws MaxCapacityReachedException {
    List<ParkingLot> parkingLotsWithSpotsAvailable = parkingLots.stream()
        .filter((parkingLot) -> !parkingLot.isFull())
        .collect(Collectors.toList());

    if (parkingLotsWithSpotsAvailable.size() == 0) {
      throw new MaxCapacityReachedException();
    }

    ParkingLot parkingLot = parkingLotsWithSpotsAvailable.get(0);
    parkingLot.add(car);
  }

  private void promoteParkingLot(int parkingLotId) {
    List<ParkingLot> collect = this.parkingLots.stream()
        .filter(parkingLot -> parkingLot.isSameLot(parkingLotId))
        .collect(Collectors.toList());

    ParkingLot parkingLotToPromote = collect.get(0);
    parkingLots.remove(parkingLotToPromote);
    parkingLots.add(0, parkingLotToPromote);
  }

  @Override
  public void receive(Notification notification, int parkingLotId) {
    if (notification == Notification.AT_TWENTY_PERCENT_OR_LESS) {
      this.promoteParkingLot(parkingLotId);
    }
  }
}