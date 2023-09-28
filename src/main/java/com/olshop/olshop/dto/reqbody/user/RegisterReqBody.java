package com.olshop.olshop.dto.reqbody.user;

import com.olshop.olshop.enumerate.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterReqBody {
    private String username;
    private String phoneNumber;
    private String email;
    private UserRole role;
    private String password;
}
