import Info from "../../components/info/Info";
import WeatherInfo from "../../components/info/weather/WeatherInfo";
import CurrencyInfo from "../../components/info/currency/CurrencyInfo";
import CryptoInfo from "../../components/info/crypto/CryptoInfo";
import RadiotNewsInfo from "../../components/info/radiot/RadiotNewsInfo";
import RadiotPodcastsInfo from "../../components/info/radiot/RadiotPodcastsInfo";

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
            component: CryptoInfo
        },
        {
            path: 'radiot/news',
            name: pages.Info.RadiotNews,
            component: RadiotNewsInfo
        },
        {
            path: 'radiot/podcasts',
            name: pages.Info.RadiotPodcasts,
            component: RadiotPodcastsInfo
        }
    ]
};
