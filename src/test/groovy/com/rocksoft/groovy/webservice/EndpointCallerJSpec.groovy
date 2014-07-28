package com.rocksoft.groovy.webservice

import groovy.json.JsonSlurper
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

class EndpointCallerJSpec extends Specification {

  EndpointCallerJ gatherer = new EndpointCallerJ()

  def "Calls endpoint and parses response"() {
    setup:
    gatherer.endpointUrl = 'http://services.target.com/ds'
    gatherer.requester = Mock(RestTemplate)
    gatherer.apiKey = "myKey"

    when:
    String output = gatherer.readData()

    then:
    1 * gatherer.requester.getForObject(gatherer.endpointUrl,
            String, [apiKey: "myKey", service: "data"]) >> '{"response": true}'
    new JsonSlurper().parseText(output).response == true
  }

}
