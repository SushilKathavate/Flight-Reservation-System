import React, { useState, useEffect } from 'react';
import './Flight.css';
import UserHeader from './UserHeader';

const Flight = () => {
    const [flights, setFlights] = useState([]);
    const [newFlight, setNewFlight] = useState({ carrierName: '', flightModel: '', seatCapacity: '' });
    const [editFlight, setEditFlight] = useState(null);

    useEffect(() => {
        fetchFlights();
    }, []);

    const fetchFlights = async () => {
        const response = await fetch('http://localhost:9082/flight/allFlight');
        const data = await response.json();
        setFlights(data);
    };

    const addFlight = async () => {
        await fetch('http://localhost:9082/flight/addFlight', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newFlight)
        });
        fetchFlights();
        setNewFlight({ carrierName: '', flightModel: '', seatCapacity: '' });
    };

    const updateFlight = async () => {
        await fetch('http://localhost:9082/flight/updateFlight', {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(editFlight)
        });
        fetchFlights();
        setEditFlight(null);
    };

    const deleteFlight = async (flightNo) => {
        await fetch(`http://localhost:9082/flight/deleteFlight/${flightNo}, {
            method: 'DELETE'
        }`);
        fetchFlights();
    };

    const handleChange = (e) => {
        const { name, value } = e.target;
        if (editFlight) {
            setEditFlight({ ...editFlight, [name]: value });
        } else {
            setNewFlight({ ...newFlight, [name]: value });
        }
    };

    return (
        <div>
            <UserHeader/>
        <div className="flight-container">
            <h1>Flight Management</h1>
            <div className="flight-form">
                <h2>{editFlight ? 'Edit Flight' : 'Add New Flight'}</h2>
                <input
                    type="text"
                    name="carrierName"
                    placeholder="Carrier Name"
                    value={editFlight ? editFlight.carrierName : newFlight.carrierName}
                    onChange={handleChange}
                />
                <input
                    type="text"
                    name="flightModel"
                    placeholder="Flight Model"
                    value={editFlight ? editFlight.flightModel : newFlight.flightModel}
                    onChange={handleChange}
                />
                <input
                    type="number"
                    name="seatCapacity"
                    placeholder="Seat Capacity"
                    value={editFlight ? editFlight.seatCapacity : newFlight.seatCapacity}
                    onChange={handleChange}
                />
                <button onClick={editFlight ? updateFlight : addFlight}>
                    {editFlight ? 'Update Flight' : 'Add Flight'}
                </button>
            </div>

            <div className="flight-list">
                <h2>All Flights</h2>
                <table>
                    <thead>
                        <tr>
                            <th>Flight No</th>
                            <th>Carrier Name</th>
                            <th>Flight Model</th>
                            <th>Seat Capacity</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {flights.map((flight) => (
                            <tr key={flight.flightNo}>
                                <td>{flight.flightNo}</td>
                                <td>{flight.carrierName}</td>
                                <td>{flight.flightModel}</td>
                                <td>{flight.seatCapacity}</td>
                                <td>
                                    <button onClick={() => setEditFlight(flight)}>Edit</button>
                                    <button onClick={() => deleteFlight(flight.flightNo)}>Delete</button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
        </div>
    );
};

export default Flight;