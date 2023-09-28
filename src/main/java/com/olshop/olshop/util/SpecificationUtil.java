package com.olshop.olshop.util;

import com.olshop.olshop.dto.params.ProductParams;
import com.olshop.olshop.dto.params.TransactionParams;
import com.olshop.olshop.entity.CategoryEntity;
import com.olshop.olshop.entity.ProductEntity;
import com.olshop.olshop.entity.TransactionEntity;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class SpecificationUtil {

    public static Specification<TransactionEntity> buildTransactionSpecification(TransactionParams params) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("userId"), params.getUserId() ));

            if (params.getId() != 0) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("id"), params.getId() ));
            }

            if (!params.getStatus().equals("")) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("status"), params.getStatus()));
            }

            return predicate;
        };
    }
    public static Specification<ProductEntity> buildProductSpecification(ProductParams params) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (params.getId() != 0){
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("id"), params.getId() ));
            }

            if (!params.getName().equals("")) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("name"), params.getName()));
            }

            if (params.getPriceFrom() != 0) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("price"), params.getPriceFrom()));
            }

            if (params.getPriceTo() != 0) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(root.get("price"), params.getPriceTo()));
            }

            if (!params.getTags().equals("")) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("tags"), params.getTags()));
            }

            if (!params.getCategory().equals("")) {
                Join<ProductEntity, CategoryEntity> categoryJoin = root.join("category");

                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(criteriaBuilder.lower(categoryJoin.get("name")), params.getCategory().toLowerCase()));
            }


            return predicate;
        };
    }
}
