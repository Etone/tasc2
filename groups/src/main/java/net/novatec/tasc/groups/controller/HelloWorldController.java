package net.novatec.tasc.groups.controller;

import lombok.AllArgsConstructor;
import net.novatec.tasc.groups.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@AllArgsConstructor
public class HelloWorldController {

  private final HelloService helloService;

  @GetMapping()
  public String hello(){
    return helloService.getHelloMessage();
  }
}
