package com.example.order.producer;

import com.example.order.model.OrderEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {
    private static final String TOPIC = "orders";

    @Autowired
    private KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public void sendOrder(OrderEvent orderEvent) {
        kafkaTemplate.send(TOPIC, orderEvent.getOrderId(), orderEvent);
        System.out.println("Sent order event: " + orderEvent);
    }
}
