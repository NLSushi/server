package ewha.nlsushi.newsum.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public class UnScrapExceptionEntity {
    private String errorCode;
    private String errorMessage;

    @Builder
    public UnScrapExceptionEntity(HttpStatus status, String errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
