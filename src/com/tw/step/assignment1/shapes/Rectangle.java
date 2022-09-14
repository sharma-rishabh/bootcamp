package com.tw.step.assignment1.shapes;

public class Rectangle {
  private final double length;
  private final double breadth;

  Rectangle(double length, double breadth) {
    this.length = length;
    this.breadth = breadth;
  }

  public static Rectangle createRectangle(double length, double breadth) {
    return new Rectangle(length, breadth);
  }

  public static Rectangle createSquare(double size) {
    return new Rectangle(size, size);
  }

  public double area() {
    return length * breadth;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Rectangle rectangle = (Rectangle) o;

    if (Double.compare(rectangle.length, length) != 0) return false;
    return Double.compare(rectangle.breadth, breadth) == 0;
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    temp = Double.doubleToLongBits(length);
    result = (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(breadth);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    return result;
  }

  public double perimeter() {
    return 2 * (this.length + this.breadth);
  }
}
