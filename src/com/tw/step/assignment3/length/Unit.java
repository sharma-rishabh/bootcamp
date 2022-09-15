package com.tw.step.assignment3.length;

public enum Unit {
  INCH(0.0000025),
  FEET(0.00003),
  CM(0.000001),
  MM(0.0000001);


  private final double lengthInKm;

  Unit(double lengthInKm) {
    this.lengthInKm = lengthInKm;
  }

  public double ratio(Unit anotherUnit) {
    return this.lengthInKm/anotherUnit.lengthInKm;
  }
}
