package com.tw.step.assignment1.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
  @Test
  void shouldCalculateTheAreaOfARectangle() {
    Rectangle rectangle = new Rectangle(4, 4);
    assertEquals(rectangle.area(),16);
  }

}