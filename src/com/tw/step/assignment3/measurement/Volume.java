package com.tw.step.assignment3.measurement;

import com.tw.step.assignment3.measurement.exception.InvalidLengthException;
import com.tw.step.assignment3.measurement.exception.InvalidVolumeException;

public class Volume {
  private final double quantity;
  private final VolumeUnit unit;

  private Volume(double quantity, VolumeUnit unit) {
    this.quantity = quantity;
    this.unit = unit;
  }

  public static Volume createVolume(double quantity, VolumeUnit unit) {
    if (quantity < 0) {
      throw new InvalidVolumeException(quantity);
    }
    return new Volume(quantity, unit);
  }

  public Volume convertTo(VolumeUnit anotherUnit) {
    double ratio = this.unit.ratio(anotherUnit);
    double equivalentQuantity = this.quantity * ratio;

    return createVolume(equivalentQuantity, anotherUnit);
  }

  public ComparisonResult compare(Volume anotherVolume) {
    Volume volumeInCurrentUnit = anotherVolume.convertTo(this.unit);
    double acceptableDelta = 0.0005;

    if (this.isInRange(volumeInCurrentUnit, acceptableDelta)) {
      return ComparisonResult.EQUAL;
    }

    double difference = this.quantity - volumeInCurrentUnit.quantity;
    if (difference < 0) return ComparisonResult.LESSER_THAN;

    return ComparisonResult.GREATER_THAN;
  }

  public boolean isInRange(Volume anotherVolume, double delta) {
    return Math.abs(this.quantity - anotherVolume.quantity) <= delta;
  }

  public Volume add(Volume anotherVolume) {
    Volume volumeInCurrentUnit = anotherVolume.convertTo(this.unit);
    Volume aggregatedVolume = createVolume(this.quantity + volumeInCurrentUnit.quantity, this.unit);
    VolumeUnit standardOutputUnit = VolumeUnit.getStandardOutputUnit();

    return aggregatedVolume.convertTo(standardOutputUnit);
  }
}
