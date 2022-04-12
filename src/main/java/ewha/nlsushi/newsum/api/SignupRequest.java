package ewha.nlsushi.newsum.api;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class SignupRequest {

    @NotNull
    String userId;
}

