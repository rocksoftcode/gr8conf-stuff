package com.rocksoft.groovy.xmlandjson

import groovy.json.JsonSlurper

class ReadSomeJson {
  static final String JSON = '''
{
  "worstTeams":
  [
  {"name": "Detroit Lions", "reason": "This team went 0-16 a few years back.  They have some of the best players in the NFL and continue to lose" },
  {"name": "Minnesota Twins", "reason": "Perennial basement dweller of late.  Paper champion of old." },
  {"name": "Minnesota Vikings", "reason": "4 Super Bowl appearances.  No wins" },
  {"name": "Green Bay Packers", "reason": "Arrogant fans.  What have the Pack done for you lately?" }
  ]
}
'''

  static void main(args) {
    new JsonSlurper().parseText(JSON).worstTeams.each { team ->
      println "${team.name} -> ${team.reason}"
    }
  }
}
