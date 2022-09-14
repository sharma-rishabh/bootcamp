package com.tw.step.assignment1.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

  @Test
  void shouldTellAreaOfASquare() {
    Square square = new Square(10);
    assertEquals(square.area(),100);
  }

  @Test
  void shouldTellPerimeterOfASquare() {
    Square square = new Square(10);
    assertEquals(square.perimeter(),40);
  }

  @Test
  void shouldCalculateAreaOfAVerySmallSquare() {
    Square square = new Square(0.1);
    assertEquals(0.01,square.area(),0.0001);
  }
}