package com.zkb.springredisstudy.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @KafkaListener(topics = "test",groupId = "test")
    public void receive(ConsumerRecord<String, String> consumerRecord) {
        String value = consumerRecord.value();
        System.out.println(value);
    }

    public void sendMessage() {
        ProducerRecord producerRecord = new ProducerRecord<>("test", "helloWorld1");
        kafkaTemplate.send(producerRecord);
    }
}
