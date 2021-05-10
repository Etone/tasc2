package net.novatec.tasc.event.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageService {

  @RabbitListener(queues = { "CREATE_GROUP_QUEUE" })
  public void receiveCreateGroupMessage(String message) {
    log.info("Created new group {}", message);
  }
}
