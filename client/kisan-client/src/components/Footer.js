function Footer() {
  return (
    <footer className="footer">
      <div className="footer-top">
        <div className="container">
          <div className="row">

            {/* About Section */}
            <div className="col-lg-4 col-md-6 footer-about">
              <div className="logo d-flex align-items-center">
                <span>Kisan</span>
              </div>
              <p>Empowering farmers with tools, insights, and support for a better tomorrow.</p>
              <div className="social-links mt-3">
                <a href="#"><i className="bi bi-twitter"></i></a>
                <a href="#"><i className="bi bi-facebook"></i></a>
                <a href="#"><i className="bi bi-instagram"></i></a>
              </div>
            </div>

            {/* Quick Links */}
            <div className="col-lg-4 col-md-6 footer-links">
              <h4>Quick Links</h4>
              <ul>
                <li><i className="bi bi-chevron-right"></i> <a href="/">Home</a></li>
                <li><i className="bi bi-chevron-right"></i> <a href="/marketplace">Marketplace</a></li>
                <li><i className="bi bi-chevron-right"></i> <a href="/weather">Weather</a></li>
                <li><i className="bi bi-chevron-right"></i> <a href="/contact">Contact</a></li>
              </ul>
            </div>

            {/* Contact Info */}
            <div className="col-lg-4 col-md-6 footer-contact">
              <h4>Contact Us</h4>
              <p>
                Huzur, Madhya Pradesh<br />
                India<br />
                <strong>Email:</strong> support@kisan.in<br />
              </p>
            </div>

          </div>
        </div>
      </div>

      <div className="container text-center copyright">
        <p>&copy; 2025 Kisan. All Rights Reserved.</p>
        <div className="credits">
          Designed with ❤️ using AgriCulture template styles
        </div>
      </div>
    </footer>
  );
}

export default Footer;