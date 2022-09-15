package com.tw.step.assignment3.length;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MassTest {

  @Test
  void shouldCompareLitreWithGallon() {
    Mass oneGallon = new Mass(1, MassUnit.GALLON);
    Mass oneLitre = new Mass(1, MassUnit.LITRE);
    Mass fourLitres = new Mass(4, MassUnit.LITRE);
    Mass oneGallonInLiters = new Mass(3.78,MassUnit.LITRE);

    assertEquals(0,oneGallon.compare(oneGallonInLiters));
    assertEquals(1,oneGallon.compare(oneLitre));
    assertEquals(-1,oneGallon.compare(fourLitres));
  }

  @Test
  void shouldAddTwoVolumesInLitreAndGiveInLitres() {
    Mass oneLiter = new Mass(1, MassUnit.LITRE);

    Mass actual = oneLiter.add(oneLiter);
    Mass expected = new Mass(2,MassUnit.LITRE);

    assertTrue(expected.isInRange(actual,0.01));
  }

  @Test
  void shouldAddTwoVolumesInGallonsAndGiveInLitres() {
    Mass oneGallon = new Mass(1,MassUnit.GALLON);

    Mass actual = oneGallon.add(oneGallon);
    Mass expected = new Mass(7.56, MassUnit.LITRE);

    assertTrue(expected.isInRange(actual,0.01));
  }

  @Test
  void shouldAddOneGallonWithLitreAndGiveInLitre() {
    Mass oneGallon = new Mass(1,MassUnit.GALLON);
    Mass oneLiter = new Mass(1, MassUnit.LITRE);

    Mass actual = oneLiter.add(oneGallon);
    Mass expected = new Mass(4.78, MassUnit.LITRE);

    assertTrue(expected.isInRange(actual,0.01));
  }
}