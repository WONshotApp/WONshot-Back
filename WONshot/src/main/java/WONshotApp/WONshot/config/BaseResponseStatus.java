package WONshotApp.WONshot.config;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum BaseResponseStatus {
    /* ~1000 : success */
    SUCCESS(200, HttpStatus.OK, "요청에 성공하였습니다."),

    /* 1000 : user exception */
    ALREADY_EXIST_USERNAME(1001, HttpStatus.BAD_REQUEST, "이미 존재하는 아이디입니다."),
    WRONG_PASSWORD(1002,HttpStatus.BAD_REQUEST, "비밀번호가 잘못되었습니다.");


    private final int code;
    private final HttpStatus httpStatus;
    private final String message;

    BaseResponseStatus(int code, HttpStatus httpStatus, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }
}