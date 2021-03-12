package com.ecommerce.service;

import com.ecommerce.dto.TransactionDetailsDto;
import com.ecommerce.model.Transaction;

public interface TransactionService  {


    Transaction createTxn(TransactionDetailsDto details);

    Transaction findById(Long id);


}
