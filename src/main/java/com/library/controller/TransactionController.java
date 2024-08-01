package com.library.controller;

import com.library.model.Transaction;
import com.library.service.TransactionService;

public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController() {
        transactionService = new TransactionService();
    }

    public void createTransaction(Transaction transaction) {
        transactionService.createTransaction(transaction);
    }
}