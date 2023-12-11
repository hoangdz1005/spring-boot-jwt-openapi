package com.project.springsecurityopenapi.mapper;

import com.project.springsecurityopenapi.entity.User;
import com.project.springsecurityopenapi.model.RegisterResponse;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public RegisterResponse mapUserResponseFromUser(User from) {
        RegisterResponse to = new RegisterResponse();
        to.setId(from.getId());
        to.setEmail(from.getEmail());
        to.setAddress(from.getAddress());
        to.setRole(from.getRole());
        to.setLastname(from.getLastname());
        to.setFirstname(from.getFirstname());
        to.setMobileNumber(from.getMobileNumber());
        return to;
    }
}
