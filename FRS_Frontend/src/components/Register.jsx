import React, { useState } from 'react';
import './Registration.css'; // Import the CSS file
import Header from './Header'; // Import the Header component
import Footer from './Footer'; // Import the Footer component
import './Header.css'; // Import the CSS file for Header
import './Footer.css'; // Import the CSS file for Footer

const Registration = () => {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    contact: '',
    username: '',
    password: '',
    confirmPassword: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // Handle form submission logic here
    console.log(formData);
  };

  return (
    <div className="registration-page">
      <Header /> {/* Add the Header at the top */}
      <div className="registration-container">
        <h2>Registration</h2>
        <form className="registration-form" onSubmit={handleSubmit}>
          <label htmlFor="name">Name</label>
          <input
            type="text"
            id="name"
            name="name"
            value={formData.name}
            onChange={handleChange}
            required
          />

          <label htmlFor="email">Email</label>
          <input
            type="email"
            id="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            required
          />

          <label htmlFor="contact">Contact</label>
          <input
            type="text"
            id="contact"
            name="contact"
            value={formData.contact}
            onChange={handleChange}
            required
          />

          <label htmlFor="username">Username</label>
          <input
            type="text"
            id="username"
            name="username"
            value={formData.username}
            onChange={handleChange}
            required
          />

          <label htmlFor="password">Password</label>
          <input
            type="password"
            id="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
            required
          />

          <label htmlFor="confirmPassword">Confirm Password</label>
          <input
            type="password"
            id="confirmPassword"
            name="confirmPassword"
            value={formData.confirmPassword}
            onChange={handleChange}
            required
          />

          <button type="submit">Register</button>
        </form>
        <div className="login-link">
          <a href="/login">Already registered? Login Now!</a>
        </div>
      </div>
      <Footer /> {/* Add the Footer at the bottom */}
    </div>
  );
};

export default Registration;
