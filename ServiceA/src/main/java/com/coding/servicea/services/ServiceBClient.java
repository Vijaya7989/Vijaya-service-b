package com.coding.servicea.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.coding.servicea.clients.ServicebClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ServiceBClient {

  private static final Logger LOGGER = LoggerFactory.getLogger(ServiceBClient.class);

  private static final String BASE_URL = "http://localhost:8081/";

  private static final String SERVICE_A = "serviceA";

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private ServicebClient client;

  @CircuitBreaker(name = "${servicea.circuitbreaker}", fallbackMethod = "fallback")
  public String connect(String algo) {
   return client.get();
  }

  @CircuitBreaker(name = "${servicea.circuitbreaker}", fallbackMethod = "fallback")
  public String connectb(String algo) {
   return client.get2();
  }

  protected String fallback(String algo,Throwable e) {
    LOGGER.info("fallbacck");
    return "this is Fallback method for Service A";
  }

}
