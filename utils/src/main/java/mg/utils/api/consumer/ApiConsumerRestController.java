package mg.utils.api.consumer;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/api-consumer")
@AllArgsConstructor
public class ApiConsumerRestController {

    @PostMapping
    public ApiConsumerDto createApiConsumer(RequestBody ApiConsumerDto) {
        return null;
    }
}
