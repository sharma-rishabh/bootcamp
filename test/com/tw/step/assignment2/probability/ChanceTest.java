package com.tw.step.assignment2.probability;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {

  @Test
  void shouldTellProbabilityOfGettingFavourableOutcome() {
    Chance chance = new Chance(0.5);
    assertEquals(chance.getProbability(), 0.5);
  }
}

