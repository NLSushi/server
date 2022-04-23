package ewha.nlsushi.newsum.exception;

import lombok.Getter;

@Getter
public class UnScrapUnscrappedArticleException extends IllegalStateException {
    private ExceptionEnum error;
    public UnScrapUnscrappedArticleException(ExceptionEnum e){
        super(e.getMessage());
        this.error = e;
    }
}
