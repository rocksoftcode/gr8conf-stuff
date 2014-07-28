package com.rocksoft.groovy.xmlslurper

class ReadSomeXml {
  static final String XML = '''
<funInfo>
    <terribleTeam name="Detroit Lions">We lost 16 games in one season!</terribleTeam>
    <terribleTeam name="Minnesota Twins">We finish last in our division every year!</terribleTeam>
    <terribleTeam name="Minnesota Vikings">4 Super Bowls.  Zero championships</terribleTeam>
    <terribleTeam name="Green Bay Packers">We have the most arrogant fans on the planet!</terribleTeam>
</funInfo>
'''
  static void main(args) {
    def tree = new XmlSlurper().parseText(XML)
    tree.terribleTeam.each { team ->
      println "${team.@name} -> ${team.text()}"
    }
  }
}
