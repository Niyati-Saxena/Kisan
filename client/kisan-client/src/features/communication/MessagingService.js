import axios from 'axios';

const BASE_URL = '/api/messages';

export const sendMessage = message => axios.post(BASE_URL, message);

export const getMessages = () => axios.get(BASE_URL);