package net.novatec.tasc.groups.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.novatec.tasc.groups.entity.User;
import net.novatec.tasc.groups.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Slf4j
public class UserController {

  private final UserService service;

  @GetMapping
  public ResponseEntity<Iterable<User>> getUsers() {
    var users = service.getAllUsers();
    return ResponseEntity.ok(users);
  }

  @PostMapping
  public ResponseEntity<Void> createUser(@RequestBody User user) {
    log.info("create User {}", user);
    service.createUser(user);
    return ResponseEntity.noContent().build();
  }
}
