package com.tw.step.assignment3.length;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

  @Test
  void shouldTellRatioOfKmAndMeter() {
    assertEquals(12,Unit.FEET.ratio(Unit.INCH));
  }
}