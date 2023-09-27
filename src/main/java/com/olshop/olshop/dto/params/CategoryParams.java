package com.olshop.olshop.dto.params;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryParams {
    private int id;
    private String name;
    private int page;
    private int limit;
    private int showProduct;
}

