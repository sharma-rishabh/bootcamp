package com.tw.step.assignment5.wizard.exception;

public class BagAlreadyHasBlueBallException extends BagException {

  public BagAlreadyHasBlueBallException() {
    super("You cannot add a Black ball while bag already has a Blue ball");
  }
}
