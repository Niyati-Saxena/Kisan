import React, { useEffect, useState } from 'react';
import { getSkills } from './KnowledgeService';

function SkillInfo() {
  const [skills, setSkills] = useState([]);

  useEffect(() => {
    getSkills().then(res => setSkills(res.data));
  }, []);

  return (
    <div>
     
      <ul>
        {skills.map(s => (
          <li key={s.id}>
            <strong>{s.title}</strong>
            <p>{s.description}</p>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default SkillInfo;