package com.coding.servicea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.servicea.services.ServiceBClient;

@RestController
@RequestMapping("/a")
public class ServiceAController {

  @Autowired
  private ServiceBClient client;

  @GetMapping("/get")
  public String ServiceA() {

    return client.connect("to b");

  }

  @GetMapping("/get/ba")
  public String serviceb() {
    return client.connectb("to ba");
  }

}
