package com.tw.step.assignment3.length;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthUnitTest {

  @Test
  void shouldTellRatioOfKmAndMeter() {
    assertEquals(12, LengthUnit.FEET.ratio(LengthUnit.INCH));
  }
}