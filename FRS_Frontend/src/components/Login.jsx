import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './Login.css';
import './Header.css';
import './Footer.css';
import Header from './Header';
import Footer from './Footer';

const Login = () => {
  const [userUsername, setUserUsername] = useState('');
  const [userPassword, setUserPassword] = useState('');
  const [adminUsername, setAdminUsername] = useState('');
  const [adminPassword, setAdminPassword] = useState('');
  const navigate = useNavigate();

  const handleUserLogin = (e) => {
    e.preventDefault();
    // navigate('/user-dashboard');
    // Hardcoded credentials for demonstration purposes
    const correctUserUsername = 'user';
    const correctUserPassword = 'userpass';

    if (userUsername === correctUserUsername && userPassword === correctUserPassword) {
      // Redirect to the user dashboard
      navigate('/user-dashboard');
    } else {
      alert('Invalid user credentials!');
    }
  };

  const handleAdminLogin = (e) => {
    e.preventDefault();
    
    // Hardcoded credentials for demonstration purposes
    const correctAdminUsername = 'admin';
    const correctAdminPassword = 'password123';

    if (adminUsername === correctAdminUsername && adminPassword === correctAdminPassword) {
      // Redirect to the admin dashboard
      navigate('/admin-dashboard');
    } else {
      alert('Invalid admin credentials!');
    }
  };

  return (
    <div className="login-container">
      <Header /> {/* Add the Header at the top */}
      <div className="login-content">
        {/* User Login Section */}
        <div className="login-box user-login">
          <h2 className="login-title">User Login</h2>
          <form onSubmit={handleUserLogin}>
            <div className="input-group">
              <label htmlFor="username">Username</label>
              <input
                type="text"
                id="username"
                placeholder="Enter your username"
                value={userUsername}
                onChange={(e) => setUserUsername(e.target.value)}
              />
            </div>
            <div className="input-group">
              <label htmlFor="password">Password</label>
              <input
                type="password"
                id="password"
                placeholder="Enter your password"
                value={userPassword}
                onChange={(e) => setUserPassword(e.target.value)}
              />
            </div>
            <button type="submit" className="login-button">Login</button>
          </form>
          <div className="register-link">
            <a href="/register">New User? Register Now!</a>
          </div>
        </div>

        {/* Admin Login Section */}
        <div className="login-box admin-login">
          <h2 className="login-title">Admin Login</h2>
          <form onSubmit={handleAdminLogin}>
            <div className="input-group">
              <label htmlFor="admin-username">Username</label>
              <input
                type="text"
                id="admin-username"
                placeholder="Enter admin username"
                value={adminUsername}
                onChange={(e) => setAdminUsername(e.target.value)}
              />
            </div>
            <div className="input-group">
              <label htmlFor="admin-password">Password</label>
              <input
                type="password"
                id="admin-password"
                placeholder="Enter admin password"
                value={adminPassword}
                onChange={(e) => setAdminPassword(e.target.value)}
              />
            </div>
            <button type="submit" className="login-button">Login</button>
          </form>
        </div>
      </div>
      <Footer /> {/* Add the Footer at the bottom */}
    </div>
  );
};

export default Login;
