package ewha.nlsushi.newsum.exception.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public class ScrapExceptionEntity {
    private final String errorCode;
    private final String errorMessage;

    @Builder
    public ScrapExceptionEntity(HttpStatus status, String errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
