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

  @Test
  void shouldBeAbleToHoldMaxOfThreeGreenBalls() throws MaxCapacityReachedException {
    Bag bag = new Bag();
    MagicBall firstBall = new MagicBall(Color.GREEN);
    MagicBall secondBall = new MagicBall(Color.GREEN);
    MagicBall thirdBall = new MagicBall(Color.GREEN);
    MagicBall fourthBall = new MagicBall(Color.GREEN);

    bag.add(firstBall);
    bag.add(secondBall);
    bag.add(thirdBall);

    assertThrows(MaxCapacityReachedException.class,()-> bag.add(fourthBall));
  }
}