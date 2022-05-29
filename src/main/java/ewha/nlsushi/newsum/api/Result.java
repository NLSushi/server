package ewha.nlsushi.newsum.api;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T> {
    @ApiModelProperty(example ="결과 리스트")
    private T data;
}
