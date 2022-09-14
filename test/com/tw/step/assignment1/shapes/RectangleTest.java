package com.tw.step.assignment1.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
  @Test
  void shouldCalculateTheAreaOfARectangle() {
    Rectangle rectangle = new Rectangle(4, 4);
    assertEquals(rectangle.area(), 16);
  }

  @Test
  void shouldCalculateTheAreaOfARectangleWithUnequalSides() {
    Rectangle rectangle = new Rectangle(4, 5);
    assertEquals(rectangle.area(), 20);
  }

  @Test
  void shouldCalculateThePerimeterOfaRectangle() {
    Rectangle rectangle = new Rectangle(4, 4);
    assertEquals(rectangle.perimeter(), 16);
  }

  @Test
  void shouldCalculateThePerimeterOfaRectangleWithUnequalSides() {
    Rectangle rectangle = new Rectangle(4, 5);
    assertEquals(rectangle.perimeter(), 18);
  }

  @Test
  void shouldCalculateAreaForDecimalValues() {
    Rectangle rectangle = new Rectangle(4.5, 5.5);
    assertEquals(rectangle.area(), 24.75);
  }

  @Test
  void shouldCalculatePerimeterForDecimalValues() {
    Rectangle rectangle = new Rectangle(4.5, 5.5);
    assertEquals(rectangle.perimeter(), 20);
  }
}