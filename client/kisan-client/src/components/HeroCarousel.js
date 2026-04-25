import React from 'react';
import { Swiper, SwiperSlide } from 'swiper/react';
import { Autoplay, Navigation, Scrollbar , EffectFade } from 'swiper/modules';
import 'swiper/css';
import 'swiper/css/navigation';
import 'swiper/css/scrollbar';
import 'swiper/css/effect-fade';

import hero1 from '../img/hero_1.jpg';
import hero2 from '../img/hero_2.jpg';
import hero3 from '../img/hero_3.jpg';
import hero4 from '../img/hero_4.jpg';
import hero5 from '../img/hero_5.jpg';

const slides = [
  {
    image: hero1,
    title: 'Farming is the best solution to world starvation',
    desc: 'Empowering communities through sustainable agriculture and food security.',
  },
  {
    image: hero2,
    title: 'Organic vegetables are healthy and good for health',
    desc: 'Grown without chemicals, packed with nutrients, and better for the planet.',
  },
  {
   
  image: hero3,
  title: 'Providing Fresh Produce Every Single Day',
  desc: 'We deliver farm-fresh vegetables and fruits daily, ensuring quality, nutrition, and trust in every bite.',
},
  {
    image: hero4,
    title: 'Empowering Farmers, Enriching Lives',
    desc: 'Supporting local growers with tools, knowledge, and fair market access.',
  },
  {
    image: hero5,
    title: 'From Soil to Soul — A Journey of Purity',
    desc: 'Experience the freshness of nature, cultivated with care and delivered with integrity.',
  }
];

export default function HeroCarousel() {
  return (
    <section id="hero" className="hero-banner">
      <Swiper
        modules={[Autoplay, Navigation, Scrollbar , EffectFade]}
        autoplay={{ delay: 4000, disableOnInteraction: false }}
        navigation
        scrollbar={{ draggable: true }}
        loop
        effect = "fade"
        fadeEffect={{crossFade:true}}
        speed = {1000}
        className="hero-swiper"
      >
        {slides.map((slide, index) => (
          <SwiperSlide key={index}>
  <div
    className="slide"
    style={{
      position: 'relative',
      height: '100%',
      width: '100%',
      overflow: 'hidden',
    }}
  >
    {/* Background Image */}
    <img
      src={slide.image}
      alt={slide.title}
      style={{
        position: 'absolute',
        top: 0,
        left: 0,
        width: '100%',
        height: '100%',
        objectFit: 'cover',
        zIndex: 1,
        opacity:0.8,
        objectPosition:'centre top',
       
      }}
    />

    {/* Full Black Overlay */}
    <div
      style={{
        position: 'absolute',
        top: 0,
        left: 0,
        width: '100%',
        height: '100%',
        backgroundColor: 'rgba(0, 0, 0, 0.3)',
        zIndex: 2,
      }}
    />

    {/* Text Content */}
    <div
      style={{
        position: 'absolute',
        top: '50%',
        left: '50%',
        zIndex: 3,
        color: 'white',
        textAlign:'center',
        maxWidth: '80%',
        transform: 'translate(-50% , -50%)',
      }}
    >
      <h2 style={{ fontSize: '3.2rem', marginBottom: '1rem' , fontWeight: 'bold'}}>{slide.title}</h2>
      <p style={{ fontSize: '1.5rem' , fontWeight: '300'}}>{slide.desc}</p>
    </div>
  </div>
</SwiperSlide>
        ))}
      </Swiper>
    </section>
  );
}