import { useEffect, useState } from 'react';
import ProductForm from './ProductForm';
import { getProducts} from './ProductService';
import '../../stylesheets/MarketPlace.css';
import SupplierList from './SupplierList';
import TransportationList from './TransportationList';

function Marketplace() {
  const [products, setProducts] = useState([]);
  const [search, setSearch] = useState('');
  const [category, setCategory] = useState('');
  const [sort, setSort] = useState('price');

  useEffect(() => {
       getProducts().then(res => setProducts(res.data));
     
  }, []);

  const filtered = products
    .filter(p => p.name.toLowerCase().includes(search.toLowerCase()))
    .filter(p => category ? p.category === category : true)
    .sort((a, b) => a[sort] - b[sort]);

  const handleAdd = newProduct => {
    setProducts([...products, newProduct]);
  };

     return (
    
  <section id="marketplace" className="marketplace section">
    <div className="container section-title" style = {{paddingBottom : '40px' }}>
      <h2>MARKETPLACE</h2>
      <p style = {{fontWeight : 'normal' , color : 'black'}}>Browse and add agricultural products with ease</p>
    </div>

    <div className="container">
      {/* Search and browse filters */}
      <div className="marketplace-filters" >
        <p style={{ fontFamily: 'Marcellus, sans-serif', fontSize: '25px', marginBottom: '0px' , color: 'var(--accent-color)'}}>Search our Products</p>
        <br />
        <input
          type="text"
          placeholder="Search products"
          value={search}
          onChange={e => setSearch(e.target.value)}
        />
        <select value={category} onChange={e => setCategory(e.target.value)}>
          <option value="">All Categories</option>
          <option value="Seeds">Seeds</option>
          <option value="Tools">Tools</option>
          <option value="Fertilizers">Fertilizers</option>
        </select>
        <select value={sort} onChange={e => setSort(e.target.value)}>
          <option value="price">Sort by Price</option>
          <option value="name">Sort by Name</option>
        </select>
      </div>

      {/* Search our products title */}
      <p style={{ fontFamily: 'Marcellus, sans-serif', fontSize: '25px' , color: 'var(--accent-color)' }}>Our Current Products</p>

      {/* Product cards */}
      <div className="row g-0">
        {filtered.map(p => (
          <div key={p.id} className="col-md-6 col-lg-4">
            <div className="product-card">
              <div className="product-header">
                <strong>{p.name}</strong> — ₹{p.price}
              </div>
              <div className="product-meta">
                <span>{p.category}</span> | <span>{p.location}</span>
              </div>
              <p>{p.description}</p>
            </div>
          </div>
        ))}
      </div>

      {/* Supplier list */}
      <div className="marketplace-subsection">
        <h3 style={{ fontFamily: 'Marcellus, sans-serif', fontSize: '25px' }}>Suppliers</h3>
        <SupplierList />
      </div>

      {/* Transportation list */}
      <div className="marketplace-subsection">
        <h3 style={{ fontFamily: 'Marcellus, sans-serif', fontSize: '25px' }}>Transportation Options</h3>
        <TransportationList />
      </div>

      {/* Add product form */}
      <div className="marketplace-subsection">
        <h3 style={{ fontFamily: 'Marcellus, sans-serif' , fontSize : '25px'}}>Add a New Product</h3>
        <ProductForm onAdd={handleAdd} />
      </div>
    </div>
  </section>
);
  
}

export default Marketplace;