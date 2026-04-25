import '../stylesheets/Register.css';
import { useState } from 'react';
import axios from 'axios';


export default function RegisterSection() {
  // ✅ Declare form state
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    location: ''
  });

  const handleChange = (e) => {
    setFormData(prev => ({
      ...prev,
      [e.target.id]: e.target.value
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post('http://localhost:8081/api/register', formData);
      alert('Registered successfully!');
      setFormData({ name: '', email: '', location: '' }); // ✅ Reset form
    } catch (err) {
      alert('Registration failed. Please try again.');
    }
  };

  return (
    <section className="register-section section">
      <div className="container">
        <h2 className="section-title">Join Our Community</h2>
        <p className="section-description" style = {{color : 'black'}}>Register now to receive updates, insights, and exclusive access to our tools.</p>

        <form className="form-box" onSubmit={handleSubmit}>
          <div className="form-group">
            <label htmlFor="name">Name</label>
            <input type="text" id="name" value={formData.name} onChange={handleChange} required />
          </div>
          <div className="form-group">
            <label htmlFor="email">Email</label>
            <input type="email" id="email" value={formData.email} onChange={handleChange} required />
          </div>
          <div className="form-group">
            <label htmlFor="location">Location</label>
            <input type="text" id="location" value={formData.location} onChange={handleChange} />
          </div>
          <button type="submit" className="submit-btn">Register</button>
        </form>
      </div>
    </section>
  );
}