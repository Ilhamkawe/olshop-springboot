package com.olshop.olshop.service;

import com.olshop.olshop.dto.reqbody.user.LoginReqBody;
import com.olshop.olshop.service.impl.AuthServiceImpl;

public interface AuthService {
    Object LoginUser(LoginReqBody req);
}
