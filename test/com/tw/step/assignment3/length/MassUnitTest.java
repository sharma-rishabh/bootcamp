package com.tw.step.assignment3.length;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MassUnitTest {

  @Test
  void shouldTellRatioOfGallonAndKG() {
    assertEquals(3.78,MassUnit.GALLON.ratio(MassUnit.LITRE));
  }
}