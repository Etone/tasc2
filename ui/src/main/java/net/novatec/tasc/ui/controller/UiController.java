package net.novatec.tasc.ui.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ui")
@Slf4j
public class UiController {

  @GetMapping("/{name}")
  public String helloWorld(@PathVariable(value = "name", required = false) String name, Model model) {
    model.addAttribute("name", name);
    model.addAttribute("person", new Person("Corvin"));
    return "helloWorld";
  }

  @PostMapping("/process/{name}")
  public String process(@ModelAttribute Person person, @PathVariable("name") String name, Model model) {
    log.info("Person from from: {}, name in url: {}", person, name);
    model.addAttribute("name","");
    return "helloWorld";
  }
}
