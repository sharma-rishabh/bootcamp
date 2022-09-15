package com.tw.step.assignment2.probability;

import com.tw.step.assignment2.probability.exception.InvalidProbabilityException;

public class Chance {
  private final double chance;

  private final static double CERTAINTY = 1.0;
  private final static double IMPOSSIBILITY = 0.0;

  private Chance(double chance) {
    this.chance = chance;
  }

  public static Chance createChance(double chance) throws InvalidProbabilityException {
    if (chance > CERTAINTY || chance < IMPOSSIBILITY) {
      throw new InvalidProbabilityException(chance);
    }
    return new Chance(chance);
  }

  public Chance complement() throws InvalidProbabilityException {
    return Chance.createChance(CERTAINTY - chance);
  }

  public Chance and(Chance anotherChance) throws InvalidProbabilityException {
    return Chance.createChance(this.chance * anotherChance.chance);
  }

  public Chance or(Chance anotherChance) throws InvalidProbabilityException {
    Chance andOfChance = this.and(anotherChance);
    double sumOfProbabilities = this.chance + anotherChance.chance;

    return Chance.createChance(sumOfProbabilities - andOfChance.chance);
  }

  public boolean isWithin(Chance anotherChance, double delta) {
    double lowerBound = this.chance - delta;
    double upperBound = this.chance + delta;
    return isInRange(lowerBound, upperBound, anotherChance.chance);
  }

  private static boolean isInRange(double lowerBound, double upperbound, double number) {
    return lowerBound <= number && upperbound >= number;
  }

  public boolean similar(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Chance chance = (Chance) o;

    return this.isWithin(chance, 0.005);
  }

  @Override
  public String toString() {
    return "Chance{" +
        "chance=" + chance +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Chance chance1 = (Chance) o;

    return Double.compare(chance1.chance, chance) == 0;
  }

  @Override
  public int hashCode() {
    long temp = Double.doubleToLongBits(chance);
    return (int) (temp ^ (temp >>> 32));
  }
}
