import React from 'react';
import { useNavigate, Link } from 'react-router-dom';
import './UserHeader.css'; // Import the CSS file for styling

const UserHeader = () => {
  const navigate = useNavigate();

  const handleLogout = () => {
    // Clear any user session data if necessary (e.g., cookies, localStorage)
    // localStorage.removeItem('user'); // Example of clearing user data

    // Redirect to the login page
    navigate('/');
  };

  return (
    <header className="user-header">
      <h1>User Dashboard</h1>
      <nav className="user-nav">
        <Link to="/user-dashboard" className="nav-link">DashBoard</Link>
        <Link to="/airport" className="nav-link">Airport</Link>
        <Link to="/booking" className="nav-link">Booking</Link>
        <Link to="/flight" className="nav-link">Flight</Link>
        <Link to="/passenger-details" className="nav-link">Passenger Details</Link>
        <Link to="/schedule-flight" className="nav-link">Schedule Flight</Link>
        <Link to="/ticket" className="nav-link">Ticket</Link>
        <Link to="/user" className="nav-link">User</Link>
        <button className="logout-button" onClick={handleLogout}>
          Logout
        </button>
      </nav>
    </header>
  );
};

export default UserHeader;
