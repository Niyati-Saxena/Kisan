
import { useEffect, useState } from 'react';
import api from '../../services/axiosConfig';

function SupplierList() {
  const [suppliers, setSuppliers] = useState([]);

  useEffect(() => {
    api.get('/suppliers')
      .then(res => setSuppliers(res.data))
      .catch(err => console.error("Supplier fetch error:", err));
  }, []);

  return (
    <div>
      
      <ul>
        {suppliers.map(s => (
          <li key={s.id}>
            <strong>{s.name}</strong> — {s.location}
            <p>{s.specialty}</p>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default SupplierList;