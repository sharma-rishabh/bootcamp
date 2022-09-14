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

  public Chance complement() {
    return new Chance(1 - probability);
  }

  public Chance and(Chance chance) {
    return new Chance(this.probability * chance.probability);
  }

  public Chance or(Chance chance) {
    Chance andOfChance = and(chance);

    double sumOfProbabilities = this.probability + chance.probability;
    return new Chance(sumOfProbabilities - andOfChance.probability);
  }

  public boolean isWithin(Chance chance, double delta) {
    double lowerBound = this.probability - delta;
    double upperBound = this.probability + delta;
    return isInRange(lowerBound, upperBound, chance.probability);
  }

  private static boolean isInRange(double lowerBound, double upperbound, double number) {
    return lowerBound <= number && upperbound >= number;
  }

  @Override
  public String toString() {
    return "Chance{" +
        "probability=" + probability +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Chance chance = (Chance) o;

    return isWithin(chance, 0.005);
  }

  @Override
  public int hashCode() {
    long temp = Double.doubleToLongBits(probability);
    return (int) (temp ^ (temp >>> 32));
  }
}
