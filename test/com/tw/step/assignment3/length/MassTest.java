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
}