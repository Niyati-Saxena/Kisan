import React, { useEffect, useState } from 'react';
import { getNews } from './NewsService';
import '../../stylesheets/News.css'; 
function NewsFeed() {
  const [news, setNews] = useState([]);

  useEffect(() => {
    getNews().then(res => setNews(res.data));
  }, []);

  return (
    <section className="news section">
      <div className="container section-title">
        <h2>LIVE AGRICULTURAL NEWS</h2>
        <p style = {{fontWeight : 'normal' , color : 'black'}}>Latest updates from Krishi Jagran</p>
      </div>

      <div className="container news-list">
        {news.map((n, i) => (
          <div key={i} className="news-card">
            <h3 className="news-title">{n.title}</h3>
            <p className="news-meta">{n.date}</p>
            <p className="news-summary" dangerouslySetInnerHTML={{ __html: n.summary }} />
            <a href={n.link} target="_blank" rel="noopener noreferrer" className="news-link">
              Read more →
            </a>
          </div>
        ))}
      </div>
    </section>
  );
}

export default NewsFeed;