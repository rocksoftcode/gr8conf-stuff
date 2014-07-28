package com.rocksoft.groovy.mapsort;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortTheMap {

  public static void main(String[] args) {
    Map<String, Integer> playerSalaries = new HashMap<>();
    playerSalaries.put("Kobe Bryant", 23500000);
    playerSalaries.put("LeBron James", 20644400);
    playerSalaries.put("Kevin Love", 15719063);
    playerSalaries.put("Jeremy Lin", 14898938);
    playerSalaries.put("Dwight Howard", 21436271);

    System.out.println("This one isn't sorted:");
    for (String player: playerSalaries.keySet()) {
      System.out.println(player + ": $" + playerSalaries.get(player));
    }

    SortedMap<String, Integer> sortedBySalary = new TreeMap<>(new HighestToLowestComparator(playerSalaries));
    sortedBySalary.putAll(playerSalaries);
    System.out.println("\nBut now it is!");
    for (String player: sortedBySalary.keySet()) {
      System.out.println(player + ": $" + sortedBySalary.get(player));
    }
  }
}
