package com.bank.kafka.service;

import com.bank.kafka.entity.TransactionEntity;
import com.bank.kafka.model.TransactionEvent;
import com.bank.kafka.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransactionDBConsumer {

    @Autowired
    private TransactionRepository repository;

    @KafkaListener(topics = "transactions",
            groupId = "db-service",
            containerFactory = "transactionKafkaListenerFactory")
    public void consume(TransactionEvent event) {
        repository.save(new TransactionEntity(event));
        System.out.println("💾 Saved in DB: " + event.getAccountNumber()
                + " | Aadhaar: " + event.getAadhaarNumber()
                + " | PAN: " + event.getPanNumber()
                + " | Amount: " + event.getAmount());
    }
}
