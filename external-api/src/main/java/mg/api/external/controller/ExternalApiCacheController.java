package mg.api.external.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/external-api-cache")
@AllArgsConstructor
public class ExternalApiCacheController {

    @GetMapping("/{}")
    public String getCacheValues() {
        return null;
    }
}
