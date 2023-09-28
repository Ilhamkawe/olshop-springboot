package com.olshop.olshop.service;

import com.olshop.olshop.dto.reqbody.user.RegisterReqBody;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService userDetailsService();
    Object register(RegisterReqBody req);
}
