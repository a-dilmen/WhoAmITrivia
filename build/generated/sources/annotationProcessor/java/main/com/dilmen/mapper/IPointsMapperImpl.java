package com.dilmen.mapper;

import com.dilmen.dto.request.PlayerLoginRequestDto;
import com.dilmen.repository.entity.GameParticipation;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-27T16:54:02+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class IPointsMapperImpl implements IPointsMapper {

    @Override
    public GameParticipation questionFromQuestionCreateRequestDto(PlayerLoginRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        GameParticipation.GameParticipationBuilder<?, ?> gameParticipation = GameParticipation.builder();

        return gameParticipation.build();
    }
}
