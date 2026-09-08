import React, { useState } from 'react';
import { Link, NavLink, useNavigate } from 'react-router-dom';
import { useAuth } from '../auth/AuthContext';
import '../stylesheets/Navbar.css';

function NavBar() {
  const [mobileNavOpen, setMobileNavOpen] = useState(false);

  const { user, isAuthenticated, logout } = useAuth();
  const navigate = useNavigate();

  const closeMobileNav = () => {
    setMobileNavOpen(false);
  };

  const handleLogout = () => {
    logout();
    closeMobileNav();
    navigate('/');
  };

  return (
    <header className={`header ${mobileNavOpen ? 'mobile-nav-active' : ''}`}>

      <div className="container d-flex justify-content-between align-items-center">

        <div className="logo d-flex align-items-center gap-2">
          <Link to="/" onClick={closeMobileNav}>
            <h1 className="logo-text">Kisan</h1>
          </Link>
        </div>

        <nav className="navmenu">
          <ul>

            <li>
              <NavLink to="/" end onClick={closeMobileNav}>
                Home
              </NavLink>
            </li>

            <li>
              <NavLink to="/marketplace" onClick={closeMobileNav}>
                Marketplace
              </NavLink>
            </li>

            <li>
              <NavLink to="/weather" onClick={closeMobileNav}>
                Weather
              </NavLink>
            </li>

            <li>
              <NavLink to="/news" onClick={closeMobileNav}>
                News
              </NavLink>
            </li>

            <li>
              <NavLink to="/knowledge" onClick={closeMobileNav}>
                Knowledge
              </NavLink>
            </li>

            <li>
              <NavLink to="/contact" onClick={closeMobileNav}>
                Contact
              </NavLink>
            </li>

            <li>
              <NavLink to="/about" onClick={closeMobileNav}>
                About
              </NavLink>
            </li>

            {isAuthenticated ? (
              <>
                <li>
                  <span>
                    Welcome, {user.name}
                  </span>
                </li>

                <li>
                  <button
                    type="button"
                    onClick={handleLogout}
                  >
                    Logout
                  </button>
                </li>
              </>
            ) : (
              <>
                <li>
                  <NavLink to="/login" onClick={closeMobileNav}>
                    Login
                  </NavLink>
                </li>

                <li>
                  <NavLink to="/register" onClick={closeMobileNav}>
                    Register
                  </NavLink>
                </li>
              </>
            )}

          </ul>
        </nav>

        <i
          className={`mobile-nav-toggle bi ${
            mobileNavOpen ? 'bi-x' : 'bi-list'
          }`}
          onClick={() => setMobileNavOpen(!mobileNavOpen)}
        ></i>

      </div>
    </header>
  );
}

export default NavBar;
