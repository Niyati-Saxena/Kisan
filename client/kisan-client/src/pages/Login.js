import { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function Login() {
  const [formData, setFormData] = useState({
    email: '',
    password: ''
  });

  const [error, setError] = useState('');
  const [loading, setLoading] = useState(false);

  const navigate = useNavigate();

  const handleChange = (e) => {
    setFormData(prev => ({
      ...prev,
      [e.target.id]: e.target.value
    }));

    setError('');
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    setError('');
    setLoading(true);

    try {
      const response = await axios.post(
        'http://localhost:8081/api/login',
        formData
      );

      console.log('Login successful:', response.data);

      // Temporary storage.
      // We will replace this with AuthContext later.
      localStorage.setItem('token', response.data.token);
      localStorage.setItem('userId', response.data.userId);
      localStorage.setItem('name', response.data.name);
      localStorage.setItem('role', response.data.role);

      navigate('/');

    } catch (err) {
      console.error('Login error:', err);

      if (err.response) {
        const status = err.response.status;
        const data = err.response.data;

        if (status === 401) {
          setError(data.message || 'Invalid email or password.');
        } else if (status === 400) {
          if (data.errors) {
            const validationMessages =
              Object.values(data.errors).join(' ');

            setError(validationMessages);
          } else {
            setError(
              data.message || 'Please check your login details.'
            );
          }
        } else {
          setError(
            data.message || 'Login failed. Please try again.'
          );
        }
      } else {
        setError(
          'Unable to connect to the server. Please make sure the backend is running.'
        );
      }

    } finally {
      setLoading(false);
    }
  };

  return (
    <section className="login-section section">
      <div className="container">

        <h2 className="section-title">
          Login
        </h2>

        <p
          className="section-description"
          style={{ color: 'black' }}
        >
          Login to access your Kisan account.
        </p>

        <form
          className="form-box"
          onSubmit={handleSubmit}
        >

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
            />
          </div>


          {/* Error */}
          {error && (
            <div className="registration-error">
              {error}
            </div>
          )}


          {/* Submit */}
          <button
            type="submit"
            className="submit-btn"
            disabled={loading}
          >
            {loading ? 'Logging in...' : 'Login'}
          </button>

        </form>

      </div>
    </section>
  );
}

export default Login;