package com.coding.servicea.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "http://localhost:8081", name = "serviceb")
public interface ServicebClient {

  @GetMapping("/b")
  public String get();

  @GetMapping("/ba")
  public String get2();

}
