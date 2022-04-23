package ewha.nlsushi.newsum.exception;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public enum ExceptionEnum {

    UNSCRAP_UNSCRAPPED_ARTICLE(HttpStatus.BAD_REQUEST,"S001","스크랩하지 않은 기사에 대한 스크랩해제 요청입니다.");

    private final HttpStatus httpStatus;
    private final String errorCode;
    private String message;

    ExceptionEnum(HttpStatus status,String code){
        this.httpStatus = status;
        this.errorCode = code;
    }
    ExceptionEnum(HttpStatus status,String code, String message){
        this.httpStatus = status;
        this.errorCode = code;
        this.message = message;
    }
}
