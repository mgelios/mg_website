package mg.utils.api.consumer;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController("/api/v1/api-consumer")
@AllArgsConstructor
public class ApiConsumerRestController {

    private final ApiConsumerService apiConsumerService;

    @GetMapping("/list")
    public List<ApiConsumerDto> getListOfApiConsumers() {
        return apiConsumerService.getListOfApiConsumers().stream()
                .map(ApiConsumerMapper.INSTANCE::mapToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ApiConsumerDto createApiConsumer(@RequestBody ApiConsumerDto apiConsumerDto) {
        return ApiConsumerMapper.INSTANCE.mapToDto(apiConsumerService.createApiConsumer(apiConsumerDto));
    }

    @PutMapping
    public ApiConsumerDto updateApiConsumer(@RequestBody ApiConsumerDto apiConsumerDto) {
        return ApiConsumerMapper.INSTANCE.mapToDto(apiConsumerService.updateApiConsumer(apiConsumerDto));
    }

    @DeleteMapping("/{uuid}")
    public void deleteApiConsumer(@PathVariable String uuid) {

    }
}
