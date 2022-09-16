package com.tw.step.assignment3.measurement.exception;

public class InvalidVolumeException extends RuntimeException {
  private final double quantity;

  public InvalidVolumeException(double quantity) {
    super();
    this.quantity = quantity;
  }

  @Override
  public String getMessage() {
    return String.format("Volume cannot be less than zero. You provided %f", this.quantity);
  }
}
