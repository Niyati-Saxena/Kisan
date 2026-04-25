import axios from 'axios';

const BASE_URL = '/api/products';

export const getProducts = () => axios.get(BASE_URL);

export const addProduct = product => axios.post(BASE_URL, product);