import api from '../../services/axiosConfig';

export const getNews = () => api.get('/news');