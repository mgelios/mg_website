import { types } from './types';
import { radiotPodcast } from "../../../api/service/radiot";

export const actions = Object.freeze({
    fetchPodcasts,
});

async function fetchPodcasts({ commit }) {
    const podcasts = await radiotPodcast.getList();
    commit(types.SET_PODCASTS, podcasts);
}