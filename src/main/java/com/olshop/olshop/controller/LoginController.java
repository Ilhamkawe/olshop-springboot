package com.olshop.olshop.controller;

import com.olshop.olshop.dto.reqbody.user.LoginReqBody;
import com.olshop.olshop.dto.reqbody.user.RegisterReqBody;
import com.olshop.olshop.dto.resbody.common.BaseResponse;
import com.olshop.olshop.service.AuthService;
import com.olshop.olshop.service.UserService;
import com.olshop.olshop.util.ApiResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("api/v1/engine/auth")
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public @ResponseBody ResponseEntity<BaseResponse<?>> login(@Validated @RequestBody LoginReqBody req){
        try {
            Object data = authService.LoginUser(req);
            return ApiResponseUtil.SuccessHandler(data, "BERHASIL");
        }catch(Exception e){
            return ApiResponseUtil.ErrorHandler(e, HttpStatus.NOT_FOUND, "Gagal");
        }
    }

    @PostMapping("/register")
    public @ResponseBody ResponseEntity<BaseResponse<?>> register(@Validated @RequestBody RegisterReqBody req){
        try {
            Object user = userService.register(req);
            return ApiResponseUtil.SuccessHandler(user, "SUKSES");
        }catch (Exception e){
            return ApiResponseUtil.ErrorHandler(e, HttpStatus.NOT_FOUND, "GAGAL");
        }
    }
}
