import Info from "../../../components/info/Info";
import WeatherInfo from "../../../components/info/weather/WeatherInfo";
import CurrencyInfo from "../../../components/info/currency/CurrencyInfo";

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
    ]
};
