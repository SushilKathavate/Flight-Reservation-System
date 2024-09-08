import React from 'react';
import { useNavigate, Link } from 'react-router-dom';
import './AdminHeader.css'; // Import the CSS file for styling

const AdminHeader = () => {
  const navigate = useNavigate();

  const handleLogout = () => {
    // Clear any user session data if necessary (e.g., cookies, localStorage)
    // localStorage.removeItem('user'); // Example of clearing user data

    // Redirect to the login page
    navigate('/');
  };

  return (
    <header className="admin-header">
      <h1>Admin Dashboard</h1>
      <nav className="admin-nav">
        <Link to="/admin-dashboard" className="nav-link">Dashboard</Link>
        <Link to="/add-flight" className="nav-link">Add Flight</Link>
        <Link to="/add-fare" className="nav-link">Add Fare</Link>
        <Link to="/admin-user" className="nav-link">Admin User</Link>
        <button className="logout-button" onClick={handleLogout}>
          Logout
        </button>
      </nav>
    </header>
  );
};

export default AdminHeader;
