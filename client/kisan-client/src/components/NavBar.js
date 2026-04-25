import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import logo from '../assets/cropped_circle_image (1).png'; 
import '../stylesheets/Navbar.css';

function NavBar() {
  const [mobileNavOpen, setMobileNavOpen] = useState(false);

  return (
    <header className={`header ${mobileNavOpen ? 'mobile-nav-active' : ''}`}>
      <div className="container d-flex justify-content-between align-items-center">
        <div className="logo d-flex align-items-center gap-2">
  
  <h1 className="logo-text">Kisan</h1>
</div>

        <nav className="navmenu">
          <ul>
            <li><Link to="/" className="active">Home</Link></li>
            <li><Link to="/marketplace">Marketplace</Link></li>
            <li><Link to="/weather">Weather</Link></li>
            <li><Link to="/news">News</Link></li>
            <li><Link to="/knowledge">Knowledge</Link></li>
            <li><Link to="/contact">Contact</Link></li>
            <li><Link to="/about">About</Link></li>
          </ul>
        </nav>

        <i
          className="mobile-nav-toggle bi bi-list"
          onClick={() => setMobileNavOpen(!mobileNavOpen)}
        ></i>
      </div>
    </header>
  );
}

export default NavBar;