package com.tw.step.assignment2.probability;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Coin {
  public static final ArrayList<Face> faces = new ArrayList<>(Arrays.asList(Face.TAIL, Face.HEAD));

  public Coin() {
  }

  public double chanceOf(Face expectedFace) {
    List<Face> collect = faces.stream()
        .filter(face -> face == expectedFace)
        .collect(Collectors.toList());
    return collect.size() / (double) faces.size();
  }

  public double chanceOfNot(Face face) {
    return 1 - chanceOf(face);
  }
}
