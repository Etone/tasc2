package net.novatec.tasc.groups.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.novatec.tasc.groups.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@AllArgsConstructor
@Slf4j
public class HelloWorldController {

  private final HelloService helloService;

  @GetMapping()
  public String hello(){
    log.info("Everyone says hello to me");
    return helloService.getHelloMessage();
  }
}
