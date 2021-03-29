package net.novatec.tasc.groups.service;

import lombok.AllArgsConstructor;
import net.novatec.tasc.groups.entity.Group;
import net.novatec.tasc.groups.repository.GroupRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GroupService {

  private final GroupRepository repository;

  public Iterable<Group> getAllGroups(){
    return repository.findAll();
  }

  public Iterable<Group> getByName(String name) {
    return repository.findGroupByName(name);
  }

  public void addGroup(Group group) {
    repository.save(group);
  }
}
