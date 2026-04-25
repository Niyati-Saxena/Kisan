import ServiceIcon from './ServiceIcon';
import thunderIcon from '../../assets/thunderstorm.png';
import cropIcon from '../../assets/sprout.png';
import bookIcon from '../../assets/books.png';
import marketIcon from '../../assets/market-research.png';
import ServiceCard from './ServiceCard';
import {Link} from 'react-router-dom';
import '../../stylesheets/ServiceSection.css';

const services = [
  {
    number: '01',
    icon: <ServiceIcon src={thunderIcon} alt="Weather Icon" />,
    title: 'Weather',
    description: 'Gravida sodales condimentum...',
    path :'/weather',
  },
  {
    number: '02',
    icon: <ServiceIcon src={cropIcon} alt="Crops Icon" />,
    title: 'Crops',
    description: 'Gravida sodales condimentum...',
    path : '/crops',
  },
  {
    number: '03',
    icon: <ServiceIcon src={bookIcon} alt="Knowledge Icon" />,
    title: 'Knowledge',
    description: 'Gravida sodales condimentum...',
    path : '/knowledge',
  },
  {
    number: '04',
    icon: <ServiceIcon src={marketIcon} alt="Marketplace Icon" />,
    title: 'MarketPlace',
    description: 'Gravida sodales condimentum...',
    path : '/marketplace'
  },
];

export default function ServicesSection() {
  return (  
    // {location.pa

    <section id="services" className="services section">
      <div className="container section-title" style = {{paddingBottom : '15px'}}>
        <h2>SERVICES</h2>
        <p style = {{color : 'black' , fontWeight : 'normal'}}>Providing Fresh Produce Every Single Day</p>
      </div>
      <div className="container" style = {{paddingBottom : '70px'}}>
        <div className="row g-0">
          {services.map((s, i) => (
  <div key={i} className="col-md-6 col-lg-3">
    <Link to={s.path} className="service-link">
      <ServiceCard {...s} />
    </Link>
  </div>
))}
        </div>
      </div>
    </section>
 );
}