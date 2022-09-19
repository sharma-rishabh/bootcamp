package com.tw.step.assignment5.wizard;

import com.tw.step.assignment5.wizard.exception.BagException;

import java.util.HashSet;

public interface BallAdditionValidation {
  void validateBall(MagicBalls magicBalls) throws BagException;
}
