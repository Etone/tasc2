package net.novatec.tasc.groups;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Tasc2GroupsApplication {

  public static void main(String[] args) {
    SpringApplication.run(Tasc2GroupsApplication.class, args);
  }

}
