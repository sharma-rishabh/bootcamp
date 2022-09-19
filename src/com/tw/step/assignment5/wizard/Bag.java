package com.tw.step.assignment5.wizard;

import com.tw.step.assignment5.wizard.exception.MaxCapacityReachedException;
import com.tw.step.assignment5.wizard.exception.NotEnoughGreenBallException;
import com.tw.step.assignment5.wizard.exception.YellowBallGreaterThan40PercentException;

import java.util.HashSet;

public class Bag {
  private final HashSet<MagicBall> magicBalls;
  int MAX_CAPACITY = 12;
  int MAX_GREEN_BALLS = 3;

  public Bag() {
    this.magicBalls = new HashSet<>();
  }

  public boolean add(MagicBall magicBall) throws MaxCapacityReachedException, NotEnoughGreenBallException, YellowBallGreaterThan40PercentException {
    this.validateBallAddition(magicBall);

    return this.magicBalls.add(magicBall);
  }

  private void validateBallAddition(MagicBall magicBall) throws MaxCapacityReachedException, NotEnoughGreenBallException, YellowBallGreaterThan40PercentException {
    if (this.isBagFull()) {
      throw new MaxCapacityReachedException();
    }
    if (magicBall.getColor() == Color.GREEN && this.hasEnoughGreenBalls()) {
      throw new MaxCapacityReachedException(Color.GREEN, this.MAX_GREEN_BALLS);
    }
    if (magicBall.getColor() == Color.RED && !this.canAddRedBall()) {
      throw new NotEnoughGreenBallException(this.numberOfBalls(Color.GREEN));
    }
    if (magicBall.getColor() == Color.YELLOW && !this.canAddYellowBall()) {
      throw new YellowBallGreaterThan40PercentException();
    }
  }

  private boolean canAddYellowBall() {
    int sizeAfterAddition = this.magicBalls.size() + 1;
    long yellowBallsAfterAddition = numberOfBalls(Color.YELLOW) + 1;
    return (double) yellowBallsAfterAddition/sizeAfterAddition <= 0.4;
  }


  private boolean canAddRedBall() {
    long greenBalls = this.numberOfBalls(Color.GREEN);
    long redBalls = this.numberOfBalls(Color.RED);
    return redBalls + 1 <= greenBalls*2;
  }

  private boolean isBagFull() {
    return magicBalls.size() == this.MAX_CAPACITY;
  }

  private boolean hasEnoughGreenBalls() {
    long count = this.numberOfBalls(Color.GREEN);
    return count == this.MAX_GREEN_BALLS;
  }

  private long numberOfBalls(Color color) {
    return this.magicBalls.stream()
        .filter((magicBall -> magicBall.getColor() == color))
        .count();
  }
}