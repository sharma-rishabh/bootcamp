package com.tw.step.assignment5.wizard;

import com.tw.step.assignment5.wizard.exception.MaxCapacityReachedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {

  @Test
  void shouldBeAbleToAddOneBall() throws MaxCapacityReachedException {
    Bag bag = new Bag();

    assertTrue(bag.add(new MagicBall()));
  }

  @Test
  void shouldThrowExceptionWhenUserTriesToAddABallInFullBag() throws MaxCapacityReachedException {
    Bag bag = new Bag();
    bag.add(new MagicBall());
    bag.add(new MagicBall());
    bag.add(new MagicBall());
    bag.add(new MagicBall());
    bag.add(new MagicBall());
    bag.add(new MagicBall());
    bag.add(new MagicBall());
    bag.add(new MagicBall());
    bag.add(new MagicBall());
    bag.add(new MagicBall());
    bag.add(new MagicBall());
    bag.add(new MagicBall());
    assertThrows(MaxCapacityReachedException.class,()->bag.add(new MagicBall()));
  }
}