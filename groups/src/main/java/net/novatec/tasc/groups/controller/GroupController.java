package net.novatec.tasc.groups.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.novatec.tasc.groups.entity.Group;
import net.novatec.tasc.groups.service.GroupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/groups")
@Slf4j
@RequiredArgsConstructor
public class GroupController {

  private final GroupService service;

  @GetMapping
  public Iterable<Group> getGroups(){
    log.info("GET Request to getGroups");
    return service.getAllGroups();
  }

  @GetMapping("/{name}")
  public Iterable<Group> getGroupsWithName(@PathVariable(name="name") String name) {
    return service.getByName(name);
  }

  @GetMapping("/add")
  public void addDefaultGroup(){
    var group = new Group();
    group.setDescription("Default Group");
    group.setName("Default");
    service.addGroup(group);
  }
}
