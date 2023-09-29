package com.olshop.olshop.dto.resbody.auth;


import com.olshop.olshop.enumerate.UserRole;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class LoginResBody {
    private String name;
    private String email;
    private String userName;
    private UserRole role;
    private String token;
}
