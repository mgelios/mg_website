import Info from "../../../components/info/Info";
import WeatherInfo from "../../../components/info/weather/WeatherInfo";
import CurrencyInfo from "../../../components/info/currency/CurrencyInfo";
import CryptoCurrencies from "../../../components/crypto/CryptoCurrencies";

import { pages } from "../pages";

export const infoRoutes = {
    path: '/info',
    name: pages.Info.Main,
    component: Info,
    children: [
        {
            path: 'weather',
            name: pages.Info.Weather,
            component: WeatherInfo
        },
        {
            path: 'currency',
            name: pages.Info.Currency,
            component: CurrencyInfo
        },
        {
            path: 'crypto',
            name: pages.Info.Crypto,
            component: CryptoCurrencies
        }
    ]
};
