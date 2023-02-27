package com.dilmen.mapper;

import com.dilmen.dto.request.QuestionCreateRequestDto;
import com.dilmen.dto.response.QuestionResponseDto;
import com.dilmen.repository.entity.Question;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-27T16:54:02+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class IQuestionMapperImpl implements IQuestionMapper {

    @Override
    public Question questionFromQuestionCreateRequestDto(QuestionCreateRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Question.QuestionBuilder<?, ?> question = Question.builder();

        question.imageUrl( dto.getImageUrl() );
        question.fullname( dto.getFullname() );
        question.attribute1( dto.getAttribute1() );
        question.attribute2( dto.getAttribute2() );
        question.attribute3( dto.getAttribute3() );
        question.attribute4( dto.getAttribute4() );
        question.attribute5( dto.getAttribute5() );

        return question.build();
    }

    @Override
    public QuestionResponseDto questionResponseDtofromQuestion(Question question) {
        if ( question == null ) {
            return null;
        }

        QuestionResponseDto.QuestionResponseDtoBuilder questionResponseDto = QuestionResponseDto.builder();

        questionResponseDto.imageUrl( question.getImageUrl() );
        questionResponseDto.fullname( question.getFullname() );
        questionResponseDto.attribute1( question.getAttribute1() );
        questionResponseDto.attribute2( question.getAttribute2() );
        questionResponseDto.attribute3( question.getAttribute3() );
        questionResponseDto.attribute4( question.getAttribute4() );
        questionResponseDto.attribute5( question.getAttribute5() );

        return questionResponseDto.build();
    }
}
