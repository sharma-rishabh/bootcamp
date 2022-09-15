package com.tw.step.assignment3.length;

public class Feet {
  private final double quantity;

  public Feet(double quantity) {

    this.quantity = quantity;
  }

  public Inch toInches() {
    return new Inch(this.quantity * 12);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Feet feet = (Feet) o;

    return Double.compare(feet.quantity, quantity) == 0;
  }

  @Override
  public int hashCode() {
    long temp = Double.doubleToLongBits(quantity);
    return (int) (temp ^ (temp >>> 32));
  }
}
