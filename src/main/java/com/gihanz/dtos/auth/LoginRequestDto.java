package com.gihanz.dtos.auth;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDto{

    private String username;
    private String password;
}
