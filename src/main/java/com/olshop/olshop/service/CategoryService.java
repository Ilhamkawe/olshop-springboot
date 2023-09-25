package com.olshop.olshop.service;

import com.olshop.olshop.dto.params.CategoryParams;
import com.olshop.olshop.dto.reqbody.category.CategoryReqBody;

public interface CategoryService {
    Object index(CategoryParams params);
}
