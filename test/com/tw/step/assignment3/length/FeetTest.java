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

  @Test
  void shouldBeAbleToCompareFeetWithAnotherFeet() {
    Feet feet = new Feet(2);
    Feet shorterFeet = new Feet(1);
    Feet longerFeet = new Feet(3);

    assertEquals(1,feet.compare(shorterFeet));
    assertEquals(-1,feet.compare(longerFeet));
    assertEquals(0,feet.compare(feet));
  }
}