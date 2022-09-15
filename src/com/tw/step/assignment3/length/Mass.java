package com.tw.step.assignment3.length;

public class Mass {
  private final double quantity;
  private final MassUnit unit;

  public Mass(double quantity, MassUnit unit) {
    this.quantity = quantity;
    this.unit = unit;
  }

  public Mass convert(Mass anotherMass) {
    double ratio = anotherMass.unit.ratio(this.unit);
    double equivalentQuantity = ratio * anotherMass.quantity;

    return new Mass(equivalentQuantity, this.unit);
  }

  public int compare(Mass anotherMass) {
    Mass massInCurrentUnit = this.convert(anotherMass);

    if (this.isInRange(massInCurrentUnit, 0.0005)) {
      return 0;
    }

    double difference = this.quantity - massInCurrentUnit.quantity;
    if (difference < 0) return -1;

    return 1;
  }

  public boolean isInRange(Mass anotherMass, double delta) {
    return Math.abs(this.quantity - anotherMass.quantity) <= delta;
  }

  public Mass add(Mass anotherMass) {
    Mass massInCurrentUnit = this.convert(anotherMass);

    Mass aggregatedLength = new Mass(this.quantity + massInCurrentUnit.quantity, this.unit);
    Mass litre = new Mass(1,MassUnit.LITRE);

    return litre.convert(aggregatedLength);
  }
}
