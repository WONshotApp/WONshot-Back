package WONshotApp.WONshot.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static WONshotApp.WONshot.config.BaseResponseStatus.SUCCESS;

@Getter
@AllArgsConstructor
public class BaseResponse<T> {
    private final int code;
    private final HttpStatus httpStatus;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;

    // 요청에 성공한 경우
    public BaseResponse(T result) {
        this.code = SUCCESS.getCode();
        this.httpStatus = SUCCESS.getHttpStatus();
        this.message = SUCCESS.getMessage();
        this.result = result;
    }

    // 요청에 실패한 경우
    public BaseResponse(BaseExceptionStatus status) {
        this.code = status.getCode();
        this.httpStatus = status.getHttpStatus();
        this.message = status.getMessage();
    }
}
