package net.novatec.tasc.groups.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.novatec.tasc.groups.entity.ApiGroup;
import net.novatec.tasc.groups.entity.Event;
import net.novatec.tasc.groups.entity.Group;
import net.novatec.tasc.groups.entity.GroupNotFoundException;
import net.novatec.tasc.groups.repository.EventRepository;
import net.novatec.tasc.groups.repository.GroupRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class GroupService {

  private final GroupRepository repository;
  private final MeterRegistry meterRegistry;
  private final EventRepository eventRepository;

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
    log.debug("Adding new Group: {}", group);
    allGroups.increment();
    repository.save(group);
  }

  public ApiGroup getById(Integer id) throws GroupNotFoundException {
    var entityGroup =  repository.findById(id).orElseThrow(GroupNotFoundException::new);
    var apiGroup = new ApiGroup();

    apiGroup.setGroup(entityGroup);

    var events = new ArrayList<Event>();
    eventRepository.getEventWithGroupId(id).forEach(events::add);
    apiGroup.setEvents(events);

    return apiGroup;
  }

  public Group updateGroup(Group newGroup, Integer id) {
    newGroup.setId(id);
    return repository.save(newGroup);
  }
}
