package com.rocksoft.groovy.mapsort

import com.rocksoft.groovy.mapsort.HighestToLowestComparator
import spock.lang.Specification

class HighestToLowestComparatorSpec extends Specification {

  def "Sorts a map by values in descending order"() {
    setup:
    Map oddsToOne = ["Detroit Lions": 9999999, "Denver Broncos": 3, "Seattle Seahawks": 2, "Minnesota Vikings": 800]
    SortedMap<String, Integer> highestYieldBets = new TreeMap<>(new HighestToLowestComparator(oddsToOne))

    when:
    highestYieldBets.putAll(oddsToOne)

    then:
    highestYieldBets.entrySet().collect { it.key } == ["Detroit Lions", "Minnesota Vikings", "Denver Broncos", "Seattle Seahawks"]
  }
}
