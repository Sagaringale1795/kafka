package com.bank.kafka.entity;

import com.bank.kafka.model.TransactionEvent;
import jakarta.persistence.*;

@Entity
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;
    private String toAccount;
    private double amount;
    private String transactionType;
    private String aadhaarNumber;
    private String panNumber;

    public TransactionEntity() {}

    public TransactionEntity(TransactionEvent event) {
        this.accountNumber = event.getAccountNumber();
        this.toAccount = event.getToAccount();
        this.amount = event.getAmount();
        this.transactionType = event.getTransactionType();
        this.aadhaarNumber = event.getAadhaarNumber();
        this.panNumber = event.getPanNumber();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

// Getters & Setters
}
