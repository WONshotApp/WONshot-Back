package WONshotApp.WONshot.config;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum BaseExceptionStatus {
    /**
     * *User Exception* 1000 ~ 1999
     */
    EMPTY_EMAIL(1001, HttpStatus.BAD_REQUEST, "이메일을 입력해주세요."),
    INVALID_EMAIL(1002, HttpStatus.BAD_REQUEST , "이메일 형식이 올바르지 않습니다.");



    private final int code;
    private final HttpStatus httpStatus;
    private final String message;

    BaseExceptionStatus(int code, HttpStatus httpStatus, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }
}