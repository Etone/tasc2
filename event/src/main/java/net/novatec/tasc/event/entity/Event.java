package net.novatec.tasc.event.entity;

import lombok.Data;

@Data
public class Event {
  String name;
  String description;
  Integer id;
  Integer groupId;
}
