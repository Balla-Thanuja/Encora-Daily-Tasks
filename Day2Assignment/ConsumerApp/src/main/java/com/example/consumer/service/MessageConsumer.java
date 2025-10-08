package com.example.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @KafkaListener(topics = "test-topic", groupId = "consumer-group-1")
    public void listen(String message) {
        System.out.println("📥 Received message from Kafka: " + message);
    }
}
