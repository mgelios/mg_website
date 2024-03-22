import { ApiService } from "@/api/apiService";
import { CryptoCurrencyModel } from "@/models/crypto/cryptoCurrencyModel";
import { CryptoMarket } from "@/models/crypto/cryptoMarket";

export const cryptoCurrency = new ApiService(
    '/api/v1/finance/crypto/currencies',
    request => new CryptoCurrencyModel(request),
    response => response
);

export const cryptoCurrencyMarket = new ApiService(
    '/api/v1/finance/crypto/currencies/market',
    request => new CryptoMarket(request),
    response => response
);
