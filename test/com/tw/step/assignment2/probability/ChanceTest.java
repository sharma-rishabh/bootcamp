package com.tw.step.assignment2.probability;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {

  @Test
  void shouldTellProbabilityOfGettingFavourableOutcome() {
    Chance chance = new Chance(2, 1);
    assertEquals(chance.ofGetting(), 0.5);
  }

  @Test
  void shouldTellProbabilityOfNotGettingFavourableOutcome() {
    Chance chance = new Chance(4, 3);
    assertEquals(chance.ofNotGetting(), 0.25);
  }
}

