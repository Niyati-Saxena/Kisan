import React, { useState } from 'react';
import axios from 'axios';

function ProductForm({ onAdd }) {
  // console.log("onAdd is: " ,onAdd); // for debugging 
  const [form, setForm] = useState({
    name: '', category: '', price: '', location: '', description: ''
  });

  const handleChange = e => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = e => {
    e.preventDefault();
    axios.post('/api/products', form)
      .then(res => {
        onAdd(res.data);
        setForm({ name: '', category: '', price: '', location: '', description: '' });
      });
  };

  return (
    <form onSubmit={handleSubmit} className='product-form'>
      <input name="name" placeholder="Product name" value={form.name} onChange={handleChange} />
      <input name="category" placeholder="Category" value={form.category} onChange={handleChange} />
      <input name="price" placeholder="Price" value={form.price} onChange={handleChange} />
      <input name="location" placeholder="Location" value={form.location} onChange={handleChange} />
      <textarea name="description" placeholder="Description" value={form.description} onChange={handleChange} />
      <button type="submit">Add Product</button>
    </form>
  );
}

export default ProductForm;