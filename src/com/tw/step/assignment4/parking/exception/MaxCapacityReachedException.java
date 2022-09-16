package com.tw.step.assignment4.parking.exception;

public class MaxCapacityReachedException extends Throwable {
  public MaxCapacityReachedException() {
    super();
  }

  @Override
  public String getMessage() {
    return "Parking lot reached max capacity.";
  }
}
