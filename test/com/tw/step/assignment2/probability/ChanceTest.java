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
    assertThrows(InvalidProbabilityException.class, () -> Chance.createChance(2));
  }

  @Test
  void shouldThrowExceptionIfProbabilityIsLessThanOne() {
    assertThrows(InvalidProbabilityException.class, () -> Chance.createChance(-1));
  }

  @Test
  void shouldPerformAndOnGivenChance() throws InvalidProbabilityException {
    Chance tailChance = Chance.createChance(0.5);

    assertTrue(tailChance.and(tailChance).equals(Chance.createChance(0.25)));
  }

  @Test
  void shouldPerformOrOnGivenChance() throws InvalidProbabilityException {
    Chance tailChance = Chance.createChance(0.5);

    assertTrue(tailChance.or(tailChance).equals(Chance.createChance(0.75)));
  }
}

