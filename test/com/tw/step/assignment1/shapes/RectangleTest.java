package com.tw.step.assignment1.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
  @Test
  void shouldCalculateTheAreaOfARectangle() {
    Rectangle rectangle1 = Rectangle.createRectangle(4, 4);
    Rectangle rectangle2 = Rectangle.createRectangle(4.5, 5.5);

    assertEquals(16, rectangle1.area());
    assertEquals(24.75, rectangle2.area());
  }

  @Test
  void shouldCalculateThePerimeterOfaRectangle() {
    Rectangle rectangle1 = Rectangle.createRectangle(4, 4);
    Rectangle rectangle2 = Rectangle.createRectangle(4.2, 4.2);

    assertEquals(16, rectangle1.perimeter());
    assertEquals(16.8, rectangle2.perimeter());
  }

  @Test
  void shouldCreateSquareOfGivenSize() {
    Rectangle square = Rectangle.createSquare(2);
    Rectangle rectangleWithSameSides = Rectangle.createRectangle(2, 2);

    assertEquals(square, rectangleWithSameSides);
  }

  @Test
  void shouldCreateRectangleOfGivenSides() {
    Rectangle rectangle = Rectangle.createRectangle(2, 4);
    Rectangle sameRectangle = new Rectangle(2, 4);

    assertEquals(rectangle, sameRectangle);
  }
}