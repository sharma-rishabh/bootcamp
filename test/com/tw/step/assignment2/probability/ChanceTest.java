package com.tw.step.assignment2.probability;

import com.tw.step.assignment2.probability.exception.InvalidProbabilityException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {

  @Test
  void shouldTellComplementOfChance() throws InvalidProbabilityException {
    Chance chance = Chance.createChance(0.75);

    assertEquals(chance.complement(), Chance.createChance(0.25));
  }

  @Test
  void shouldThrowExceptionIfProbabilityIsGreaterThanOne() {
    assertThrows(InvalidProbabilityException.class, () -> Chance.createChance(2));
  }

  @Test
  void shouldThrowExceptionIfProbabilityIsLessThanZero() {
    assertThrows(InvalidProbabilityException.class, () -> Chance.createChance(-1));
  }

  @Test
  void shouldPerformAndOnGivenChance() throws InvalidProbabilityException {
    Chance tailChance = Chance.createChance(0.5);

    assertEquals(tailChance.and(tailChance), Chance.createChance(0.25));
  }

  @Test
  void shouldPerformOrOnGivenChance() throws InvalidProbabilityException {
    Chance chanceOfGettingOne = Chance.createChance(1 / 6.0);
    Chance chanceOfGettingTwo = Chance.createChance(1 / 6.0);

    assertTrue(chanceOfGettingOne.or(chanceOfGettingTwo).similar(Chance.createChance(0.305)));
  }

  @Test
  void shouldCreateValidInstanceOfChance() throws InvalidProbabilityException {
    Chance firstChance = Chance.createChance(0.5);
    Chance secondChance = Chance.createChance(0.5);

    assertEquals(firstChance, secondChance);
  }

  @Test
  void shouldTellGivenChanceIsWithinGivenDelta() throws InvalidProbabilityException {
    Chance chance1 = Chance.createChance(0.5);
    Chance chance2 = Chance.createChance(0.508);

    assertTrue(chance2.isWithin(chance1, 0.05));
    assertFalse(chance2.isWithin(chance1, 0.005));

  }
}

