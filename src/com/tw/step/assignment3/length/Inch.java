package com.tw.step.assignment3.length;

public class Inch {
  private final double quantity;

  public Inch(double quantity) {

    this.quantity = quantity;
  }


  public Feet toFeet() {
    return  new Feet(this.quantity / 12);
  }

  public int compare(Inch anotherInch) {
    double difference = this.quantity - anotherInch.quantity;

    if (difference == 0) return 0;
    if (difference < 1) return -1;

    return 1;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Inch inch = (Inch) o;

    return Double.compare(inch.quantity, quantity) == 0;
  }

  @Override
  public int hashCode() {
    long temp = Double.doubleToLongBits(quantity);
    return (int) (temp ^ (temp >>> 32));
  }
}
