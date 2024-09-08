import React from 'react';
import './Footer.css'; // Import the new CSS file

const Footer = () => (
  <footer className="footer">
    <div className="footer-container">
      <p className="footer-text">Phone: +1234567890</p>
      <span className="footer-separator">|</span>
      <p className="footer-text">Email: support@flightreservation.com</p>
      <span className="footer-separator">|</span>
      <p className="footer-text">© 2024 Flight Reservation. All rights reserved.</p>
    </div>
  </footer>
);

export default Footer;