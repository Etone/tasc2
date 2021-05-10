package net.novatec.tasc.event.configuration;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MessagingConfig {

  private static final String CREATE_GROUP_TOPIC = "CREATE_GROUP";

  @Bean
  public Declarables topicBindings() {
    var createGroupQueue = new Queue(CREATE_GROUP_TOPIC + "_QUEUE", false);

    var createGroupExchange = new TopicExchange(CREATE_GROUP_TOPIC);

    return new Declarables(createGroupExchange, createGroupQueue, BindingBuilder.bind(createGroupQueue)
                                                                                .to(createGroupExchange)
                                                                                .with("group.create"));

  }
}
