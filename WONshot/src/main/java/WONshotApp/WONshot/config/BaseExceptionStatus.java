package WONshotApp.WONshot.config;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum BaseExceptionStatus {
    /* 1000 : user exception */
    EMPTY_EMAIL(1001, HttpStatus.BAD_REQUEST, "이메일이 빈 값 입니다.");


    private final int code;
    private final HttpStatus httpStatus;
    private final String message;

    BaseExceptionStatus(int code, HttpStatus httpStatus, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }
}