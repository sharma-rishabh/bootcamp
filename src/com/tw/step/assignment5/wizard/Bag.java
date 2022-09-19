package com.tw.step.assignment5.wizard;

import com.tw.step.assignment5.wizard.exception.*;

import java.util.HashMap;

public class Bag {
  private final MagicBalls magicBalls;
  private final HashMap<Color, BallAdditionValidation> validations;
  int MAX_CAPACITY = 12;

  private Bag() {
    this.magicBalls = new MagicBalls();
    this.validations = new HashMap<>();
  }

  public static Bag createBag() {
    return new Bag();
  }

  public void register(Color color, BallAdditionValidation validation) {
    validations.put(color, validation);
  }

  public boolean add(MagicBall magicBall) throws BagException {
    this.validateBallAddition(magicBall);

    return this.magicBalls.add(magicBall);
  }

  private void validateBallAddition(MagicBall magicBall) throws BagException {
    if (this.isBagFull()) {
      throw new MaxCapacityReachedException();
    }

    Color currentBallColor = magicBall.getColor();
    if (!validations.containsKey(currentBallColor)) {
      throw new BallColorNotRegisteredException(currentBallColor);
    }

    BallAdditionValidation ballAdditionValidation = validations.get(currentBallColor);
    ballAdditionValidation.validateBall(this.magicBalls);
  }

  private boolean isBagFull() {
    return magicBalls.size() == this.MAX_CAPACITY;
  }
}
