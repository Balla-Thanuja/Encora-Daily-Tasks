package com.example.order;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.order.model.OrderEvent;
import com.example.order.producer.OrderProducer;

@Component
public class ProducerRunner implements CommandLineRunner {

    private final OrderProducer producerService;  // <-- Declare the field here

    public ProducerRunner(OrderProducer producerService) {
        this.producerService = producerService;
    }

    @Override
    public void run(String... args) {
        // Create and send a sample OrderEvent with String orderId
        OrderEvent event = new OrderEvent("101", "Mobile Phone", 1);
        producerService.sendOrder(event);
    }
}
