import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

import NavBar from './components/NavBar';
import HeroCarousel from './components/HeroCarousel';
import ServicesSection from './features/services/ServicesSection';
import WhyChooseUs from './components/About/WhyChooseUs';
import ContactForm from './features/communication/ContactForm';
import Footer from './components/Footer';

import Marketplace from './features/marketplace/MarketPlace';
import WeatherDashboard from './features/weather/WeatherDashboard';
import NewsFeed from './features/news/NewsFeed';
import KnowledgePage from './features/knowledge/KnowledgePage';
import About from './pages/About';
import NotFound from './pages/NotFound';
import Login from './pages/Login';
import CropList from './features/crop/CropList';
import Register from './components/Register';
import { AuthProvider } from './auth/AuthContext';

import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';

function App() {
  return (
    <AuthProvider>
    <Router>

      <NavBar />

      <main>

        <Routes>

          {/* =========================
              PUBLIC HOME PAGE
          ========================= */}
          <Route
            path="/"
            element={
              <>
                <HeroCarousel />
                <ServicesSection />
                <WhyChooseUs />
              </>
            }
          />

          {/* =========================
              PUBLIC PAGES
          ========================= */}

          <Route
            path="/marketplace"
            element={<Marketplace />}
          />

          <Route
            path="/weather"
            element={<WeatherDashboard />}
          />

          <Route
            path="/news"
            element={<NewsFeed />}
          />

          <Route
            path="/knowledge"
            element={<KnowledgePage />}
          />

          <Route
            path="/contact"
            element={<ContactForm />}
          />

          <Route
            path="/about"
            element={<About />}
          />

          <Route
            path="/crops"
            element={<CropList />}
          />

          {/* =========================
              AUTHENTICATION
          ========================= */}

            <Route
  path="/login"
  element={<Login />}
/>

          <Route
            path="/register"
            element={<Register />}
          />

          <Route
            path="*"
            element={<NotFound />}
          />

        </Routes>

      </main>

      <Footer />

    </Router>
    </AuthProvider>
  );
}

export default App;
