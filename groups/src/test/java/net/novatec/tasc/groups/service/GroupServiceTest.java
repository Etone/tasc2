package net.novatec.tasc.groups.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

import java.util.Arrays;
import java.util.Collections;
import net.novatec.tasc.groups.entity.Group;
import net.novatec.tasc.groups.repository.GroupRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class GroupServiceTest {

  @Autowired
  GroupService service;

  @MockBean
  GroupRepository repo;

  @Test
  void getByName_ReturnsiterableOfSizeOne(){
    var expected = new Group(1, "Test", "Test");
    given(repo.findGroupByName(anyString())).willReturn(Arrays.asList(expected));

    var actual = service.getByName("Test");
    assertThat(actual, (containsInAnyOrder(expected)));
  }
}
