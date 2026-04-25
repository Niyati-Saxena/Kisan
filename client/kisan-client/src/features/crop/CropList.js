import { useEffect, useState } from 'react';
import axios from 'axios';
import '../../stylesheets/CropList.css';

function CropList() {
  const [crops, setCrops] = useState([]);

  useEffect(() => {
    axios.get('/api/crops')
      .then(res => {
        console.log("Fetched crops :" , res.data);
        setCrops(res.data);
      })
      .catch(err => console.error("error fetching crops : " , err));
  }, []);

  return (
  <section className="crops-section section">
    <div className="container">
      <h2 className="section-title">Crop Information</h2>
      <p className="section-description">Explore seasonal crops and their ideal soil types</p>
      <div className="crop-list">
        {crops.length > 0 ? (
          crops.map(crop => (
            <div key={crop.id} className="crop-card">
              <h4>{crop.name}</h4>
              <p><strong>Season:</strong> {crop.season}</p>
              <p><strong>Soil Type:</strong> {crop.soilType}</p>
            </div>
          ))
        ) : (
          <p className="loading-text">Loading crops...</p>
        )}
      </div>
    </div>
  </section>
);
}

export default CropList;