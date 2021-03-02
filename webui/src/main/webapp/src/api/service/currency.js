import { ApiService } from "../apiService";
import { CurrencyModel } from "../../models/currency/currencyModel";
import { CurrencyConversionModel } from "../../models/currency/currencyConversionModel";
import { CurrencyStatisticsItemModel } from "../../models/currency/currencyStatisticsItemModel";

export const currency = new ApiService(
    '/api/v1/finance/currency',
    request => new CurrencyModel(request),
    response => response
);

export const currencyConversion = new ApiService(
    '/api/v1/finance/conversion',
    request => new CurrencyConversionModel(request),
    response => response
);

export const currencyStatistics = new ApiService(
    '/api/v1/finance/statistics',
    request => new CurrencyStatisticsItemModel(request),
    response => response
);