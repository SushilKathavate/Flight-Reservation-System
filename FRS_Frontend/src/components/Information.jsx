import React from 'react';
import { useNavigate } from 'react-router-dom'; // Import the useNavigate hook
import flightImage from '../assets/Flight8.jpg'; // Ensure the path is correct
import './Information.css'; // Import the CSS file

const Information = () => {
  const navigate = useNavigate(); // Initialize the navigate function

  const handleGetStarted = () => {
    navigate('/login'); // Redirect to the login page
  };

  return (
    <div className="container">
      <main className="main-content">
        <div className="content-wrapper">
          <div className="text-section">
            <h1>Welcome to Flight Reservation System</h1>
            <p>
              Welcome to our Flight Reservation System, where seamless travel planning and exhilarating adventures meet. Embark on a journey of convenience as you navigate our user-friendly platform to explore an array of flights, destinations, and class options. Whether you're a seasoned traveler or a first-time flyer, our system offers you the power to book your flights with ease, ensuring a hassle-free experience from takeoff to landing.
            </p>
            <p>
              From the moment you step into our digital gateway, you're one step closer to realizing your travel dreams. Join us as we redefine the way you book flights, making every adventure a memorable destination in itself.
            </p>
            <button className="get-started-button" onClick={handleGetStarted}>
              Get Started
            </button>
          </div>
          <div className="image-section">
            <img src={flightImage} alt="Flight reservation" />
          </div>
        </div>
      </main>
    </div>
  );
};

export default Information;
