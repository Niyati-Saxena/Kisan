import React from 'react';
import DiseaseInfo from './DiseaseInfo';
import SkillInfo from './SkillInfo';
import '../../stylesheets/Knowledge.css';

function KnowledgePage() {
  return (
    <section className="knowledge section">
      <div className="container section-title">
        <h2>KNOWLEDGE HUB</h2>
        <p style = {{fontWeight : 'normal' , color : 'black'}}>Learn about crop diseases and farming techniques</p>
      </div>

      <div className="container">
        <div className="knowledge-subsection">
          <h3>Crop Disease Info</h3>
          <DiseaseInfo />
        </div>

        <div className="knowledge-subsection">
          <h3>Farming Skills & Tips</h3>
          <SkillInfo />
        </div>
      </div>
    </section>
  );
}

export default KnowledgePage;