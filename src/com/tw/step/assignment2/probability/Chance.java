package com.tw.step.assignment2.probability;

public class Chance {
  private final double probability;

  public Chance(double probability) {
    this.probability = probability;
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

  public Chance getComplement() {
    return new Chance(1 - probability);
  }

}
