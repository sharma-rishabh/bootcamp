package com.tw.step.assignment3.length;

public enum MassUnit {
  GALLON(3.78),
  LITRE(1);

  private final double massInKG;

  MassUnit(double massInKG) {
    this.massInKG = massInKG;
  }

  public double ratio(MassUnit anotherMassUnit) {
    return this.massInKG/ anotherMassUnit.massInKG;
  }

}
