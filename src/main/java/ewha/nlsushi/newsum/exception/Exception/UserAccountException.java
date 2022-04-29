package ewha.nlsushi.newsum.exception.Exception;

import ewha.nlsushi.newsum.exception.ExceptionEnum;
import lombok.Getter;

@Getter
public class UserAccountException extends IllegalStateException{
    private final ExceptionEnum error;

    public UserAccountException(ExceptionEnum e){
        super(e.getMessage());
        this.error = e;
    }

}
