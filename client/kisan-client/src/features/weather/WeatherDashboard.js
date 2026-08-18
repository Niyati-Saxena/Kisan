import { useState } from 'react';
import axios from 'axios';
import '../../stylesheets/WeatherDshboard.css';

function WeatherDashboard() {
  const [city, setCity] = useState('');
  const [weather, setWeather] = useState(null);

  const fetchWeather = () => {
    axios.get(`/api/weather/${city}`)
      .then(res => setWeather(res.data))
      .catch(err => console.error("Weather fetch error:", err));
  };

  return (
    <section className="weather section">
      <div className="container section-title">
        <h2>WEATHER FORECAST</h2>
        <p style = {{fontWeight : 'normal' , color : 'black'}}>Check current weather conditions by city</p>
      </div>

      <div className="weather-search centered-search-section">
        <input
          type="text"
          placeholder="Enter city"
          value={city}
          onChange={e => setCity(e.target.value)}
        />
        <button onClick={fetchWeather}>Get Weather</button>
      </div>

      {weather && (
        <div className="weather-card">
          <p className="weather-city"><strong>{weather.name}</strong></p>
          <p>Temperature: {weather.temperature}°C</p>
          <p>Condition: {weather.condition}</p>
        </div>
      )}
    </section>
  );
}

export default WeatherDashboard;