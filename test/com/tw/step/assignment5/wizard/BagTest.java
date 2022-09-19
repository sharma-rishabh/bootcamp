package com.tw.step.assignment5.wizard;

import com.tw.step.assignment5.wizard.exception.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {

  @Test
  void shouldBeAbleToAddOneBall() throws BagException {
    Bag bag = Bag.createBag();
    bag.register(Color.WHITE, magicBalls -> {
    });
    assertTrue(bag.add(new MagicBall()));
  }

  @Test
  void shouldThrowExceptionWhenUserTriesToAddABallInFullBag() throws BagException {
    Bag bag = Bag.createBag();
    bag.register(Color.WHITE, magicBalls -> {
    });

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
    assertThrows(MaxCapacityReachedException.class, () -> bag.add(new MagicBall()));
  }

  @Test
  void shouldBeAbleToHoldMaxOfThreeGreenBalls() throws BagException {
    Bag bag = Bag.createBag();
    bag.register(Color.GREEN, magicBalls -> {
      long numberOfGreenBalls = magicBalls.numberOfBalls(Color.GREEN);
      if (numberOfGreenBalls == 3) {
        throw new MaxCapacityReachedException(Color.GREEN, 3);
      }
    });


    MagicBall firstBall = new MagicBall(Color.GREEN);
    MagicBall secondBall = new MagicBall(Color.GREEN);
    MagicBall thirdBall = new MagicBall(Color.GREEN);
    MagicBall fourthBall = new MagicBall(Color.GREEN);

    bag.add(firstBall);
    bag.add(secondBall);
    bag.add(thirdBall);

    assertThrows(MaxCapacityReachedException.class, () -> bag.add(fourthBall));
  }

  @Test
  void shouldNotAllowRedBallToBeAddedInEmptyBag() {
    Bag bag = Bag.createBag();
    bag.register(Color.RED, magicBalls -> {
      long greenBalls = magicBalls.numberOfBalls(Color.GREEN);
      long redBalls = magicBalls.numberOfBalls(Color.RED);
      boolean canBallBeAdded = redBalls + 1 <= greenBalls * 2;

      if (!canBallBeAdded) {
        throw new NotEnoughGreenBallsException(greenBalls);
      }
    });

    MagicBall redBall = new MagicBall(Color.RED);

    assertThrows(NotEnoughGreenBallsException.class, () -> bag.add(redBall));
  }

  @Test
  void shouldNotAllowThreeRedBallsToBeAddedToABagWithOneGreenBall() throws BagException {
    Bag bag = Bag.createBag();

    bag.register(Color.RED, magicBalls -> {
      long greenBalls = magicBalls.numberOfBalls(Color.GREEN);
      long redBalls = magicBalls.numberOfBalls(Color.RED);
      boolean canBallBeAdded = redBalls + 1 <= greenBalls * 2;

      if (!canBallBeAdded) {
        throw new NotEnoughGreenBallsException(greenBalls);
      }
    });

    bag.register(Color.GREEN, magicBalls -> {
      long numberOfGreenBalls = magicBalls.numberOfBalls(Color.GREEN);
      if (numberOfGreenBalls == 3) {
        throw new MaxCapacityReachedException(Color.GREEN, 3);
      }
    });

    MagicBall greenBall = new MagicBall(Color.GREEN);
    MagicBall firstRedBall = new MagicBall(Color.RED);
    MagicBall secondRedBall = new MagicBall(Color.RED);
    MagicBall thirdRedBall = new MagicBall(Color.RED);

    bag.add(greenBall);
    bag.add(firstRedBall);
    bag.add(secondRedBall);

    assertThrows(NotEnoughGreenBallsException.class, () -> bag.add(thirdRedBall));
  }

  @Test
  void shouldNotAllowMoreThanFortyPercentYellowBallsOfCurrentOccupancy() {
    Bag bag = Bag.createBag();

    bag.register(Color.YELLOW, magicBalls -> {
      int sizeAfterAddition = magicBalls.size() + 1;
      long yellowBallsAfterAddition = magicBalls.numberOfBalls(Color.YELLOW) + 1;
      boolean canBallBeAdded = (double) yellowBallsAfterAddition / sizeAfterAddition <= 0.4;

      if (!canBallBeAdded) {
        throw new YellowBallsGreaterThan40PercentException();
      }
    });

    MagicBall yellowBall = new MagicBall(Color.YELLOW);

    assertThrows(YellowBallsGreaterThan40PercentException.class, () -> bag.add(yellowBall));
  }

  @Test
  void shouldNotAllowBlueBallIfBlackBallIsAlreadyPresentInTheBag() throws BagException {
    Bag bag = Bag.createBag();

    bag.register(Color.BLUE,magicBalls -> {
      boolean canBallBeAdded = magicBalls.numberOfBalls(Color.BLACK) == 0;
      if(!canBallBeAdded){
        throw new BagAlreadyHasBlackBallException();
      }
    });

    bag.register(Color.BLACK,magicBalls -> {
      boolean canBallBeAdded = magicBalls.numberOfBalls(Color.BLUE) == 0;
      if(!canBallBeAdded){
        throw new BagAlreadyHasBlueBallException();
      }
    });

    MagicBall blackBall = new MagicBall(Color.BLACK);
    MagicBall blueBall = new MagicBall(Color.BLUE);

    bag.add(blackBall);

    assertThrows(BagAlreadyHasBlackBallException.class, () -> bag.add(blueBall));
  }

  @Test
  void shouldNotAllowBlackBallIfBlueBallIsAlreadyPresent() throws BagException {
    Bag bag = Bag.createBag();

    bag.register(Color.BLUE,magicBalls -> {
      boolean canBallBeAdded = magicBalls.numberOfBalls(Color.BLACK) == 0;
      if(!canBallBeAdded){
        throw new BagAlreadyHasBlackBallException();
      }
    });

    bag.register(Color.BLACK,magicBalls -> {
      boolean canBallBeAdded = magicBalls.numberOfBalls(Color.BLUE) == 0;
      if(!canBallBeAdded){
        throw new BagAlreadyHasBlueBallException();
      }
    });

    MagicBall blackBall = new MagicBall(Color.BLACK);
    MagicBall blueBall = new MagicBall(Color.BLUE);

    bag.add(blueBall);

    assertThrows(BagAlreadyHasBlueBallException.class, () -> bag.add(blackBall));
  }
}