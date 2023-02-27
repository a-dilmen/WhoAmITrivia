package com.dilmen.controller;

import com.dilmen.dto.request.AnswerRequestDto;
import com.dilmen.dto.request.QuestionAnswerRequestDto;
import com.dilmen.dto.response.AnswerResponseDto;
import com.dilmen.dto.response.QuestionResponseDto;
import com.dilmen.exception.ErrorType;
import com.dilmen.exception.WhoAmITriviaException;
import com.dilmen.repository.entity.Game;
import com.dilmen.repository.entity.GameParticipation;
import com.dilmen.repository.entity.Question;
import com.dilmen.service.GameParticipationService;
import com.dilmen.service.GameService;
import com.dilmen.service.PlayerService;
import com.dilmen.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.dilmen.constants.EndPoints.*;

@RestController
@RequestMapping(GAME)
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;
    private final GameParticipationService gameParticipationService;
    private  final PlayerService playerService;
    private final Integer ATTEMPT = 5;

    private final QuestionService questionService;

    @GetMapping(GETQUESTION)
    public ResponseEntity<QuestionResponseDto> getQuestion() {

        QuestionResponseDto question = questionService.findRandomQuestion();
        return ResponseEntity.ok(question);
    }
    //if attempt = 1 create game, gameParticipitation
    //if state is true and game show point from AnswerResponseDto
    @PostMapping(ANSWER)
    public ResponseEntity<AnswerResponseDto> answer(@RequestBody AnswerRequestDto dto) {
        Game game = null;
        GameParticipation gameParticipation = null;
        Integer attempt = dto.getAttempt();
        if (attempt == 1){
            game = gameService.save(new Game().builder()
                    .startTime(System.currentTimeMillis())
                    .build());
            gameParticipation = gameParticipationService.save(new GameParticipation()
                    .builder()
                    .playerId(playerService.findOptionalByUsername(dto.getUsername()).get().getId())
                    .points(0)
                    .build()
            );
        }
        if (attempt>ATTEMPT){
            game.setEndTime(System.currentTimeMillis());
            gameParticipationService.save(gameParticipation);
            gameService.save(game);
            throw new WhoAmITriviaException(ErrorType.NO_MORE_ATTEMPTS_GO_NEXTGAME);
        }
        if (dto.getFullname().equalsIgnoreCase(dto.getUserguess())) {
            game.setEndTime(System.currentTimeMillis());
            gameService.save(game);
            Integer point = 10*(ATTEMPT + 1 - attempt);
            gameParticipation.setPoints(point);
            gameParticipationService.save(gameParticipation);
            return ResponseEntity.ok(AnswerResponseDto.builder()
                    .points(point)
                    .state(true)
                    .build());
        } else return ResponseEntity.ok(AnswerResponseDto.builder()
                .points(0)
                .state(false)
                .attempt(dto.getAttempt()+1)
                .build());
    }




}
