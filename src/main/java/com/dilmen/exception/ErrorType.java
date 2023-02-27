package com.dilmen.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {

    BAD_REQUEST_ERROR(1201,"Geçersiz Parametre Girişi Yaptınız",BAD_REQUEST),
    INTERNAL_ERROR(3000,"Sunucuda beklenmeyen hata",INTERNAL_SERVER_ERROR),
    USER_NOT_FOUND(2301,"Aradığınız id ye ait kullanıcı bulunamamıştır",INTERNAL_SERVER_ERROR),
    PLEASE_LOGIN_TO_PLAY(2302,"Oynamak için lütfen giriş yapınız", INTERNAL_SERVER_ERROR),
    NO_MORE_ATTEMPTS_GO_NEXTGAME(2303,"Hakkınız Bitti Sonraki oyuna geçiniz" ,INTERNAL_SERVER_ERROR );
    private int code;
    private String message;
    private HttpStatus httpStatus;
}
