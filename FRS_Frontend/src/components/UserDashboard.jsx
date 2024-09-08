import React from 'react';
import UserHeader from './UserHeader';
import DashboardImage from '../assets/DashboardImage.jpg'; // Adjust the path as needed
import './UserDashboard.css'; // Assuming you have a CSS file for styling

const UserDashboard = () => {
  return (
    <div className="user-dashboard">
      <UserHeader />
      <div className="dashboard-image-container">
        <img src={DashboardImage} alt="Dashboard" className="dashboard-image" />
      </div>
    </div>
  );
}

export default UserDashboard;
