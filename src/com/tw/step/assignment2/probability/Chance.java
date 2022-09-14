package com.tw.step.assignment2.probability;

public class Chance {

  private final int totalOutcomes;
  private final int favourableOutcomes;

  public Chance(int totalOutcomes, int favourableOutcomes) {
    this.totalOutcomes = totalOutcomes;
    this.favourableOutcomes = favourableOutcomes;
  }

  public double ofGetting() {
    return (double) favourableOutcomes / totalOutcomes;
  }

  public double ofNotGetting() {
    return 1 - ofGetting();
  }
}
