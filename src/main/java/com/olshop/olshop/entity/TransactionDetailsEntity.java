package com.olshop.olshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "transaction_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDetailsEntity {
    private static final long serialVersionUID = -2343243243242432341L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "product_id")
    private int productID;
    @ManyToOne
    @JoinColumn(name = "product_id",insertable = false, updatable = false)
    private ProductEntity product;

    @Column(name = "transaction_id")
    private int transactionID;
    @ManyToOne
    @JoinColumn(name = "transaction_id",insertable = false, updatable = false)
    private TransactionEntity transaction;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}