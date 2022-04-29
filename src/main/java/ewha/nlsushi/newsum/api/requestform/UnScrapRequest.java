package ewha.nlsushi.newsum.api.requestform;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnScrapRequest {

    @NotNull
    String userId;
    @NotNull
    Long articleId;
}