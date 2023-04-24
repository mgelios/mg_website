package mg.security.error;

import org.springframework.boot.web.servlet.error.ErrorController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@RestController("/api/v1")
public class MGErrorRestController implements ErrorController {

    private static final String ERROR_PATH = "/api/v1/error";

    //@GetMapping(path = "/error")
    public Object handleError(HttpServletRequest request, HttpServletResponse response) {
        if (response.getStatus() == HttpServletResponse.SC_NOT_FOUND) {
            return new MGErrorResponse("Resource you've requested not found");
        }
        return new MGErrorResponse("error, alarm, алярм");
    }

    public String getErrorPath() {
        return ERROR_PATH;
    }
}
