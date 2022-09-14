package com.tw.step.assignment1.shapes;

public class Rectangle {
  private final double length;
  private final double breadth;

  public Rectangle(double length, double breadth) {
    this.length = length;
    this.breadth = breadth;
  }

  public double area() {
    return length * breadth;
  }

  public double perimeter() {
    return 2*(this.length+this.breadth);
  }
}
