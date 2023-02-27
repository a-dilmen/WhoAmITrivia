package com.dilmen.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PlayerLoginRequestDto {
    String username;
    String password;
}
