import React from 'react';
import '../stylesheets/About.css';

function About() {
  return (
    <section className="about section">
      <div className="container section-title" >
        <h2>ABOUT KISAN</h2>
        <p style = {{fontWeight : 'normal' , color : 'black'}}>Empowering farmers with tools, insights, and real-time support</p>
      </div>

      <div className="container about-content" >
        <p style={{color : 'black'}}>
          <strong>Kisan</strong> is a unified platform designed to help farmers access agricultural products,
          weather forecasts, crop disease knowledge, farming skills, and real-time news. Our goal is to bridge
          the gap between technology and rural empowerment by providing intuitive, reliable, and accessible tools
          for every stage of the farming journey.
        </p>
        <p style={{color : 'black'}}>
          Whether you're browsing the marketplace, checking weather updates, learning new techniques, or staying
          informed with the latest agricultural news — Kisan is built to support your growth.
        </p>
      </div>
    </section>
  );
}

export default About;