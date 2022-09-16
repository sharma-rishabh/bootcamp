package com.tw.step.assignment3.measurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VolumeUnitTest {

  @Test
  void shouldTellRatioOfGallonAndLitre() {
    assertEquals(3.78, VolumeUnit.GALLON.ratio(VolumeUnit.LITRE));
  }
}