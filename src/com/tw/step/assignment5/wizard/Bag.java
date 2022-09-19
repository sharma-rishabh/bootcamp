package com.tw.step.assignment5.wizard;

import com.tw.step.assignment5.wizard.exception.MaxCapacityReachedException;

import java.util.HashSet;

public class Bag {
  private final HashSet<MagicBall> magicBalls;

  public Bag() {
    this.magicBalls = new HashSet<>();
  }

  public boolean add(MagicBall magicBall) throws MaxCapacityReachedException {
    if (magicBalls.size()==12) {
      throw new MaxCapacityReachedException();
    }
    return this.magicBalls.add(magicBall);
  }
}
