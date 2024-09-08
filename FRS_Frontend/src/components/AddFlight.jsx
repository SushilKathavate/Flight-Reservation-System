import React, { useState, useEffect } from 'react';
import './AddFlight.css';
import AdminHeader from './AdminHeader';

const AddFlight = () => {
    const [flights, setFlights] = useState([]);
    const [newFlight, setNewFlight] = useState({
        flightNumber: '',
        departure: '',
        arrival: '',
        origin: '',
        destination: '',
        capacity: 0,
        fares: []
    });

    const fetchFlights = async () => {
        const response = await fetch('/api/flights');
        const data = await response.json();
        setFlights(data);
    };

    useEffect(() => {
        fetchFlights();
    }, []);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setNewFlight({ ...newFlight, [name]: value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        const response = await fetch('/api/flights', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newFlight)
        });

        if (response.ok) {
            fetchFlights();
            setNewFlight({
                flightNumber: '',
                departure: '',
                arrival: '',
                origin: '',
                destination: '',
                capacity: 0,
                fares: []
            });
        }
    };

    const handleDelete = async (id) => {
        const response = await fetch(`/api/flights/${id}, {
            method: 'DELETE'
        }`);

        if (response.ok) {
            fetchFlights();
        }
    };

    return (
      <div>
        <AdminHeader/>
        <div className="flights-container">
            <h2>Flights</h2>
            <form onSubmit={handleSubmit} className="flight-form">
                <input
                    type="text"
                    name="flightNumber"
                    placeholder="Flight Number"
                    value={newFlight.flightNumber}
                    onChange={handleChange}
                />
                <input
                    type="datetime-local"
                    name="departure"
                    placeholder="Departure"
                    value={newFlight.departure}
                    onChange={handleChange}
                />
                <input
                    type="datetime-local"
                    name="arrival"
                    placeholder="Arrival"
                    value={newFlight.arrival}
                    onChange={handleChange}
                />
                <input
                    type="text"
                    name="origin"
                    placeholder="Origin"
                    value={newFlight.origin}
                    onChange={handleChange}
                />
                <input
                    type="text"
                    name="destination"
                    placeholder="Destination"
                    value={newFlight.destination}
                    onChange={handleChange}
                />
                <input
                    type="number"
                    name="capacity"
                    placeholder="Capacity"
                    value={newFlight.capacity}
                    onChange={handleChange}
                />
                {/* Add fields for fares if needed */}
                <button type="submit">Add Flight</button>
            </form>

            <div className="flights-list">
                {flights.map(flight => (
                    <div key={flight.id} className="flight-item">
                        <h3>{flight.flightNumber}</h3>
                        <p>From: {flight.origin} To: {flight.destination}</p>
                        <p>Departure: {new Date(flight.departure).toLocaleString()}</p>
                        <p>Arrival: {new Date(flight.arrival).toLocaleString()}</p>
                        <p>Capacity: {flight.capacity}</p>
                        <button onClick={() => handleDelete(flight.id)}>Delete</button>
                    </div>
                ))}
            </div>
        </div>
        </div>
    );
};

export default AddFlight;