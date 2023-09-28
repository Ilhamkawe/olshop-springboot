package com.olshop.olshop.repository;

import com.olshop.olshop.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer>, JpaSpecificationExecutor<TransactionEntity> {

}
