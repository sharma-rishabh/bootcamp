package com.tw.step.assignment5.wizard;

import java.util.HashSet;

public class MagicBalls {
  private final HashSet<MagicBall> balls;
  public MagicBalls() {
    this.balls = new HashSet<>();
  }

  public boolean add(MagicBall ball) {
    return this.balls.add(ball);
  }

  public int size() {
    return this.balls.size();
  }

  public long numberOfBalls(Color color) {
    return this.balls.stream()
        .filter((magicBall -> magicBall.getColor() == color))
        .count();
  }
}
