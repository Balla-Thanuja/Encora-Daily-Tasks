package com.example.order.controller;

import com.example.order.model.OrderEvent;
import com.example.order.producer.OrderProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderProducer orderProducer;

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody OrderEvent orderEvent) {
        orderProducer.sendOrder(orderEvent);
        return ResponseEntity.ok("Order sent to Kafka");
    }
}
