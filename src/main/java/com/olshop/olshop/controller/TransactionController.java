package com.olshop.olshop.controller;

import com.olshop.olshop.dto.params.ProductParams;
import com.olshop.olshop.dto.params.TransactionParams;
import com.olshop.olshop.dto.resbody.common.BaseResponse;
import com.olshop.olshop.entity.UserEntity;
import com.olshop.olshop.service.TransactionService;
import com.olshop.olshop.util.ApiResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/engine")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
    @GetMapping("/transactions")
    public @ResponseBody ResponseEntity<BaseResponse<?>> index(@RequestParam(name = "id", defaultValue = "0",required = false) Integer id,
                                                               @RequestParam(name = "limit", defaultValue = "0", required = false) Integer limit,
                                                               @RequestParam(name = "status",defaultValue = "", required = false) String status

    ){

        Object securityContext = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("DATA SECURITY CONTEXT"+ securityContext)
        UserEntity authUser = (UserEntity) securityContext;

        TransactionParams params = new TransactionParams(id, limit, authUser.getId(), status);
//
        try {
            Object transaction = transactionService.index(params);
            return ApiResponseUtil.SuccessHandler(transaction, "Berhasil mengambil data");
        }catch (Exception e) {
            return ApiResponseUtil.ErrorHandler(e, HttpStatus.NOT_FOUND, "GAGAL mengambil data");
        }

    }

}
