package com.tw.step.assignment5.wizard.exception;

public class BagAlreadyHasBlackBallException extends Throwable {
  public BagAlreadyHasBlackBallException() {
    super("You cannot add a Blue ball while bag already has a Black ball");
  }
}
