package com.rocksoft.groovy.webservice;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;

@RunWith(MockitoJUnitRunner.class)
public class EndpointCallerJTest {

  @Mock
  RestTemplate mockGatherer;
  @InjectMocks
  EndpointCallerJ gatherer = new EndpointCallerJ();

  @Test
  public void callsEndpointWithCorrectParameters() {
    String url = "http://test.target.com/blah";
    ReflectionTestUtils.setField(gatherer, "apiKey", "test key");
    ReflectionTestUtils.setField(gatherer, "endpointUrl", url);

    when(mockGatherer.getForObject(eq(url), eq(String.class), (Map) argThat(
            allOf(
                    hasEntry("apiKey", "test key"),
                    hasEntry("service", "data")
            )
    ))).thenReturn("{\"results\": true}");
    Assert.assertEquals("{\"results\": true}", gatherer.readData());

    verify(mockGatherer, times(1)).getForObject(eq(url), eq(String.class),
            (Map) argThat(
                    allOf(
                            hasEntry("apiKey", "test key"),
                            hasEntry("service", "data")
                    )
            )
    );
  }
}
