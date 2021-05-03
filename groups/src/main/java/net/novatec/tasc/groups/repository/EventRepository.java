package net.novatec.tasc.groups.repository;

import net.novatec.tasc.groups.entity.Event;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="event", url = "http://localhost:8081/events")
public interface EventRepository {

  @GetMapping("/{id}")
  Iterable<Event> getEventWithGroupId(@PathVariable(name="id") Integer groupId);
}
