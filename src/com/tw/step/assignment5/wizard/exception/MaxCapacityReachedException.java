package com.tw.step.assignment5.wizard.exception;

public class MaxCapacityReachedException extends Throwable {
  public MaxCapacityReachedException() {
    super("A bag can only hold 12 balls");
  }
}
