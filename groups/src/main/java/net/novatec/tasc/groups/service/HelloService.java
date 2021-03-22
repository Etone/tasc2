package net.novatec.tasc.groups.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class HelloService {

  private String helloMessage = "Hello, Reutlingen!";
}
