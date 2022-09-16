package com.tw.step.assignment3.measurement;

import com.tw.step.assignment3.measurement.exception.InvalidLengthException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {
  @Test
  void shouldThrowInvalidLengthExceptionIfLengthIsLessThanZero() {
    assertThrows(InvalidLengthException.class, () -> Length.createLength(-1, LengthUnit.INCH));
  }

  @Test
  void shouldCompareFeetWithInches() {
    Length twelveInch = Length.createLength(12, LengthUnit.INCH);
    Length sixInch = Length.createLength(6, LengthUnit.INCH);
    Length fourteenInch = Length.createLength(14, LengthUnit.INCH);

    Length oneFeet = Length.createLength(1, LengthUnit.FEET);

    assertEquals(ComparisonResult.EQUAL, oneFeet.compare(twelveInch));
    assertEquals(ComparisonResult.LESSER_THAN, oneFeet.compare(fourteenInch));
    assertEquals(ComparisonResult.GREATER_THAN, oneFeet.compare(sixInch));
  }

  @Test
  void shouldCompareInchesWithCentimeter() {
    Length oneInch = Length.createLength(1, LengthUnit.INCH);
    Length twoCM = Length.createLength(2, LengthUnit.CM);
    Length threeCM = Length.createLength(3, LengthUnit.CM);
    Length oneInchInCM = Length.createLength(2.5, LengthUnit.CM);

    assertEquals(ComparisonResult.GREATER_THAN, oneInch.compare(twoCM));
    assertEquals(ComparisonResult.LESSER_THAN, oneInch.compare(threeCM));
    assertEquals(ComparisonResult.EQUAL, oneInch.compare(oneInchInCM));
  }

  @Test
  void shouldTellIfGivenLengthIsWithinRange() {
    Length smallCM = Length.createLength(0.001, LengthUnit.CM);
    Length slightlyLargeCM = Length.createLength(0.002, LengthUnit.CM);

    assertTrue(smallCM.isInRange(slightlyLargeCM, 0.001));
  }

  @Test
  void shouldAddOneInchWithAnother() {
    Length oneInch = Length.createLength(1, LengthUnit.INCH);
    assertEquals(oneInch.add(oneInch), Length.createLength(2, LengthUnit.INCH));
  }

  @Test
  void shouldAddMMAndCMAndGiveInches() {
    Length twoCM = Length.createLength(2, LengthUnit.CM);
    Length fiveMM = Length.createLength(5, LengthUnit.MM);

    Length actual = twoCM.add(fiveMM);
    Length expected = Length.createLength(1, LengthUnit.INCH);

    assertTrue(actual.isInRange(expected, 0.1));
  }

  @Test
  void shouldConvertOneLengthToAnother() {
    Length oneCM = Length.createLength(1, LengthUnit.CM);

    Length expected = Length.createLength(10, LengthUnit.MM);
    Length actual = oneCM.convertTo(LengthUnit.MM);

    assertTrue(actual.isInRange(expected, 0.01));
  }
}