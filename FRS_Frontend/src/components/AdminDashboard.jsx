import React from 'react';
import './AdminDashboard.css'; // Import the CSS file for the Admin Dashboard styling
import AdminHeader from './AdminHeader'; // Import the AdminHeader component
import AdminDashboardImage from '../assets/AdminDashboardImage.jpg'; // Adjust the path as needed

const AdminDashboard = () => {
  return (
    <div className="admin-dashboard">
      <AdminHeader /> {/* Use the AdminHeader component */}
      <div className="dashboard-image-container">
        <img src={AdminDashboardImage} alt="Admin Dashboard" className="dashboard-image" />
      </div>
    </div>
  );
};

export default AdminDashboard;
