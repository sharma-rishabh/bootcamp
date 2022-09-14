package com.tw.step.assignment2.probability;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinTest {

  @Test
  void shouldTellChanceOfGettingATail() {
    Coin coin = new Coin();
    assertEquals(0.5, coin.chanceOf(Face.TAIL));
  }

  @Test
  void shouldTellChanceOfNotGettingATail() {
    Coin coin = new Coin();
    assertEquals(0.5, coin.chanceOfNot(Face.TAIL));
  }
}