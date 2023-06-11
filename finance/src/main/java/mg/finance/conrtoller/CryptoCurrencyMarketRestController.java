package mg.finance.conrtoller;

import lombok.AllArgsConstructor;
import mg.finance.dto.CryptoMarketDto;
import mg.finance.service.crypto.CryptoMarketService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/finance/crypto/currencies/market")
@AllArgsConstructor
public class CryptoCurrencyMarketRestController {

//    private final CryptoMarketService cryptoMarketService;
//
//    @GetMapping
//    public CryptoMarketDto getCryptoMarketInfo() {
//        return cryptoMarketService.getCryptoMarketInfo();
//    }
}
