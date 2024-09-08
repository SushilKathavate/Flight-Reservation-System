import React, { useState } from 'react';
import './Booking.css';
import UserHeader from './UserHeader';

const Booking = () => {
    const [bookingDate, setBookingDate] = useState('');
    const [noOfPassengers, setNoOfPassengers] = useState(1);
    const [bookingId, setBookingId] = useState(null);

    const handleSubmit = (e) => {
        e.preventDefault();
        // Replace this URL with your actual endpoint for booking flights
        fetch('http://localhost:9082/createBooking', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                bookingDate,
                noOfPassengers,
            }),
        })
        .then(response => response.json())
        .then(data => {
            setBookingId(data.bookingId);
            alert('Booking successful!');
        })
        .catch(error => {
            console.error('Error:', error);
        });
    };

    return (
        <div>
            <UserHeader/>
        <div className="booking-form-container">
            <h2>Book Your Flight</h2>
            <form onSubmit={handleSubmit} className="booking-form">
                <label htmlFor="bookingDate">Booking Date:</label>
                <input
                    type="date"
                    id="bookingDate"
                    name="bookingDate"
                    value={bookingDate}
                    onChange={(e) => setBookingDate(e.target.value)}
                    required
                />

                <label htmlFor="noOfPassengers">Number of Passengers:</label>
                <input
                    type="number"
                    id="noOfPassengers"
                    name="noOfPassengers"
                    value={noOfPassengers}
                    onChange={(e) => setNoOfPassengers(parseInt(e.target.value))}
                    min="1"
                    required
                />

                <button type="submit">Submit Booking</button>

                {bookingId && <p>Your booking ID is: {bookingId}</p>}
            </form>
        </div>
        </div>
    );
};

export default Booking;