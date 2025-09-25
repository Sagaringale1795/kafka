package com.bank.kafka.controller;

import com.bank.kafka.model.TransactionEvent;
import com.bank.kafka.service.TransactionProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionProducer producer;

    @PostMapping
    public String createTransaction(@RequestBody TransactionEvent event) {
        producer.send(event);
        return "✅ Transaction published to Kafka!";
    }
}
