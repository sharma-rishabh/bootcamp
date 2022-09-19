package com.tw.step.assignment5.wizard;

public class MagicBall {

  private final Color color;

  public MagicBall(Color color) {
    this.color = color;
  }
  public MagicBall() {
    this.color = Color.WHITE;
  }

  public Color getColor() {
    return this.color;
  }
}
