package ewha.nlsushi.newsum.exception;

import ewha.nlsushi.newsum.exception.Entity.ScrapExceptionEntity;
import ewha.nlsushi.newsum.exception.Entity.UserAccountExceptionEntity;
import ewha.nlsushi.newsum.exception.Exception.ScrapArticleException;
import ewha.nlsushi.newsum.exception.Exception.UserAccountException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ApiExceptionAdvice {
    @ExceptionHandler({ScrapArticleException.class})
    public ResponseEntity<ScrapExceptionEntity> exceptionHandler(HttpServletRequest request, final ScrapArticleException e){
        return ResponseEntity.status(e.getError().getHttpStatus())
                .body(ScrapExceptionEntity.builder()
                .errorCode(e.getError().getErrorCode())
                .errorMessage(e.getError().getMessage())
                .build());
    }
    @ExceptionHandler({UserAccountException.class})
    public ResponseEntity<UserAccountExceptionEntity> exceptionHandler(HttpServletRequest request,final UserAccountException e){
        return ResponseEntity.status(e.getError().getHttpStatus())
                .body(UserAccountExceptionEntity.builder()
                .errorCode(e.getError().getErrorCode())
                        .errorMessage(e.getError().getMessage())
                        .build());
    }
}
