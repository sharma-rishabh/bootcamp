package com.tw.step.assignment5.wizard;

import com.tw.step.assignment5.wizard.exception.MaxCapacityReachedException;

import java.util.HashSet;
import java.util.stream.Collectors;

public class Bag {
  private final HashSet<MagicBall> magicBalls;
  int MAX_CAPACITY = 12;
  int MAX_GREEN_BALLS = 3;

  public Bag() {
    this.magicBalls = new HashSet<>();
  }

  public boolean add(MagicBall magicBall) throws MaxCapacityReachedException {
    if (this.isBagFull()) {
      throw new MaxCapacityReachedException();
    }
    if(this.hasEnoughGreenBalls()){
      throw  new MaxCapacityReachedException(Color.GREEN,this.MAX_GREEN_BALLS);
    }
    return this.magicBalls.add(magicBall);
  }

  private boolean isBagFull() {
    return magicBalls.size() == this.MAX_CAPACITY;
  }

  private boolean hasEnoughGreenBalls() {
    long count = this.magicBalls.stream()
        .filter((magicBall -> magicBall.getColor() == Color.GREEN))
        .count();
    return count == this.MAX_GREEN_BALLS;
  }
}
