package net.novatec.tasc.groups.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import net.novatec.tasc.groups.service.GroupService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(GroupController.class)
public class GroupControllerTest {

  @Autowired
  MockMvc mvc;

  @MockBean
  GroupService service;

  @Test
  void getGroupsByName_200() throws Exception {
    given(service.getByName(anyString())).willReturn(Collections.emptyList());

    var response = mvc.perform(get("/groups/{name}", "Test").contentType(MediaType.APPLICATION_JSON))
                      .andExpect(status().isOk())
                      .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                      .andReturn()
                      .getResponse()
                      .getContentAsString();

    assertThat(response, is("[]"));
  }
}
