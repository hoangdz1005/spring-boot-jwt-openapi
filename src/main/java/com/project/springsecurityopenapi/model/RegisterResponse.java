package com.project.springsecurityopenapi.model;

import com.project.springsecurityopenapi.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponse {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String address;
    private String mobileNumber;
    private Role role;
}
