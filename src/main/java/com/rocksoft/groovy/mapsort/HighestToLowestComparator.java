package com.rocksoft.groovy.mapsort;

import java.util.Comparator;
import java.util.Map;

public class HighestToLowestComparator implements Comparator<String> {
  Map<String, Integer> disordered;

  public HighestToLowestComparator(Map<String, Integer> map) {
    this.disordered = map;
  }

  @Override
  public int compare(String string1, String string2) {
    int compare = disordered.get(string1).compareTo(disordered.get(string2));
    return compare * -1;
  }
}
