package net.novatec.tasc.groups.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.novatec.tasc.groups.entity.ApiGroup;
import net.novatec.tasc.groups.entity.Group;
import net.novatec.tasc.groups.entity.GroupNotFoundException;
import net.novatec.tasc.groups.entity.Sum;
import net.novatec.tasc.groups.service.GroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/groups")
@Slf4j
@RequiredArgsConstructor
public class GroupController {

  private final GroupService service;

  @GetMapping
  public Iterable<Group> getGroups(){
    log.info("GET - getGroups");
    return service.getAllGroups();
  }

  @GetMapping("/{id}")
  public ResponseEntity<ApiGroup> getGroupWithId(@PathVariable(name="id") Integer id){
    log.info("GET - find group with id={}", id);
    try {
      return ResponseEntity.ok(service.getById(id));
    } catch(GroupNotFoundException t){
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public ResponseEntity<Void> addGroup(@RequestBody Group group){
    log.info("POST - Adding new group: {}", group);
    service.addGroup(group);
    return ResponseEntity.ok().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Group> updateGroup(@RequestBody Group newGroup, @PathVariable Integer id){
    log.info("PUT - updating Group with id {}, setting to {}", id, newGroup);

    return ResponseEntity.ok(service.updateGroup(newGroup, id));
  }

  @GetMapping("/sum/{a}/{b}")
  public ResponseEntity<Integer> sumNumbers(@PathVariable("a") int a, @PathVariable("b") int b){
    //return ResponseEntity.ok(sumUp.getA() + sumUp.getB());
    return ResponseEntity.ok(a + b);
  }

}
