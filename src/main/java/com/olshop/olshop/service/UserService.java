package com.olshop.olshop.service;

import com.olshop.olshop.dto.reqbody.user.RegisterReqBody;
import com.olshop.olshop.dto.reqbody.user.UpdateReqBody;
import com.olshop.olshop.dto.resbody.user.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService userDetailsService();
    Object register(RegisterReqBody req);
    Object updateUser(int id, UpdateReqBody req);
    UserDTO getUserDtoByEmail(String email);
}
