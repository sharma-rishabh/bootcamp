package com.tw.step.assignment3.length;

public class Length {
  private final double quantity;
  private final LengthUnit lengthUnit;

  public Length(double quantity, LengthUnit lengthUnit) {
    this.quantity = quantity;
    this.lengthUnit = lengthUnit;
  }

  public Length convert(Length anotherLength) {
    double ratio = anotherLength.lengthUnit.ratio(this.lengthUnit);
    double equivalentQuantity = ratio * anotherLength.quantity;

    return new Length(equivalentQuantity, this.lengthUnit);
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


}
