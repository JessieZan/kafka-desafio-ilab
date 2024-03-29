package com.kafka.server.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

  @KafkaListener(topics = "topico.comando.teste", groupId = "group_id")
  public void consume(String message) {
    System.out.println("Mensagem recebida = " + message);
  }
    
}