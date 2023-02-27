package com.dilmen.service;

import com.dilmen.dto.request.QuestionCreateRequestDto;
import com.dilmen.dto.response.QuestionResponseDto;
import com.dilmen.mapper.IQuestionMapper;
import com.dilmen.repository.IQuestionRepository;
import com.dilmen.repository.entity.Question;
import com.dilmen.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService extends ServiceManager<Question,Long> {

    private final IQuestionRepository questionRepository;
    public QuestionService(IQuestionRepository questionRepository){
        super(questionRepository);
        this.questionRepository = questionRepository;
    }

    public Boolean createQuestionRequest(QuestionCreateRequestDto dto) {
        Question question = IQuestionMapper.INSTANCE.questionFromQuestionCreateRequestDto(dto);
        questionRepository.save(question);
        return true;
    }

    public QuestionResponseDto findRandomQuestion() {
        Question question = questionRepository.getRandomQuestion();
        return IQuestionMapper.INSTANCE.questionResponseDtofromQuestion(question);
    }
}
