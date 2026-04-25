export default function AboutVideo() {
  return (
    <section id="about-3" className="about-3 section">
      <div className="container">
        <div className="row align-items-center">
          <div className="col-lg-6 order-lg-2 position-relative">
            <img src="/assets/images/about/img_sq_1.jpg" alt="Video" className="img-fluid" />
            <a href="https://www.youtube.com/watch?v=Y7f98aduVJ8" className="glightbox pulsating-play-btn">
              <span className="play"><i className="bi bi-play-fill"></i></span>
            </a>
          </div>
          <div className="col-lg-5 order-lg-1">
            <h2>Plants Make Life Better</h2>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit...</p>
            <ul>
              <li>Lorem ipsum dolor sit amet</li>
              <li>Velit explicabo vitae repellendu</li>
              <li>Repellat aliquam nihil illo</li>
            </ul>
            <a href="#" className="btn-cta">Get in touch</a>
          </div>
        </div>
      </div>
    </section>
  );
}