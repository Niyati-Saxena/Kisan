import longHero from '../../img/img_long_5.jpg';
import './WhyChooseUs.css';

export default function WhyChooseUs() {
  return (
<section id="about" className="why-choose section">
  <div className="container">
    <div className="row align-items-center">
      <div className="col-lg-6">
        <img src={longHero} alt="Why Choose Us" className="img-fluid shadow" />
      </div>
      <div className="col-lg-6">
       
        <h2 className="section-title" style = {{color : 'white'}}>More than <strong>50 years experience</strong> in agriculture</h2>
        <p className="section-description">
          We provide tools, insights, and support to help farmers grow smarter, safer, and more sustainably.
        </p>

        <div className="feature-list">
          <div className="feature-item">
            <i className="bi bi-cloud-rain feature-icon"></i>
            <div>
              <h4>Fresh Reach Soil</h4>
              <p>Learn how to farm better.</p>
            </div>
          </div>
          <div className="feature-item">
            <i className="bi bi-tools feature-icon"></i>
            <div>
              <h4>Low Impact Tools</h4>
              <p>Learn how to farm smarter.</p>
            </div>
          </div>
          <div className="feature-item">
            <i className="bi bi-shield-check feature-icon"></i>
            <div>
              <h4>Safe Steps</h4>
              <p>Learn how to farm safer.</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
  );
}