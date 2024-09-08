import React, { useState, useEffect } from "react";
import axios from "axios";
import "./BookedFlights.css";
import UserHeader from "./UserHeader";

const BookedFlight = () => {
  const [bookings, setBookings] = useState([]);
  const [newBooking, setNewBooking] = useState({
    bookingDate: "",
    noOfPassengers: "",
  });

  useEffect(() => {
    fetchBookings();
  }, []);

  const fetchBookings = async () => {
    try {
      const response = await axios.get("http://localhost:9082/booking/readAllBooking");
      setBookings(response.data);
    } catch (error) {
      console.error("Error fetching bookings", error);
    }
  };

  const createBooking = async () => {
    try {
      await axios.post("http://localhost:9082/booking/createBooking", newBooking);
      fetchBookings();
      setNewBooking({ bookingDate: "", noOfPassengers: "" });
    } catch (error) {
      console.error("Error creating booking", error);
    }
  };

  const deleteBooking = async (id) => {
    try {
      await axios.delete(`http:/localhost:9082/booking/deleteBooking/${id}`);
      fetchBookings();
    } catch (error) {
      console.error("Error deleting booking", error);
    }
  };

  return (
    <div>
      <UserHeader/>
    <div className="booking-container">
      <h2>Booking Management</h2>

      <div className="create-booking">
        <h3>Create New Booking</h3>
        <input
          type="date"
          value={newBooking.bookingDate}
          onChange={(e) => setNewBooking({ ...newBooking, bookingDate: e.target.value })}
          placeholder="Booking Date"
        />
        <input
          type="number"
          value={newBooking.noOfPassengers}
          onChange={(e) => setNewBooking({ ...newBooking, noOfPassengers: e.target.value })}
          placeholder="Number of Passengers"
        />
        <button onClick={createBooking}>Create Booking</button>
      </div>

      <div className="booking-list">
        <h3>All Bookings</h3>
        <ul>
          {bookings.map((booking) => (
            <li key={booking.bookingId}>
              <span>Date: {booking.bookingDate}</span>
              <span>Passengers: {booking.noOfPassengers}</span>
              <button onClick={() => deleteBooking(booking.bookingId)}>Delete</button>
            </li>
          ))}
        </ul>
      </div>
    </div>
    </div>
  );
};

export default BookedFlight;