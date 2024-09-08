import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './components/Home';
import About from './components/About';
import Register from './components/Register';
import Login from './components/Login';
import AdminDashboard from './components/AdminDashboard';
import AddFlight from './components/AddFlight';
import AddFare from './components/AddFare';
import AdminUser from './components/AdminUser';
import UserDashboard from './components/UserDashboard';
import Airport from './components/Airport';
import BookedFlights from './components/BookedFlights';
import Flight from './components/Flight';
import Passenger_Details from './components/Passenger_Details';
import ScheduledFlight from './components/ScheduledFlight';
import Ticket from './components/Ticket';
import User from './components/User';

function App() {
  return (
    <Router>
      <div className="App">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/about" element={<About />} />
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register/>} />
          <Route path="/admin-dashboard" element={<AdminDashboard/>} />
          <Route path="/add-flight" element={<AddFlight />} />
          <Route path="/add-fare" element={<AddFare />} />
          <Route path="/admin-user" element={<AdminUser />} />
          <Route path="/user-dashboard" element={<UserDashboard/>} />
          <Route path="/User-airpote" element={<Airport/>} />
          <Route path='/Flight' element={<Flight/>}/>
          <Route path='/booking' element={<BookedFlights/>}/>
          <Route path='/Airport' element={<Airport/>}/>
          <Route path='/passenger-details' element={<Passenger_Details/>}/>
          <Route path='/schedule-flight' element={<ScheduledFlight/>}/>
          <Route path='/Ticket' element={<Ticket/>}/>
          <Route path='/User' element={<User/>}/>

        </Routes>
      </div>
    </Router>
  );
}

export default App;
