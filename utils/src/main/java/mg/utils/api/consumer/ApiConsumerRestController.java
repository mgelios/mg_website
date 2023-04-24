package mg.utils.api.consumer;

import lombok.AllArgsConstructor;
import mg.utils.api.consumer.dto.ApiConsumerCreationRequestDto;
import mg.utils.api.consumer.dto.ApiConsumerResponseDto;
import mg.utils.api.consumer.dto.ApiConsumerUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/admin/api-consumer")
public class ApiConsumerRestController {

    private final ApiConsumerService apiConsumerService;
    private final ApiConsumerMapper apiConsumerMapper;

    @GetMapping("/list")
    public List<ApiConsumerResponseDto> getListOfApiConsumers() {
        return apiConsumerService.getListOfApiConsumers().stream()
                .map(apiConsumerMapper::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{uuid}")
    public ApiConsumerResponseDto getApiConsumerByUuid(@PathVariable String uuid) {
        return apiConsumerMapper.mapToResponseDto(apiConsumerService.findByUuid(UUID.fromString(uuid)));
    }

    @PostMapping
    public ApiConsumerResponseDto createApiConsumer(@Valid @RequestBody ApiConsumerCreationRequestDto apiConsumerDto) {
        return apiConsumerMapper.mapToResponseDto(apiConsumerService.createApiConsumer(apiConsumerDto));
    }

    @PutMapping
    public ApiConsumerResponseDto updateApiConsumer(@Valid @RequestBody ApiConsumerUpdateRequestDto apiConsumerDto) {
        return apiConsumerMapper.mapToResponseDto(apiConsumerService.updateApiConsumer(apiConsumerDto));
    }

    @DeleteMapping("/{uuid}")
    public void deleteApiConsumer(@PathVariable String uuid) {
        apiConsumerService.deleteApiConsumer(UUID.fromString(uuid));
    }
}
