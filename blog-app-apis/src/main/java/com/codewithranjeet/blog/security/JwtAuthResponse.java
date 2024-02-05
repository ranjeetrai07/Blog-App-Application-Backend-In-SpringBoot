package com.codewithranjeet.blog.security;

import com.codewithranjeet.blog.payloads.UserDto;
import lombok.Data;

@Data
public class JwtAuthResponse {

    private String token;

    private UserDto user;
}
