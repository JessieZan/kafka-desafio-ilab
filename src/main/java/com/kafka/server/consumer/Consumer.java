package com.kafka.server.consumer;

import com.kafka.server.service.ISalvarCsv;
import com.kafka.server.utilitarios.DownloadFileS3;
import org.apache.kafka.clients.producer.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.io.IOException;

    @Service
    public class Consumer {

        // @Autowired
        // private ISalvarCsv serviceCsv;

        private final Logger logger = LoggerFactory.getLogger(Producer.class);

        @KafkaListener(topics = "topico.comando.teste", groupId = "group_id")
        public void consume(String message) throws IOException {
            logger.info(String.format("#### -> File name -> %s", message));
            DownloadFileS3.downloadFile(message);
            String endereco = "" + message ;
            // serviceCsv.salvarCsv(endereco);
        }
    }

