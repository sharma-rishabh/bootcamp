package com.tw.step.assignment3.length;

public class Length {
  private final double quantity;
  private final LengthUnit unit;

  public Length(double quantity, LengthUnit unit) {
    this.quantity = quantity;
    this.unit = unit;
  }

  public Length convert(Length anotherLength) {
    double ratio = anotherLength.unit.ratio(this.unit);
    double equivalentQuantity = ratio * anotherLength.quantity;

    return new Length(equivalentQuantity, this.unit);
  }

  public int compare(Length anotherLength) {
    Length lengthInCurrentUnit = this.convert(anotherLength);

    if (this.isInRange(lengthInCurrentUnit, 0.0005)) {
      return 0;
    }

    double difference = this.quantity - lengthInCurrentUnit.quantity;
    if (difference < 0) return -1;

    return 1;
  }

  public boolean isInRange(Length anotherLength, double delta) {
    return Math.abs(this.quantity - anotherLength.quantity) <= delta;
  }

  public Length add(Length anotherLength){
    return new Length(this.quantity + anotherLength.quantity, this.unit);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Length length = (Length) o;

    if (Double.compare(length.quantity, quantity) != 0) return false;
    return unit == length.unit;
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    temp = Double.doubleToLongBits(quantity);
    result = (int) (temp ^ (temp >>> 32));
    result = 31 * result + (unit != null ? unit.hashCode() : 0);
    return result;
  }
}
