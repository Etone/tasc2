package net.novatec.tasc.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui")
public class UiController {

  @GetMapping("/{name}")
  public String helloWorld(@PathVariable(value = "name", required = false) String name, Model model) {
    model.addAttribute("name", name);
    return "helloWorld";
  }
}
