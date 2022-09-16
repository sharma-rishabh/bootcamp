package com.tw.step.assignment3.measurement.exception;

public class InvalidLengthException extends RuntimeException {
  private final double quantity;

  public InvalidLengthException(double quantity) {
    super();
    this.quantity = quantity;
  }

  @Override
  public String getMessage() {
    return String.format("Length cannot be less than zero. You provided %f", this.quantity);
  }
}
