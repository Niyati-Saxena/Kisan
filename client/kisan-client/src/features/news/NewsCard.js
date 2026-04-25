export default function NewsCard({ image, title, author, category, date }) {
  return (
    <div className="swiper-slide">
      <div className="service-item">
        <img src={image} alt={title} className="img-fluid" />
        <div className="service-item-contents">
          <span className="service-item-category">{category}</span>
          <h2 className="service-item-title">{title}</h2>
          <p className="meta">{author} • {date}</p>
        </div>
      </div>
    </div>
  );
}