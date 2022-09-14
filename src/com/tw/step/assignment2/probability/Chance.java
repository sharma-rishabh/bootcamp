package com.tw.step.assignment2.probability;

import com.tw.step.assignment2.probability.exception.InvalidProbabilityException;

public class Chance {
  private final double probability;

  private Chance(double probability) {
    this.probability = probability;
  }

  public static Chance createChance(double probability) throws InvalidProbabilityException {
    if (probability > 1 || probability < 0) {
      throw new InvalidProbabilityException(probability);
    }
    return new Chance(probability);
  }

  public Chance complement() throws InvalidProbabilityException {
    return createChance(1 - probability);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Chance chance = (Chance) o;

    return Double.compare(chance.probability, probability) == 0;
  }

  @Override
  public int hashCode() {
    long temp = Double.doubleToLongBits(probability);
    return (int) (temp ^ (temp >>> 32));
  }
}
