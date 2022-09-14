package com.tw.step.assignment2.probability;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {
  
  @Test
  void shouldTellProbabilityOfImprobability() {
    Chance chance = new Chance(0.75);

    assertTrue(chance.getImprobability().equals(new Chance(0.25)));
  }
}

