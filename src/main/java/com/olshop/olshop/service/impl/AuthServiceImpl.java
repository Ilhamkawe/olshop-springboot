package com.olshop.olshop.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.olshop.olshop.dto.reqbody.user.LoginReqBody;
import com.olshop.olshop.dto.resbody.auth.LoginResBody;
import com.olshop.olshop.dto.resbody.common.ResMessageDTO;
import com.olshop.olshop.entity.UserEntity;
import com.olshop.olshop.repository.UserRepository;
import com.olshop.olshop.service.AuthService;
import com.olshop.olshop.util.JwtAuthUtil;
import com.olshop.olshop.util.PasswordEncoderUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ObjectMapper objectMapper;
    // Fungsi Login
    @Override
    public Object LoginUser(LoginReqBody req){

        UserEntity user = userRepository.getUserByEmail(req.getEmail());

        if (user == null) {
            return new ResMessageDTO("User Tidak Ditemukan");
        }

        if (!PasswordEncoderUtil.matchPassword(req.getPassword(), user.getPassword())){
            return new ResMessageDTO("Password Tidak Sesuai");
        }

        LoginResBody res = objectMapper.convertValue(user, new TypeReference<LoginResBody>() {
        });

        res.setToken(JwtAuthUtil.GenerateToken(user));
        return res;
    }
}
