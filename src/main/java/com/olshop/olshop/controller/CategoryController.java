package com.olshop.olshop.controller;

import com.olshop.olshop.dto.params.CategoryParams;
import com.olshop.olshop.dto.resbody.common.BaseResponse;
import com.olshop.olshop.service.CategoryService;
import com.olshop.olshop.util.ApiResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/engine/product")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/test")
    public @ResponseBody ResponseEntity<BaseResponse<?>> test(){
        try {
            return ApiResponseUtil.SuccessHandler("test", "SUKSES");
        }catch (Exception e){
            return ApiResponseUtil.ErrorHandler(e, HttpStatus.NOT_FOUND, "GAGAL");
        }
    }
    @GetMapping("/category")
    public @ResponseBody ResponseEntity<BaseResponse<?>> index(@RequestParam(name = "id", defaultValue = "0",required = false) Integer id,
                                                               @RequestParam(name = "name", required = false) String name,
                                                               @RequestParam(name = "page", defaultValue = "0",required = false) Integer page,
                                                               @RequestParam(name = "limit",defaultValue = "6", required = false) Integer limit,
                                                               @RequestParam(name = "show_product", defaultValue = "0",required = false) Integer showProduct
                                                               ){
        CategoryParams params = new CategoryParams(id, name, page, limit, showProduct);

        try {
            Object category = categoryService.index(params);
            return ApiResponseUtil.SuccessHandler(category, "Berhasil mengambil data");
        }catch (Exception e) {
            return ApiResponseUtil.ErrorHandler(e, HttpStatus.NOT_FOUND, "GAGAL mengambil data");
        }


    }

}
