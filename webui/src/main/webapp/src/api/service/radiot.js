import { ApiService } from "../apiService";
import {RadiotArticleModel} from "../../models/radiot/radiotArticleModel";
import {RadiotPodcastModel} from "../../models/radiot/radiotPodcastModel";

export const radiotArticle = new ApiService(
    '/api/v1/news/radiot',
    response => new RadiotArticleModel(response),
    request => request
);

export const radiotPodcast = new ApiService(
    '/api/v1/podcast/radiot',
    response => new RadiotPodcastModel(response),
    request => request
);
