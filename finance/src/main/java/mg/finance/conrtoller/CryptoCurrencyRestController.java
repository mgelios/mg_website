package mg.finance.conrtoller;

import lombok.AllArgsConstructor;
import mg.finance.dto.CryptoCurrencyDto;
import mg.finance.dto.CryptoMarketDto;
import mg.finance.service.crypto.CryptoCurrencyService;
import mg.finance.service.crypto.CryptoMarketService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/finance/crypto")
@AllArgsConstructor
public class CryptoCurrencyRestController {

    private final CryptoCurrencyService cryptoCurrencyService;
    private final CryptoMarketService cryptoMarketService;

    @GetMapping("/list")
    public List<CryptoCurrencyDto> getCryptoCurrencies() {
        return cryptoCurrencyService.getCryptoCurrencies();
    }

    @GetMapping("/market")
    public CryptoMarketDto getCryptoMarketInfo() {
        return cryptoMarketService.getCryptoMarketInfo();
    }

}
