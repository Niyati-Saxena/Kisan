import { useEffect, useState } from 'react';
import axios from 'axios';

function TransportationList() {
  const [transporters, setTransporters] = useState([]);

  useEffect(() => {
    axios.get('/api/transporters')
      .then(res => setTransporters(res.data))
      .catch(err => console.error("Transport fetch error:", err));
  }, []);

  return (
    <div>
      
      <ul>
        {transporters.map(t => (
          <li key={t.id}>
            <strong>{t.name}</strong> — {t.vehicleType}
            <p>Route: {t.route}</p>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default TransportationList;