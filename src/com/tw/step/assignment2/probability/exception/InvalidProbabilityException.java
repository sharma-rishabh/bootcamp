package com.tw.step.assignment2.probability.exception;

public class InvalidProbabilityException extends Throwable {
  public InvalidProbabilityException(double probability) {
    super("Probability can only be between 0 and 1, you provided " + probability);
  }
}
