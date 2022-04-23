package ewha.nlsushi.newsum.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ApiExceptionAdvice {
    @ExceptionHandler({UnScrapUnscrappedArticleException.class})
    public ResponseEntity<UnScrapExceptionEntity> exceptionHandler(HttpServletRequest request, final UnScrapUnscrappedArticleException e){
        return ResponseEntity.status(e.getError().getHttpStatus())
                .body(UnScrapExceptionEntity.builder()
                .errorCode(e.getError().getErrorCode())
                .errorMessage(e.getError().getMessage())
                .build());
    }
}
