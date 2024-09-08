import React from 'react';
import Header from './Header';
import Carousel from './Carousel';
import Footer from './Footer';
import './Home.css'; // Import a CSS file if you want to style the Home component
import Information from './Information';

const Home = () => {
  return (
    <div className="home">
        
        <Header />
        <Carousel />
       <Information/>
        <Footer />
       
        
     
      
    </div>
  );
};

export default Home;
