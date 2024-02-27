package mg.api.external.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mg.api.external.dto.ApiConsumerCreationRequestDto;
import mg.api.external.dto.ApiConsumerResponseDto;
import mg.api.external.dto.ApiConsumerUpdateRequestDto;
import mg.api.external.mapper.ApiConsumerMapper;
import mg.api.external.service.ApiConsumerService;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/admin/api-consumer")
@Slf4j
public class ApiConsumerRestController {

    private final ApiConsumerService apiConsumerService;
    private final ApiConsumerMapper apiConsumerMapper;

    @GetMapping("/list")
    public List<ApiConsumerResponseDto> getListOfApiConsumers() {
        log.info("Starting retrieving list of api consumers");
        return apiConsumerService.getListOfApiConsumers().stream()
                .map(apiConsumerMapper::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{uuid}")
    public ApiConsumerResponseDto getApiConsumerByUuid(@PathVariable String uuid) {
        log.info("Starting retrieving api consumer by UUID");
        return apiConsumerMapper.mapToResponseDto(apiConsumerService.findByUuid(UUID.fromString(uuid)));
    }

    @PostMapping
    public ApiConsumerResponseDto createApiConsumer(@Valid @RequestBody ApiConsumerCreationRequestDto apiConsumerDto) {
        log.info("Starting creating api consumer");
        return apiConsumerMapper.mapToResponseDto(apiConsumerService.createApiConsumer(apiConsumerDto));
    }

    @PutMapping
    public ApiConsumerResponseDto updateApiConsumer(@Valid @RequestBody ApiConsumerUpdateRequestDto apiConsumerDto) {
        log.info("Starting updating api consumer");
        return apiConsumerMapper.mapToResponseDto(apiConsumerService.updateApiConsumer(apiConsumerDto));
    }

    @DeleteMapping("/{uuid}")
    public void deleteApiConsumer(@PathVariable String uuid) {
        log.info("Starting deleting api consumer");
        apiConsumerService.deleteApiConsumer(UUID.fromString(uuid));
    }
}
