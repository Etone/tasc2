package net.novatec.tasc.groups.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {

  private final RabbitMessagingTemplate template;

  public void sendMessage(String topic, String message) {
    template.convertAndSend(topic, "group.create", message);
  }
}