package com.tw.step.assignment4.parking;

public class ParkingNotification {
  final boolean isParked;
  final boolean isFull;

  public ParkingNotification(boolean isParked, boolean isFull) {
    this.isParked = isParked;
    this.isFull = isFull;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ParkingNotification that = (ParkingNotification) o;

    if (isParked != that.isParked) return false;
    return isFull == that.isFull;
  }

  @Override
  public int hashCode() {
    int result = (isParked ? 1 : 0);
    result = 31 * result + (isFull ? 1 : 0);
    return result;
  }
}
