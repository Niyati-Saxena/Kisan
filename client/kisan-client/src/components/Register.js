import '../stylesheets/Register.css';
import { useState } from 'react';
import axios from 'axios';

export default function Register() {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    location: '',
    password: '',
    confirmPassword: '',
    role: 'FARMER'
  });

  const [error, setError] = useState('');
  const [success, setSuccess] = useState('');

  const handleChange = (e) => {
    setFormData(prev => ({
      ...prev,
      [e.target.id]: e.target.value
    }));

    // Clear messages when user starts editing again
    setError('');
    setSuccess('');
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    setError('');
    setSuccess('');

    // Frontend password confirmation check
    if (formData.password !== formData.confirmPassword) {
      setError('Passwords do not match.');
      return;
    }

    // Only send fields expected by the backend
    const registrationData = {
      name: formData.name,
      email: formData.email,
      location: formData.location,
      password: formData.password,
      role: formData.role
    };

    try {
      const response = await axios.post(
        'http://localhost:8081/api/register',
        registrationData
      );

      setSuccess(response.data || 'Registered successfully.');

      // Reset form after successful registration
      setFormData({
        name: '',
        email: '',
        location: '',
        password: '',
        confirmPassword: '',
        role: 'FARMER'
      });

    } catch (err) {
      console.error('Registration error:', err);

      if (err.response) {
        const status = err.response.status;
        const data = err.response.data;

        if (status === 409) {
          setError(data.message || 'Email already exists.');
        } else if (status === 400) {
          if (data.errors) {
            const validationMessages = Object.values(data.errors).join(' ');
            setError(validationMessages);
          } else {
            setError(data.message || 'Please check your registration details.');
          }
        } else {
          setError(data.message || 'Registration failed. Please try again.');
        }
      } else {
        setError(
          'Unable to connect to the server. Please make sure the backend is running.'
        );
      }
    }
  };

  return (
    <section className="register-section section">
      <div className="container">

        <h2 className="section-title">
          Join Our Community
        </h2>

        <p
          className="section-description"
          style={{ color: 'black' }}
        >
          Register now to receive updates, insights, and access to Kisan's
          farming tools and services.
        </p>

        <form
          className="form-box"
          onSubmit={handleSubmit}
        >

          {/* Name */}
          <div className="form-group">
            <label htmlFor="name">
              Name
            </label>

            <input
              type="text"
              id="name"
              value={formData.name}
              onChange={handleChange}
              placeholder="Enter your name"
              required
              minLength={3}
              maxLength={50}
            />
          </div>

          {/* Email */}
          <div className="form-group">
            <label htmlFor="email">
              Email
            </label>

            <input
              type="email"
              id="email"
              value={formData.email}
              onChange={handleChange}
              placeholder="Enter your email"
              required
            />
          </div>

          {/* Location */}
          <div className="form-group">
            <label htmlFor="location">
              Location
            </label>

            <input
              type="text"
              id="location"
              value={formData.location}
              onChange={handleChange}
              placeholder="Enter your location"
              required
            />
          </div>

          {/* Password */}
          <div className="form-group">
            <label htmlFor="password">
              Password
            </label>

            <input
              type="password"
              id="password"
              value={formData.password}
              onChange={handleChange}
              placeholder="Enter your password"
              required
              minLength={8}
              maxLength={100}
            />
          </div>

          {/* Confirm Password */}
          <div className="form-group">
            <label htmlFor="confirmPassword">
              Confirm Password
            </label>

            <input
              type="password"
              id="confirmPassword"
              value={formData.confirmPassword}
              onChange={handleChange}
              placeholder="Confirm your password"
              required
              minLength={8}
              maxLength={100}
            />
          </div>

          {/* Role */}
          <div className="form-group">
            <label htmlFor="role">
              Register As
            </label>

            <select
              id="role"
              value={formData.role}
              onChange={handleChange}
              required
            >
              <option value="FARMER">
                Farmer
              </option>

              <option value="VENDOR">
                Vendor
              </option>
            </select>
          </div>

          {/* Error message */}
          {error && (
            <div className="registration-error">
              {error}
            </div>
          )}

          {/* Success message */}
          {success && (
            <div className="registration-success">
              {success}
            </div>
          )}

          {/* Submit */}
          <button
            type="submit"
            className="submit-btn"
          >
            Register
          </button>

        </form>
      </div>
    </section>
  );
}