package com.tw.step.assignment4.parking_lot;

import com.tw.step.assignment4.parking_lot.exception.MaxCapacityReachedException;
import com.tw.step.assignment4.parking_lot.notification.Notifiable;
import com.tw.step.assignment4.parking_lot.notification.Notification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Attendant implements Notifiable {

  private final List<ParkingLot> parkingLots = new ArrayList<>();

  public Attendant() {
  }

  public boolean attend(ParkingLot parkingLot) {
    return parkingLots.add(parkingLot);
  }

  public void park(Car car) throws MaxCapacityReachedException {
    List<ParkingLot> vacantParkingLots = getVacantParkingLots();

    if (vacantParkingLots.size() == 0) {
      throw new MaxCapacityReachedException();
    }

    ParkingLot parkingLot = vacantParkingLots.get(0);
    parkingLot.add(car);
  }

  private List<ParkingLot> getVacantParkingLots() {
    return parkingLots.stream()
        .filter((parkingLot) -> !parkingLot.isFull())
        .collect(Collectors.toList());
  }

  private void promoteParkingLot(int parkingLotId) {
    ParkingLot parkingLotToPromote = findParkingLot(parkingLotId);

    parkingLots.remove(parkingLotToPromote);
    parkingLots.add(0, parkingLotToPromote);
  }

  private ParkingLot findParkingLot(int parkingLotId) {
    List<ParkingLot> collect = this.parkingLots.stream()
        .filter(parkingLot -> parkingLot.isSameLot(parkingLotId))
        .collect(Collectors.toList());

    return collect.get(0);
  }

  @Override
  public void receive(Notification notification, int parkingLotId) {
    if (notification == Notification.AT_TWENTY_PERCENT_OR_LESS) {
      this.promoteParkingLot(parkingLotId);
    }
  }
}