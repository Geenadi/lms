package com.library.service;

import com.library.dao.TransactionDAO; 
import com.library.model.Transaction; 

public class TransactionService {
    private final TransactionDAO transactionDAO;

    public TransactionService() {
        transactionDAO = new TransactionDAO();
    }

    public void createTransaction(Transaction transaction) {
        transactionDAO.save(transaction);
    }
}