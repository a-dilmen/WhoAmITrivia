package com.dilmen.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class PlayerRegisterRequestDto {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String repassword;
    private String email;
}
