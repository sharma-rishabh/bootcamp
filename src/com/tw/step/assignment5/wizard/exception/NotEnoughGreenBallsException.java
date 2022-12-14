package com.tw.step.assignment5.wizard.exception;

public class NotEnoughGreenBallsException extends BagException {
  private final long greenBalls;

  public NotEnoughGreenBallsException(long greenBalls) {
    super();
    this.greenBalls = greenBalls;
  }

  @Override
  public String getMessage() {
    long greenBallsNeeded = this.greenBalls +1;
    return String.format("You need at least %d green balls to add another red ball", greenBallsNeeded);
  }
}
