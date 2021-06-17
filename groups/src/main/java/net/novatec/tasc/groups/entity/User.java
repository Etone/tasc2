package net.novatec.tasc.groups.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "myUser")
public class User {
  @Id
  @GeneratedValue
  private Long id;
  private String name;

  @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = Group.class)
  @JoinColumn(name = "group_id")
  private Group subscribed;
}
