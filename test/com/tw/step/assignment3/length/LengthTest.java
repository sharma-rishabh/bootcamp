package com.tw.step.assignment3.length;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {

  @Test
  void shouldCompareFeetWithInches() {
    Length twelveInch = new Length(12, LengthUnit.INCH);
    Length sixInch = new Length(6, LengthUnit.INCH);
    Length fourteenInch = new Length(14, LengthUnit.INCH);

    Length oneFeet = new Length(1, LengthUnit.FEET);

    assertEquals(0, oneFeet.compare(twelveInch));
    assertEquals(-1, oneFeet.compare(fourteenInch));
    assertEquals(1, oneFeet.compare(sixInch));
  }

  @Test
  void shouldCompareInchesWithCentimeter() {
    Length oneInch = new Length(1, LengthUnit.INCH);
    Length twoCM = new Length(2, LengthUnit.CM);
    Length threeCM = new Length(3, LengthUnit.CM);
    Length oneInchInCM = new Length(2.5, LengthUnit.CM);

    assertEquals(1, oneInch.compare(twoCM));
    assertEquals(-1, oneInch.compare(threeCM));
    assertEquals(0,oneInch.compare(oneInchInCM));
  }

  @Test
  void shouldTellIfGivenLengthIsWithinRange() {
    Length smallCM = new Length(0.001, LengthUnit.CM);
    Length slightlyLargeCM = new Length(0.002, LengthUnit.CM);

    assertTrue(smallCM.isInRange(slightlyLargeCM,0.001));

  }
}