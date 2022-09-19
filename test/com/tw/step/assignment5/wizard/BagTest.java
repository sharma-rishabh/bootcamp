package com.tw.step.assignment5.wizard;

import com.tw.step.assignment5.wizard.exception.MaxCapacityReachedException;
import com.tw.step.assignment5.wizard.exception.NotEnoughGreenBallException;
import com.tw.step.assignment5.wizard.exception.YellowBallGreaterThan40PercentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {

  @Test
  void shouldBeAbleToAddOneBall() throws MaxCapacityReachedException, NotEnoughGreenBallException, YellowBallGreaterThan40PercentException {
    Bag bag = new Bag();

    assertTrue(bag.add(new MagicBall()));
  }

  @Test
  void shouldThrowExceptionWhenUserTriesToAddABallInFullBag() throws MaxCapacityReachedException, NotEnoughGreenBallException, YellowBallGreaterThan40PercentException {
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
  void shouldBeAbleToHoldMaxOfThreeGreenBalls() throws MaxCapacityReachedException, NotEnoughGreenBallException, YellowBallGreaterThan40PercentException {
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

  @Test
  void shouldNotAllowRedBallToBeAddedInEmptyBag() {
    Bag bag = new Bag();
    MagicBall redBall = new MagicBall(Color.RED);

    assertThrows(NotEnoughGreenBallException.class,()->bag.add(redBall));
  }
  @Test
  void shouldNotAllowThreeRedBallsToBeAddedToABagWithOneGreenBall() throws MaxCapacityReachedException, NotEnoughGreenBallException, YellowBallGreaterThan40PercentException {
    Bag bag = new Bag();
    MagicBall greenBall = new MagicBall(Color.GREEN);
    MagicBall firstRedBall = new MagicBall(Color.RED);
    MagicBall secondRedBall = new MagicBall(Color.RED);
    MagicBall thirdRedBall = new MagicBall(Color.RED);

    bag.add(greenBall);
    bag.add(firstRedBall);
    bag.add(secondRedBall);

    assertThrows(NotEnoughGreenBallException.class,()->bag.add(thirdRedBall));
  }

  @Test
  void shouldNotAllowMoreThanFortyPercentYellowBallsOfCurrentOccupancy() {
    Bag bag = new Bag();
    MagicBall yellowBall = new MagicBall(Color.YELLOW);

    assertThrows(YellowBallGreaterThan40PercentException.class,()->bag.add(yellowBall));
  }
}