import React from 'react';
import { Link } from 'react-router-dom';

function Home() {
  return (
    <>
      {/* Page Title Section */}
      <section className="page-title" style={{ backgroundImage: 'url(/assets/images/farm-banner.jpg)' }}>
        <div className="container">
          <h1>Welcome to Kisan</h1>
          <div className="breadcrumbs">
            <ol>
              <li>Home</li>
              <li>Empowering Farmers</li>
            </ol>
          </div>
        </div>
      </section>

      {/* Hero Section */}
      <section className="section light-background">
        <div className="container">
          <div className="section-title">
            <h2>Our Mission</h2>
            <p>Empowering agriculture through technology</p>
          </div>

          <div className="row">
            {/* Weather Card */}
            <div className="col-md-4">
              <div className="card p-4 text-center">
                <div className="service-item-icon mb-3">
                  <img src="./assets/images/weather-icon.png" alt="Weather Icon" width="50" />
                </div>
                <h4 className="text-success">Real-time Weather</h4>
                <p>Stay updated with accurate forecasts tailored for your region.</p>
                <Link to="/weather" className="btn btn-get-started">Check Forecast</Link>
              </div>
            </div>

            {/* Marketplace Card */}
            <div className="col-md-4">
              <div className="card p-4 text-center">
                <div className="service-item-icon mb-3">
                  <img src="/assets/images/market-icon.png" alt="Marketplace Icon" width="50" />
                </div>
                <h4 className="text-success">Marketplace</h4>
                <p>Buy and sell agricultural products with ease and transparency.</p>
                <Link to="/marketplace" className="btn btn-get-started">Explore Market</Link>
              </div>
            </div>

            {/* Knowledge Hub Card */}
            <div className="col-md-4">
              <div className="card p-4 text-center">
                <div className="service-item-icon mb-3">
                  <img src="/assets/images/knowledge-icon.png" alt="Knowledge Icon" width="50" />
                </div>
                <h4 className="text-success">Knowledge Hub</h4>
                <p>Access curated insights, crop guides, and expert advice.</p>
                <Link to="/knowledge" className="btn btn-get-started">Learn More</Link>
              </div>
            </div>
          </div>
        </div>
      </section>
    </>
  );
}

export default Home;