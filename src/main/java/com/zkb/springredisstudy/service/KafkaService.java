package com.zkb.springredisstudy.service;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @KafkaListener(topics = "test", groupId = "test")
    public void receive(ConsumerRecord<String, String> consumerRecord) {
        String value = consumerRecord.value();
        System.out.println(value);
    }

    public void sendMessage() {
        ProducerRecord producerRecord = new ProducerRecord<>("test", "helloWorld1");
        kafkaTemplate.send(producerRecord);
    }

    public Set<String> getAllTopics() throws ExecutionException, InterruptedException {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "192.168.1.110:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        AdminClient adminClient = AdminClient.create(properties);
        ListTopicsResult listTopicsResult = adminClient.listTopics();
        return listTopicsResult.names().get();
    }
}
