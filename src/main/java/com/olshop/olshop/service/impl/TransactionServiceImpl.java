package com.olshop.olshop.service.impl;

import com.olshop.olshop.dto.params.TransactionParams;
import com.olshop.olshop.entity.TransactionEntity;
import com.olshop.olshop.repository.TransactionRepository;
import com.olshop.olshop.service.TransactionService;
import com.olshop.olshop.util.SpecificationUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Object index(TransactionParams params) {
        Specification<TransactionEntity> transSpec = SpecificationUtil.buildTransactionSpecification(params);
        List<TransactionEntity> transactions = transactionRepository.findAll(transSpec);
        return transactions;
    }
}
