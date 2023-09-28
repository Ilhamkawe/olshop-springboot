package com.olshop.olshop.controller;

import com.olshop.olshop.dto.params.CategoryParams;
import com.olshop.olshop.dto.params.ProductParams;
import com.olshop.olshop.dto.resbody.common.BaseResponse;
import com.olshop.olshop.service.ProductService;
import com.olshop.olshop.util.ApiResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/engine")
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping("/products")
    public @ResponseBody ResponseEntity<BaseResponse<?>> index(@RequestParam(name = "id", defaultValue = "0",required = false) Integer id,
                                                               @RequestParam(name = "name", defaultValue = "", required = false) String name,
                                                               @RequestParam(name = "page", defaultValue = "0",required = false) Integer page,
                                                               @RequestParam(name = "limit",defaultValue = "6", required = false) Integer limit,
                                                               @RequestParam(name = "price_from", defaultValue = "0", required = false) Double priceFrom,
                                                               @RequestParam(name = "price_to", defaultValue = "0", required = false) Double priceTo,
                                                               @RequestParam(name = "tags", defaultValue = "",required = false) String tags,
                                                               @RequestParam(name = "category",defaultValue = "", required = false) String category
    ){


        ProductParams params = new ProductParams(id, limit, name, priceFrom, priceTo, tags, category);
//
        try {
            Object product = productService.index(params);
            return ApiResponseUtil.SuccessHandler(product, "Berhasil mengambil data");
        }catch (Exception e) {
            return ApiResponseUtil.ErrorHandler(e, HttpStatus.NOT_FOUND, "GAGAL mengambil data");
        }

    }
}
