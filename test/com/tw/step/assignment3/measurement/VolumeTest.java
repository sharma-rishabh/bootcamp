package com.tw.step.assignment3.measurement;

import com.tw.step.assignment3.measurement.exception.InvalidVolumeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VolumeTest {
  @Test
  void shouldThrowInvalidVolumeExceptionIfVolumeIsLessThanZero() {
    assertThrows(InvalidVolumeException.class, () -> Volume.createVolume(-1, VolumeUnit.LITRE));
  }

  @Test
  void shouldCompareTwoVolumes() {
    Volume oneGallon = Volume.createVolume(1, VolumeUnit.GALLON);
    Volume oneLitre = Volume.createVolume(1, VolumeUnit.LITRE);
    Volume fourLitres = Volume.createVolume(4, VolumeUnit.LITRE);
    Volume oneGallonInLiters = Volume.createVolume(3.78, VolumeUnit.LITRE);

    assertEquals(ComparisonResult.EQUAL, oneGallon.compare(oneGallonInLiters));
    assertEquals(ComparisonResult.GREATER_THAN, oneGallon.compare(oneLitre));
    assertEquals(ComparisonResult.LESSER_THAN, oneGallon.compare(fourLitres));
  }

  @Test
  void shouldAddTwoVolumesInLitreAndGiveInLitres() {
    Volume oneLiter = Volume.createVolume(1, VolumeUnit.LITRE);

    Volume actual = oneLiter.add(oneLiter);
    Volume expected = Volume.createVolume(2, VolumeUnit.LITRE);

    assertTrue(actual.isInRange(expected, 0.01));
  }

  @Test
  void shouldAddTwoVolumesInGallonsAndGiveInLitres() {
    Volume oneGallon = Volume.createVolume(1, VolumeUnit.GALLON);

    Volume actual = oneGallon.add(oneGallon);
    Volume expected = Volume.createVolume(7.56, VolumeUnit.LITRE);

    assertTrue(actual.isInRange(expected, 0.01));
  }

  @Test
  void shouldAddGallonWithLitreAndGiveInLitre() {
    Volume oneGallon = Volume.createVolume(1, VolumeUnit.GALLON);
    Volume oneLiter = Volume.createVolume(1, VolumeUnit.LITRE);

    Volume actual = oneLiter.add(oneGallon);
    Volume expected = Volume.createVolume(4.78, VolumeUnit.LITRE);

    assertTrue(actual.isInRange(expected, 0.01));
  }

  @Test
  void shouldConvertFromOneVolumeToAnother() {
    Volume oneGallon = Volume.createVolume(1, VolumeUnit.GALLON);

    Volume expected = Volume.createVolume(3.78, VolumeUnit.LITRE);
    Volume actual = oneGallon.convertTo(VolumeUnit.LITRE);

    assertTrue(actual.isInRange(expected, 0.01));
  }
}