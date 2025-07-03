package com.gihanz.dtos;

import lombok.*;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserDto extends SuperDto {
    private String username;
    private String password;
    private String email;
}
