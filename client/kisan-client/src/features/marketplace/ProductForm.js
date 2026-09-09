import React, {  useEffect, useState } from 'react';
import api from '../../services/axiosConfig';
import { useAuth } from '../../auth/AuthContext';

function ProductForm({ onAdd, productToEdit, onUpdate, onCancel }) {

  const { user } = useAuth();
  const role = user?.role;

  const [form, setForm] = useState({
    name: '',
    category: '',
    price: '',
    location: '',
    description: ''
  });

  useEffect(() => {
  if (productToEdit) {
    setForm({
      name: productToEdit.name,
      category: productToEdit.category,
      price: productToEdit.price,
      location: productToEdit.location,
      description: productToEdit.description
    });
  }
}, [productToEdit]);

  const handleChange = e => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

 const handleSubmit = async (e) => {
  e.preventDefault();

  try {
    if (productToEdit) {
      const response = await api.put(
        `/products/${productToEdit.id}`,
        form
      );

      onUpdate(response.data);
    } else {
      const response = await api.post('/products', form);

      onAdd(response.data);

      setForm({
        name: '',
        category: '',
        price: '',
        location: '',
        description: ''
      });
    }

  } catch (error) {
    if (error.response?.status === 403) {
      alert('You must be logged in as a vendor.');
    } else {
      alert(
        productToEdit
          ? 'Failed to update product. Please try again.'
          : 'Failed to add product. Please try again.'
      );
    }
  }
};

  if (role !== 'VENDOR') {
    return null;
  }

  return (
    <form onSubmit={handleSubmit} className="product-form">

      <input
        name="name"
        placeholder="Product name"
        value={form.name}
        onChange={handleChange}
      />

      <input
        name="category"
        placeholder="Category"
        value={form.category}
        onChange={handleChange}
      />

      <input
        name="price"
        placeholder="Price"
        value={form.price}
        onChange={handleChange}
      />

      <input
        name="location"
        placeholder="Location"
        value={form.location}
        onChange={handleChange}
      />

      <textarea
        name="description"
        placeholder="Description"
        value={form.description}
        onChange={handleChange}
      />

      <button type="submit">
  {productToEdit ? 'Update Product' : 'Add Product'}
</button>

{productToEdit && (
  <button type="button" onClick={onCancel}>
    Cancel
  </button>
)}

    </form>
  );
}

export default ProductForm;