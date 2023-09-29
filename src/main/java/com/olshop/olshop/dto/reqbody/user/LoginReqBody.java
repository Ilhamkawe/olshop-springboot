package com.olshop.olshop.dto.reqbody.user;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginReqBody {
    private String email;
    private String password;
}
