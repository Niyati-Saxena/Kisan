import React, { useState } from 'react';
import axios from 'axios';
import '../../stylesheets/Contact.css'; 

function ContactForm() {
  const [form, setForm] = useState({ name: '', email: '', message: '' });

  const handleChange = e => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = e => {
    e.preventDefault();
    axios.post('/api/messages', form)
      .then(() => {
        alert("Message sent!");
        setForm({ name: '', email: '', message: '' });
      })
      .catch(err => console.error("Message error:", err));
  };

  return (
    <section id="contact" className="communication section">
      <div className="container section-title">
        <h2>CONTACT US</h2>
        <p style = {{fontWeight : 'normal' , color : 'black'}}>Send us your inquiries, feedback, or service requests</p>
      </div>

      <div className="container communication-form">
        <form onSubmit={handleSubmit} className="product-form">
  <input
    type="text"
    name="name"
    placeholder="Your name"
    value={form.name}
    onChange={handleChange}
    required
  />
  <input
    type="email"
    name="email"
    placeholder="Your email"
    value={form.email}
    onChange={handleChange}
    required
  />
  <textarea
    name="message"
    placeholder="Your message"
    rows="5"
    value={form.message}
    onChange={handleChange}
    required
  />
  <button type="submit">Send</button>
</form>
      </div>
    </section>
  );
}

export default ContactForm;