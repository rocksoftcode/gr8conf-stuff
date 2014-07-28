package com.rocksoft.groovy.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class EndpointCallerJ {

  @Value("${app.endpoint.url}")
  private String endpointUrl;
  @Autowired
  private RestTemplate requester;
  @Value("${app.api.key}")
  private String apiKey;

  public String readData() {
    Map<String, String> options = new HashMap<String, String>();
    options.put("apiKey", apiKey);
    options.put("service", "data");
    return requester.getForObject(endpointUrl, String.class, options);
  }
}