package ewha.nlsushi.newsum.exception;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public enum ExceptionEnum {

    ID_ALREADY_EXISTS(HttpStatus.BAD_REQUEST,"M001","이미 존재하는 아이디입니다."),
    WRONG_USERID_FOR_SCRAP(HttpStatus.BAD_REQUEST,"S002","존재하지 않는 유저아이디로부터의 요청입니다."),
    WRONG_ARTICLEID_FOR_SCRAP(HttpStatus.BAD_REQUEST,"S003","존재하지 않는 기사 아이디로의 요청입니다."),
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
