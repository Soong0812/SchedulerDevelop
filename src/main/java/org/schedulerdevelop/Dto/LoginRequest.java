package org.schedulerdevelop.Dto;

import lombok.Getter;

@Getter
public class LoginRequest {
    private String email;
    private String userName;
    private String password;
}
