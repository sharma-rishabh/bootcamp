package com.tw.step.assignment3.measurement;

public enum VolumeUnit {
  GALLON(3.78),
  LITRE(1);

  private final double volumeInLitre;

  VolumeUnit(double volumeInLitre) {
    this.volumeInLitre = volumeInLitre;
  }

  public double ratio(VolumeUnit anotherVolumeUnit) {
    return this.volumeInLitre / anotherVolumeUnit.volumeInLitre;
  }

  public static VolumeUnit getStandardOutputUnit() {
    return LITRE;
  }
}
