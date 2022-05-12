package com.kafka.server.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "topico.comando.teste", groupId = "group_id")
    public static void consume(String message) throws IOException {
        System.out.println("Mensagem recebida = " + message);
        // DownloadFileS3.downloadFile(message);
    }

}