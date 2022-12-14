package com.tw.step.assignment3.measurement;

public enum LengthUnit {
  INCH(0.0000025),
  FEET(0.00003),
  CM(0.000001),
  MM(0.0000001);


  private final double lengthInKm;

  LengthUnit(double lengthInKm) {
    this.lengthInKm = lengthInKm;
  }

  public double ratio(LengthUnit anotherLengthUnit) {
    return this.lengthInKm/ anotherLengthUnit.lengthInKm;
  }

  public static LengthUnit getStanardOutputUnit() {
    return INCH;
  }
}
