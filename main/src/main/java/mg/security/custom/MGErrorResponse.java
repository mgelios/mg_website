package mg.security.custom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class MGErrorResponse {

    @Getter
    @Setter
    private String message;
}
