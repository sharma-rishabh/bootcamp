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

  @Test
  void shouldCompareOneInchWithAnotherInch() {
    Inch inch = new Inch(12);
    Inch longerInch = new Inch(14);
    Inch shorterInch = new Inch(10);

    assertEquals(1,inch.compare(shorterInch));
    assertEquals(0,inch.compare(inch));
    assertEquals(-1,inch.compare(longerInch));
  }
}