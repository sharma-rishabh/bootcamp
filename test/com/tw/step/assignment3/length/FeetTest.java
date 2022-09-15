package com.tw.step.assignment3.length;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FeetTest {

  @Test
  void shouldTellHowManyInchesItContains() {
    Feet feet = new Feet(2);

    Inch expected = new Inch(24);

    assertTrue(expected.equals(feet.toInches()));
  }
}