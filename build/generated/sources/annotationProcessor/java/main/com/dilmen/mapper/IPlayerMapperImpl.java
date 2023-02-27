package com.dilmen.mapper;

import com.dilmen.dto.request.PlayerLoginRequestDto;
import com.dilmen.dto.request.PlayerRegisterRequestDto;
import com.dilmen.dto.response.PlayerResponseDto;
import com.dilmen.repository.entity.Player;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-27T16:54:02+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class IPlayerMapperImpl implements IPlayerMapper {

    @Override
    public Player playerFromLoginRequestDto(PlayerLoginRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Player.PlayerBuilder<?, ?> player = Player.builder();

        player.username( dto.getUsername() );
        player.password( dto.getPassword() );

        return player.build();
    }

    @Override
    public Player playerFromRegisterRequestDto(PlayerRegisterRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Player.PlayerBuilder<?, ?> player = Player.builder();

        player.username( dto.getUsername() );
        player.firstName( dto.getFirstName() );
        player.lastName( dto.getLastName() );
        player.email( dto.getEmail() );
        player.password( dto.getPassword() );

        return player.build();
    }

    @Override
    public PlayerResponseDto playerResponseDtoFromPlayerLoginRequestDto(PlayerLoginRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        PlayerResponseDto.PlayerResponseDtoBuilder playerResponseDto = PlayerResponseDto.builder();

        playerResponseDto.username( dto.getUsername() );

        return playerResponseDto.build();
    }

    @Override
    public PlayerResponseDto playerResponseDtoFromPlayerRegisterRequestDto(PlayerRegisterRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        PlayerResponseDto.PlayerResponseDtoBuilder playerResponseDto = PlayerResponseDto.builder();

        playerResponseDto.username( dto.getUsername() );

        return playerResponseDto.build();
    }
}
