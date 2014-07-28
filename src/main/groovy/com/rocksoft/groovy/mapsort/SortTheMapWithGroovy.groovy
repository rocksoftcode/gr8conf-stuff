package com.rocksoft.groovy.mapsort

class SortTheMapWithGroovy {

  static void main(args) {
    Map<String, Integer> stuff = [foo: 3, bar: 1, baz: 9]
    stuff.sort { it.value * -1 }.each {
      println "${it.key}: ${it.value}"
    }
  }
}