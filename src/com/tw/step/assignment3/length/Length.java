package com.tw.step.assignment3.length;

public class Length {
  private final double quantity;
  private final Unit unit;

  public Length(double quantity, Unit unit) {
    this.quantity = quantity;
    this.unit = unit;
  }

  public int compare(Length anotherLength) {
    double ratio = this.unit.ratio(anotherLength.unit);
    double equivalentQuantity = ratio * this.quantity;
    double difference = equivalentQuantity - anotherLength.quantity;

    if (difference == 0) return 0;
    if (difference < 0) return -1;

    return 1;
  }
}
