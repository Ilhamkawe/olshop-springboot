package com.olshop.olshop.service.impl;

import com.olshop.olshop.dto.params.CategoryParams;
import com.olshop.olshop.dto.reqbody.category.CategoryReqBody;
import com.olshop.olshop.service.CategoryService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Override
    public Object index(CategoryParams params) {
        if (params.getId() == 0) {

        }
        return null;
    }
}
