import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import NavBar from './components/NavBar';
import HeroCarousel from './components/HeroCarousel';
import ServicesSection from './features/services/ServicesSection';
import WhyChooseUs from './components/About/WhyChooseUs';
import ContactForm from './features/communication/ContactForm';
import Footer from './components/Footer';
import Marketplace from './features/marketplace/MarketPlace'; 
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
import WeatherDashboard from './features/weather/WeatherDashboard';
import NewsFeed from './features/news/NewsFeed';
import KnowledgePage from './features/knowledge/KnowledgePage';
import About from './pages/About';
import CropList from './features/crop/CropList';
import Register from './components/Register';

function App() {
  return (
    <Router>
      <NavBar />
      <main>
        <Routes>
          <Route
            path="/"
            element={
              <>
                <HeroCarousel />
                <ServicesSection />
                <WhyChooseUs />
                <Register/>
              </>
            }
          />
          <Route path="/marketplace" element={<Marketplace />} />
          <Route path="/weather" element={<WeatherDashboard/>}/> 
          <Route path="/news" element={<NewsFeed/>}/>
          <Route path="/knowledge" element = {<KnowledgePage/>}/>
          <Route path="/contact" element= {<ContactForm/>}/>
          <Route path = "/about" element={<About/>}/>
          <Route path = "/crops" element = {<CropList/>}/>
       </Routes>
      </main>
      <Footer />
    </Router>
  );
}

export default App;