package com.olshop.olshop.controller;

import com.olshop.olshop.dto.reqbody.user.RegisterReqBody;
import com.olshop.olshop.dto.reqbody.user.UpdateReqBody;
import com.olshop.olshop.dto.resbody.common.BaseResponse;
import com.olshop.olshop.dto.resbody.common.ResMessageDTO;
import com.olshop.olshop.dto.resbody.user.UserDTO;
import com.olshop.olshop.service.UserService;
import com.olshop.olshop.util.ApiResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/engine")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public @ResponseBody ResponseEntity<BaseResponse<?>> register(@Validated @RequestBody RegisterReqBody req){
        try {
            Object user = userService.register(req);
            return ApiResponseUtil.SuccessHandler(user, "SUKSES");
        }catch (Exception e){
            return ApiResponseUtil.ErrorHandler(e, HttpStatus.NOT_FOUND, "GAGAL");
        }
    }

    @GetMapping("/user/{email}")
    public @ResponseBody ResponseEntity<BaseResponse<?>> getUpdateUser(@PathVariable String email){
        try {
            UserDTO user = userService.getUserDtoByEmail(email);
            return ApiResponseUtil.SuccessHandler(user,"SUKSES");
        }catch(Exception e){
            return ApiResponseUtil.ErrorHandler(e, HttpStatus.NOT_FOUND, "GAGAL");
        }
    }

    @PutMapping("/update/profile/{id}")
    public @ResponseBody ResponseEntity<BaseResponse<?>> update(@PathVariable int id, @Validated @RequestBody UpdateReqBody req){
        try{
            return ApiResponseUtil.SuccessHandler(userService.updateUser(id, req), "SUKSES");
        }catch (Exception e){
            return ApiResponseUtil.ErrorHandler(e, HttpStatus.NOT_FOUND, "GAGAL");
        }
    }
}
