package ewha.nlsushi.newsum.exception.Exception;

import ewha.nlsushi.newsum.exception.ExceptionEnum;
import lombok.Getter;

@Getter
public class ScrapArticleException extends IllegalStateException {
    private ExceptionEnum error;
    public ScrapArticleException(ExceptionEnum e){
        super(e.getMessage());
        this.error = e;
    }
}
