package com.tw.step.assignment5.wizard.exception;

import com.tw.step.assignment5.wizard.Color;

public class MaxCapacityReachedException extends Throwable {
  public MaxCapacityReachedException() {
    super("A bag can only hold 12 magic balls");
  }

  public MaxCapacityReachedException(Color color, int capacity) {
    super(String.format("Bag can hold only %d %s color magic balls", capacity, color));
  }
}
