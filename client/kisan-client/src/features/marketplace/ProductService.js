import api from '../../services/axiosConfig';

export const getProducts = () => api.get('/products');

export const addProduct = product => api.post('/products', product);