package com.rocksoft.groovy

class Stuff {

  static def looseTyping() {
    def foo = "foobar"
    println "$foo is a ${foo.class.name}"
  }

  static def closures() {
    def listOfPeople = [
            [name: "Helen", age: 40],
            [name: "Billy", age: 8],
            [name: "James", age: 38],
            [name: "Sam", age: 12],
            [name: "Antonio", age: 31]
    ]
    def nbaOwners = [[name: "Steve Ballmer", netWorth: 2000000000], [name: "Glen Taylor", netWorth: -1000000000]]
    def accounts = [
            [name: "Colette Gugliacci", paid: true, dueDate: new Date()],
            [name: "Tom Gugliotta", paid: false, dueDate: new Date() - 5]]

    def oldPeople = listOfPeople.findAll { person ->
      person.age > 30
    }
    oldPeople.each { println "Old person: ${it.name}" }

    def richGuy = nbaOwners.max { it.netWorth }
    println "\nThis dude is rich: $richGuy.name"

    accounts.findAll { !it.paid && it.dueDate < new Date() }.each {
      println "\nPAST DUE: ${it.name}"
    }
  }

  static def expandoMetaClassExample() {
    String.metaClass.l33t = { delegate.toLowerCase().replaceAll('[aA]', '4').replaceAll('[eE]', '3').replaceAll('[iI]', '1').replaceAll('[oO]', '0') }
  }

  public static void main(String[] args) {
    looseTyping()
    closures()
    expandoMetaClassExample()
    println "\nim leet haxor".l33t()
  }
}
