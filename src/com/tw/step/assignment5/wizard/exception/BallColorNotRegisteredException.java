package com.tw.step.assignment5.wizard.exception;

import com.tw.step.assignment5.wizard.Color;

public class BallColorNotRegisteredException extends BagException {
  public BallColorNotRegisteredException(Color currentBallColor) {
    super(String.format("You are trying to add a %s ball whose color is not registered", currentBallColor));
  }
}
