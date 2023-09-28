package com.olshop.olshop.dto.params;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductParams {
 private int id;
 private int limit;
 private String name;
 private double priceFrom;
 private double priceTo;
 private String tags;
 private String category;
}
