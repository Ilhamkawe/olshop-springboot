package com.olshop.olshop.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.olshop.olshop.dto.params.CategoryParams;
import com.olshop.olshop.dto.reqbody.category.CategoryReqBody;
import com.olshop.olshop.dto.resbody.category.CategoryResBody;
import com.olshop.olshop.entity.CategoryEntity;
import com.olshop.olshop.repository.CategoryRepository;
import com.olshop.olshop.service.CategoryService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Object index(CategoryParams params) {

        try {
            Object category;
            if (params.getId() != 0) {
                    category = categoryRepository.findById(params.getId());
                    if(params.getShowProduct() != 0) {
                        category = categoryRepository.findByIdWithProduct(params.getId());
                        return category;
                    }
                    return objectMapper.convertValue(category, new TypeReference<CategoryResBody>() {
                    });
                }

            if(!params.getName().equals("")) {
                category =  categoryRepository.findByNameIgnoreCase(params.getName());
                if(params.getShowProduct() != 0) {
                    category = categoryRepository.findByNameWithProduct(params.getName());
                    return category;
                }

                return objectMapper.convertValue(category, new TypeReference<CategoryResBody>() {
                });
            }
            category = categoryRepository.findAll();
            if (params.getShowProduct() != 0) {
                return objectMapper.convertValue(category, new TypeReference<List<CategoryResBody>>() {
                });
            }
            return category;
            }catch (Exception e){
                return e;
            }
    }
}
