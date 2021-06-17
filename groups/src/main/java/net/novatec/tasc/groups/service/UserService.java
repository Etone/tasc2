package net.novatec.tasc.groups.service;

import lombok.AllArgsConstructor;
import net.novatec.tasc.groups.entity.User;
import net.novatec.tasc.groups.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

  private final UserRepository repo;

  public Iterable<User> getAllUsers() {
    return repo.findAll();
  }

  public void createUser(User user) {
    repo.save(user);
  }
}
