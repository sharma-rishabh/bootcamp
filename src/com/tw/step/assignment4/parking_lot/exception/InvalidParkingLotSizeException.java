package com.tw.step.assignment4.parking_lot.exception;

public class InvalidParkingLotSizeException extends RuntimeException {
  private final int size;

  public InvalidParkingLotSizeException(int size) {
    this.size = size;
  }

  @Override
  public String getMessage() {
    return String.format("A parking lot should be able to hold at least one vehicle %d", this.size);
  }
}
