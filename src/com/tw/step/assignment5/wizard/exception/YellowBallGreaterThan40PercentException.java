package com.tw.step.assignment5.wizard.exception;

public class YellowBallGreaterThan40PercentException extends Throwable {
  public YellowBallGreaterThan40PercentException() {
    super("Yellow balls should always be less than 40%");
  }
}
