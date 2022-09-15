package com.tw.step.assignment3.length;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {

  @Test
  void shouldCompareFeetWithInches() {
    Length twelveInch = new Length(12, Unit.INCH);
    Length sixInch = new Length(6, Unit.INCH);
    Length fourteenInch = new Length(14, Unit.INCH);

    Length oneFeet = new Length(1, Unit.FEET);

    assertEquals(0, oneFeet.compare(twelveInch));
    assertEquals(-1, oneFeet.compare(fourteenInch));
    assertEquals(1, oneFeet.compare(sixInch));
  }

  @Test
  void shouldCompareInchesWithCentimeter() {
    Length oneInch = new Length(1, Unit.INCH);
    Length twoCM = new Length(2, Unit.CM);
    Length threeCM = new Length(3, Unit.CM);

    assertEquals(1, oneInch.compare(twoCM));
    assertEquals(-1, oneInch.compare(threeCM));
  }
}