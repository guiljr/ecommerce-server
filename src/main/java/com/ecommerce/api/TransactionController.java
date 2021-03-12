package com.ecommerce.api;

import com.ecommerce.dto.TransactionDetailsDto;
import com.ecommerce.model.Transaction;
import com.ecommerce.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/txn")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping
    public Transaction createTxn(@Valid @RequestBody final TransactionDetailsDto details) {
        return this.transactionService.createTxn(details);
    }

}
