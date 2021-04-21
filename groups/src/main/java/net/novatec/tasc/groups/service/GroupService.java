package net.novatec.tasc.groups.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.novatec.tasc.groups.entity.Group;
import net.novatec.tasc.groups.repository.GroupRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class GroupService {

  private final GroupRepository repository;
  private final MeterRegistry meterRegistry;

  Counter allGroups;

  @PostConstruct
  private void init(){
    allGroups = Counter.builder("groups.all").description("Metric which increments foreach added group").register(meterRegistry);
  }

  public Iterable<Group> getAllGroups(){
    return repository.findAll();
  }

  public Iterable<Group> getByName(String name) {
    return repository.findGroupByName(name);
  }

  public void addGroup(Group group) {
    log.info("Adding new Group: {}", group);
    allGroups.increment();
    repository.save(group);
  }
}
