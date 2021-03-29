package net.novatec.tasc.groups.repository;

import net.novatec.tasc.groups.entity.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<Group, Integer> {

  public Iterable<Group> findGroupByName(String name);
}
