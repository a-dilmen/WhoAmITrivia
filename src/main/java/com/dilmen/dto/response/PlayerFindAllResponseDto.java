package com.dilmen.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PlayerFindAllResponseDto {
    String username;
    String avatar;
    Long id;
}
