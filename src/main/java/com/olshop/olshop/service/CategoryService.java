package com.olshop.olshop.service;

import com.olshop.olshop.dto.params.CategoryParams;
import com.olshop.olshop.dto.reqbody.category.CategoryReqBody;
import com.olshop.olshop.entity.CategoryEntity;

public interface CategoryService {
    Object index(CategoryParams params);
}
