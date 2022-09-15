package com.tw.step.assignment3.length;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InchTest {
  @Test
  void shouldConvertFeetToInches() {
    Inch inch = new Inch(12);
    Feet expected = new Feet(1);
    assertTrue(expected.equals(inch.toFeet()));
  }
}