package com.olshop.olshop.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.olshop.olshop.dto.reqbody.user.RegisterReqBody;
import com.olshop.olshop.dto.resbody.common.ResMessageDTO;
import com.olshop.olshop.entity.UserEntity;
import com.olshop.olshop.enumerate.UserRole;
import com.olshop.olshop.repository.UserRepository;
import com.olshop.olshop.service.UserService;
import com.olshop.olshop.util.PasswordEncoderUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public UserDetailsService userDetailsService() {
        return username -> (UserDetails) userRepository.findByEmail(username)
                .orElseThrow(()->new UsernameNotFoundException("User tidak ditemukan"));
    }

    @Override
    public Object register(RegisterReqBody req) {
        Boolean isEmailExist = userRepository.isEmailExist(req.getEmail());
        if (isEmailExist) {
            return new ResMessageDTO("Email sudah digunakan");
        }

        Boolean isPhoneNumber = userRepository.isPhoneExist(req.getPhoneNumber());
        if (isPhoneNumber) {
            return new ResMessageDTO("Email sudah digunakan");
        }

        req.setPassword(PasswordEncoderUtil.EncodePassword(req.getPassword()));

        try {
//            UserEntity user = objectMapper.convertValue(req, new TypeReference<UserEntity>() {
//            });

            UserEntity user = new UserEntity();
            user.setEmail(req.getEmail());
            user.setPassword(req.getPassword());
            user.setPhoneNumber(req.getPhoneNumber());
            user.setUsername(req.getUsername());
            user.setRole(UserRole.USER);

            user = userRepository.save(user);
            return user;
        } catch (Exception e) {
            return e;
        }


    }
}
