package com.tw.step.assignment4.parking;

import com.tw.step.assignment4.parking.exception.MaxCapacityReachedException;

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


  @Override
  public void receive(Notification notification, int parkingLotId) {

  }
}