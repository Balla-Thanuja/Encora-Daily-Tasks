package com.example.inventory.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.order.model.OrderEvent;

@Service
public class InventoryConsumer {

    @KafkaListener(topics = "orders", groupId = "inventory-group")
    public void consume(OrderEvent orderEvent) {
        System.out.println("Inventory Service received order: " + orderEvent);
        // Here you can update inventory or any business logic
    }
}
