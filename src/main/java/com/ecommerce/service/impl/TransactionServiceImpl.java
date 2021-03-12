package com.ecommerce.service.impl;

import com.ecommerce.dto.TransactionDetailsDto;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.model.Transaction;
import com.ecommerce.repository.TransactionRepository;
import com.ecommerce.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.Date;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Transaction createTxn(TransactionDetailsDto details) {
        Transaction txn = new Transaction();
        txn.setTxnDate(new Date());
        txn.setTxnPrice(details.getTotalPrice());
        return this.transactionRepository.save(txn);
    }

    @Override
    @Transactional(readOnly = true)
    public Transaction findById(Long id) throws ResourceNotFoundException {
        return this.transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", id));
    }
}
