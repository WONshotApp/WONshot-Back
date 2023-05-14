package WONshotApp.WONshot.config;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum BaseExceptionStatus {
    /**
     * *User Exception* 1000 ~ 1999
     */
    EMPTY_EMAIL(1001, HttpStatus.BAD_REQUEST, "이메일 값이 비어있습니다."),
    INVALID_EMAIL(1002, HttpStatus.BAD_REQUEST , "이메일 형식이 올바르지 않습니다."),
    EMPTY_NICKNAME(1003, HttpStatus.BAD_REQUEST, "닉네임 값이 비어있습니다."),
    INVALID_NICKNAME(1004, HttpStatus.BAD_REQUEST , "닉네임 형식이 올바르지 않습니다."),
    EMPTY_ID(1005, HttpStatus.BAD_REQUEST, "아이디 값이 비어있습니다."),
    INVALID_ID(1006, HttpStatus.BAD_REQUEST , "아이디 형식이 올바르지 않습니다."),
    EMPTY_PASSWORD(1007, HttpStatus.BAD_REQUEST, "비밀번호 값이 비어있습니다."),
    INVALID_PASSWORD(1008, HttpStatus.BAD_REQUEST , "비밀번호 형식이 올바르지 않습니다."),
    ;



    private final int code;
    private final HttpStatus httpStatus;
    private final String message;

    BaseExceptionStatus(int code, HttpStatus httpStatus, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }
}