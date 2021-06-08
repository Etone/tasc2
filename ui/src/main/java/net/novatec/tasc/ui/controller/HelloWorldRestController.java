package net.novatec.tasc.ui.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
public class HelloWorldRestController {

  @GetMapping("/{name}")
  public String helloWorld(@PathVariable(value = "name", required = false) String name) {
    return "Hello, " + name + " !";
  }
}
