package com.project.springsecurityopenapi.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RefreshTokenResponse {
    private String accessToken;
}
