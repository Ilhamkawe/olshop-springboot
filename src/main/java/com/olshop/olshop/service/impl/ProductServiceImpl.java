package com.olshop.olshop.service.impl;

import com.olshop.olshop.dto.params.ProductParams;
import com.olshop.olshop.entity.ProductEntity;
import com.olshop.olshop.repository.ProductRepository;
import com.olshop.olshop.service.ProductService;
import com.olshop.olshop.util.SpecificationUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Object index(ProductParams params) {
        Specification<ProductEntity> prodSpec = SpecificationUtil.buildProductSpecification(params);
        return productRepository.findAll(prodSpec);
    }
}
