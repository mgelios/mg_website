package mg.security.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class MGErrorResponse {

    @Getter
    @Setter
    private String message;
}
