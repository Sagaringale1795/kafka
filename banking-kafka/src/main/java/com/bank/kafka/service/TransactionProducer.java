package com.bank.kafka.service;

import com.bank.kafka.model.TransactionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransactionProducer {

    private static final String TOPIC = "transactions";

    @Autowired
    private KafkaTemplate<String, TransactionEvent> kafkaTemplate;

    public void send(TransactionEvent event) {
        kafkaTemplate.send(TOPIC, event);
        System.out.println("📤 Sent to Kafka: " + event.getAccountNumber() + " | " + event.getAmount());
    }
}
