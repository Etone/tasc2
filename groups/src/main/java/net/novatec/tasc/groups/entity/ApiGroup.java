package net.novatec.tasc.groups.entity;

import java.util.List;
import lombok.Data;

@Data
public class ApiGroup {

  Group group;
  List<Event> events;
}
