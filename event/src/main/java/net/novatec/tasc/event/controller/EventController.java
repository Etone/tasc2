package net.novatec.tasc.event.controller;

import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.novatec.tasc.event.entity.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/events")
public class EventController {

  @GetMapping("/{groupId}")
  public ResponseEntity<Iterable<Event>> getEventWithGroupId(@PathVariable(name="groupId") Integer groupId){
    log.info("GET - Find Events for group {}", groupId);
    return ResponseEntity.ok(new ArrayList<>());
  }

}
