import axios from 'axios';

const BASE_URL = '/api/knowledge';

export const getDiseases = () => axios.get(`${BASE_URL}/diseases`);
export const getSkills = () => axios.get(`${BASE_URL}/skills`);