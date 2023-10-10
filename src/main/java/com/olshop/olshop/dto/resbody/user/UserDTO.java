package com.olshop.olshop.dto.resbody.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    String email;
    String name;
    String username;
    String password;
    String phoneNumber;
}
