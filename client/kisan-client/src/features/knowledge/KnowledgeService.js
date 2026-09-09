import api from '../../services/axiosConfig';

export const getDiseases = () => api.get('/knowledge/diseases');
export const getSkills = () => api.get('/knowledge/skills');