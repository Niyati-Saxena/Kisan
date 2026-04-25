import axios from 'axios';
const BASE_URL = '/api/news';

export const getNews = () => axios.get(BASE_URL);