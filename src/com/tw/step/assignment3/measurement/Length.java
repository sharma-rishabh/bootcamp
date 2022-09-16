package com.tw.step.assignment3.measurement;

import com.tw.step.assignment3.measurement.exception.InvalidLengthException;

public class Length {
  private final double quantity;
  private final LengthUnit unit;

  private Length(double quantity, LengthUnit unit) {
    this.quantity = quantity;
    this.unit = unit;
  }

  public static Length createLength(double quantity, LengthUnit unit) {
    if (quantity < 0) {
      throw new InvalidLengthException(quantity);
    }
    return new Length(quantity, unit);
  }

  public Length convertTo(LengthUnit anotherUnit) { // unit
    double ratio = this.unit.ratio(anotherUnit);
    double equivalentQuantity = this.quantity * ratio;

    return createLength(equivalentQuantity, anotherUnit);
  }

  public ComparisonResult compare(Length anotherLength) {
    Length lengthInCurrentUnit = anotherLength.convertTo(this.unit);
    double acceptableDelta = 0.0005;

    if (this.isInRange(lengthInCurrentUnit, acceptableDelta)) {
      return ComparisonResult.EQUAL;
    }

    double difference = this.quantity - lengthInCurrentUnit.quantity;
    if (difference < 0) return ComparisonResult.LESSER_THAN;

    return ComparisonResult.GREATER_THAN;
  }

  public boolean isInRange(Length anotherLength, double delta) {
    return Math.abs(this.quantity - anotherLength.quantity) <= delta;
  }

  public Length add(Length anotherLength) {
    Length lengthInCurrentUnit = anotherLength.convertTo(this.unit);
    Length aggregatedLength = createLength(this.quantity + lengthInCurrentUnit.quantity, this.unit);
    LengthUnit standardOutputUnit = LengthUnit.getStanardOutputUnit();

    return aggregatedLength.convertTo(standardOutputUnit);
  }

  @Override
  public String toString() {
    return "Length{" +
        "quantity=" + quantity +
        ", unit=" + unit +
        '}';
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
