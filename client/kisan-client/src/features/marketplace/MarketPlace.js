import { useEffect, useState } from 'react';
import { useAuth } from '../../auth/AuthContext';
import { getProducts, updateProduct, deleteProduct } from './ProductService';
import '../../stylesheets/MarketPlace.css';
import SupplierList from './SupplierList';
import TransportationList from './TransportationList';
import ProductForm from './ProductForm';

function Marketplace() {
  const [products, setProducts] = useState([]);
  const [search, setSearch] = useState('');
  const [category, setCategory] = useState('');
  const [sort, setSort] = useState('price');
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');
  const [showProductForm, setShowProductForm] = useState(false);
  const [editingProduct, setEditingProduct] = useState(null);


   const { user } = useAuth();

  const role = user?.role;

  useEffect(() => {
    const loadProducts = async () => {
      try {
        setLoading(true);
        setError('');

        const response = await getProducts();
        setProducts(response.data);
      } catch (error) {
        console.error('Failed to load products:', error);
        setError('Unable to load products. Please try again.');
      } finally {
        setLoading(false);
      }
    };

    loadProducts();
  }, []);

  const filtered = [...products]
    .filter(p =>
      p.name.toLowerCase().includes(search.toLowerCase())
    )
    .filter(p =>
      category ? p.category === category : true
    )
    .sort((a, b) => {
      if (sort === 'price') {
        return Number(a.price) - Number(b.price);
      }

      if (sort === 'name') {
        return a.name.localeCompare(b.name);
      }

      return 0;
    });

    const handleDelete = async (id) => {
  try {
    await deleteProduct(id);

    setProducts(prevProducts =>
      prevProducts.filter(product => product.id !== id)
    );
  } catch (error) {
    console.error('Failed to delete product:', error);
    alert('Failed to delete product. Please try again.');
  }
};

const handleUpdate = async (id, updatedProduct) => {
  try {
    const response = await updateProduct(id, updatedProduct);

    setProducts(prevProducts =>
      prevProducts.map(product =>
        product.id === id ? response.data : product
      )
    );

    setEditingProduct(null);
  } catch (error) {
    console.error('Failed to update product:', error);
    alert('Failed to update product. Please try again.');
  }
};

  return (
    <section id="marketplace" className="marketplace section">

      <div
        className="container section-title"
        style={{ paddingBottom: '40px' }}
      >
        <h2>MARKETPLACE</h2>

        <p
          style={{
            fontWeight: 'normal',
            color: 'black'
          }}
        >
          Browse agricultural products, suppliers, and transportation options.
        </p>
      </div>

      <div className="container">

        {/* =========================
            SEARCH & FILTERS
        ========================= */}

        <div className="marketplace-filters">

          <p
            style={{
              fontFamily: 'Marcellus, sans-serif',
              fontSize: '25px',
              marginBottom: '0px',
              color: 'var(--accent-color)'
            }}
          >
            Search our Products
          </p>

          <br />

          <input
            type="text"
            placeholder="Search products"
            value={search}
            onChange={e => setSearch(e.target.value)}
          />

          <select
            value={category}
            onChange={e => setCategory(e.target.value)}
          >
            <option value="">All Categories</option>
            <option value="Seeds">Seeds</option>
            <option value="Tools">Tools</option>
            <option value="Fertilizers">Fertilizers</option>
          </select>

          <select
            value={sort}
            onChange={e => setSort(e.target.value)}
          >
            <option value="price">Sort by Price</option>
            <option value="name">Sort by Name</option>
          </select>

        </div>


{role === 'VENDOR' && (
  <>
    {!editingProduct && (
      <>
        <button onClick={() => setShowProductForm(!showProductForm)}>
          {showProductForm ? 'Cancel' : 'Add Product'}
        </button>

        {showProductForm && (
          <ProductForm
            onAdd={(newProduct) => {
              setProducts(prevProducts => [
                ...prevProducts,
                newProduct
              ]);

              setShowProductForm(false);
            }}
          />
        )}
      </>
    )}

    {editingProduct && (
      <ProductForm
        productToEdit={editingProduct}
        onUpdate={(updatedProduct) => {
          setProducts(prevProducts =>
            prevProducts.map(product =>
              product.id === updatedProduct.id
                ? updatedProduct
                : product
            )
          );

          setEditingProduct(null);
        }}
        onCancel={() => setEditingProduct(null)}
      />
    )}
  </>
)}


        {/* =========================
            PRODUCTS
        ========================= */}

        <p
          style={{
            fontFamily: 'Marcellus, sans-serif',
            fontSize: '25px',
            color: 'var(--accent-color)'
          }}
        >
          Our Current Products
        </p>

        {loading && (
          <p>Loading products...</p>
        )}

        {error && (
          <p>{error}</p>
        )}

        {!loading && !error && filtered.length === 0 && (
          <p>No products found.</p>
        )}

        {!loading && !error && filtered.length > 0 && (
          <div className="row g-0">

            {filtered.map(p => (
              <div
                key={p.id}
                className="col-md-6 col-lg-4"
              >
                <div className="product-card">
  <div className="product-header">
    <strong>{p.name}</strong> — ₹{p.price}
  </div>

  <div className="product-meta">
    <span>{p.category}</span>
    {' | '}
    <span>{p.location}</span>
  </div>

  <p>{p.description}</p>

  {role === 'VENDOR' &&
    Number(p.vendorId) === Number(user.userId) && (
      <div>
        <button onClick={() => setEditingProduct(p)}>
          Edit
        </button>

        <button onClick={() => handleDelete(p.id)}>
          Delete
        </button>
      </div>
    )}
</div>
              </div>
            ))}

          </div>
        )}


        {/* =========================
            SUPPLIERS
        ========================= */}

        <div className="marketplace-subsection">

          <h3
            style={{
              fontFamily: 'Marcellus, sans-serif',
              fontSize: '25px'
            }}
          >
            Suppliers
          </h3>

          <SupplierList />

        </div>


        {/* =========================
            TRANSPORTATION
        ========================= */}

        <div className="marketplace-subsection">

          <h3
            style={{
              fontFamily: 'Marcellus, sans-serif',
              fontSize: '25px'
            }}
          >
            Transportation Options
          </h3>

          <TransportationList />

        </div>
      </div>

    </section>
  );
}

export default Marketplace;
