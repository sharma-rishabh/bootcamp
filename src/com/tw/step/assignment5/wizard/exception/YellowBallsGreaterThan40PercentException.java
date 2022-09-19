package com.tw.step.assignment5.wizard.exception;

public class YellowBallsGreaterThan40PercentException extends BagException {
  public YellowBallsGreaterThan40PercentException() {
    super("Yellow balls should always be less than 40%");
  }
}
