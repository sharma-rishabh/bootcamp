package com.tw.step.assignment2.probability;

import com.tw.step.assignment2.probability.exception.InvalidProbabilityException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {

  @Test
  void shouldTellComplementOfChance() throws InvalidProbabilityException {
    Chance chance = Chance.createChance(0.75);

    assertTrue(chance.complement().equals(Chance.createChance(0.25)));
  }

  @Test
  void shouldThrowExceptionIfProbabilityIsGreaterThanOne() {
    InvalidProbabilityException error = null;

    try {
      Chance.createChance(2);
    } catch (InvalidProbabilityException e) {
      error = e;
    }

    assertNotNull(error);
  }

  @Test
  void shouldThrowExceptionIfProbabilityIsLessThanOne() {
    InvalidProbabilityException error = null;

    try {
      Chance.createChance(-1);
    } catch (InvalidProbabilityException e) {
      error = e;
    }

    assertNotNull(error);
  }
}

