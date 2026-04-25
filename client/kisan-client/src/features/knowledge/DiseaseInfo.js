import React, { useEffect, useState } from 'react';
import { getDiseases } from './KnowledgeService';

function DiseaseInfo() {
  const [diseases, setDiseases] = useState([]);

  useEffect(() => {
    getDiseases().then(res => setDiseases(res.data));
  }, []);

  return (
    <div>
      <ul>
        {diseases.map(d => (
          <li key={d.id}>
            <strong>{d.name}</strong> — {d.symptoms}
            <p>Treatment: {d.treatment}</p>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default DiseaseInfo;