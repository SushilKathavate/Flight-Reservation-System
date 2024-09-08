import React, { useState, useEffect } from 'react';
import './Passenger_Details.css';
import UserHeader from './UserHeader';

const Passenger_Details = () => {
    const [passengers, setPassengers] = useState([]);
    const [newPassenger, setNewPassenger] = useState({
        pnrNumber: '',
        passengerName: '',
        passengerAge: '',
        passengerUIN: '',
        luggage: ''
    });
    const [editPassenger, setEditPassenger] = useState(null);

    useEffect(() => {
        fetchPassengers();
    }, []);

    const fetchPassengers = async () => {
        const response = await fetch('http://localhost:9082/passenger/allPassengers');
        const data = await response.json();
        setPassengers(data);
    };

    const addPassenger = async () => {
        await fetch('http://localhost:9082/passenger/addPassenger', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newPassenger)
        });
        fetchPassengers();
        setNewPassenger({
            pnrNumber: '',
            passengerName: '',
            passengerAge: '',
            passengerUIN: '',
            luggage: ''
        });
    };

    const updatePassenger = async () => {
        await fetch('http://localhost:9082/passenger/updatePassenger', {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(editPassenger)
        });
        fetchPassengers();
        setEditPassenger(null);
    };

    const deletePassenger = async (pnrNumber) => {
        await fetch(`http://localhost:9082/passenger/deletePassenger/${pnrNumber}, {
            method: 'DELETE'
        }`);
        fetchPassengers();
    };

    const handleChange = (e) => {
        const { name, value } = e.target;
        if (editPassenger) {
            setEditPassenger({ ...editPassenger, [name]: value });
        } else {
            setNewPassenger({ ...newPassenger, [name]: value });
        }
    };

    return (
        <div>
            <UserHeader/>
        <div className="passenger-container">
            <h1>Passenger Management</h1>
            <div className="passenger-form">
                <h2>{editPassenger ? 'Edit Passenger' : 'Add New Passenger'}</h2>
                <input
                    type="text"
                    name="pnrNumber"
                    placeholder="PNR Number"
                    value={editPassenger ? editPassenger.pnrNumber : newPassenger.pnrNumber}
                    onChange={handleChange}
                    disabled={!!editPassenger} // Disable PNR input when editing
                />
                <input
                    type="text"
                    name="passengerName"
                    placeholder="Passenger Name"
                    value={editPassenger ? editPassenger.passengerName : newPassenger.passengerName}
                    onChange={handleChange}
                />
                <input
                    type="number"
                    name="passengerAge"
                    placeholder="Passenger Age"
                    value={editPassenger ? editPassenger.passengerAge : newPassenger.passengerAge}
                    onChange={handleChange}
                />
                <input
                    type="text"
                    name="passengerUIN"
                    placeholder="Passenger UIN"
                    value={editPassenger ? editPassenger.passengerUIN : newPassenger.passengerUIN}
                    onChange={handleChange}
                />
                <input
                    type="number"
                    name="luggage"
                    placeholder="Luggage Weight"
                    value={editPassenger ? editPassenger.luggage : newPassenger.luggage}
                    onChange={handleChange}
                />
                <button onClick={editPassenger ? updatePassenger : addPassenger}>
                    {editPassenger ? 'Update Passenger' : 'Add Passenger'}
                </button>
            </div>

            <div className="passenger-list">
                <h2>All Passengers</h2>
                <table>
                    <thead>
                        <tr>
                            <th>PNR Number</th>
                            <th>Name</th>
                            <th>Age</th>
                            <th>UIN</th>
                            <th>Luggage (kg)</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {passengers.map((passenger) => (
                            <tr key={passenger.pnrNumber}>
                                <td>{passenger.pnrNumber}</td>
                                <td>{passenger.passengerName}</td>
                                <td>{passenger.passengerAge}</td>
                                <td>{passenger.passengerUIN}</td>
                                <td>{passenger.luggage}</td>
                                <td>
                                    <button onClick={() => setEditPassenger(passenger)}>Edit</button>
                                    <button onClick={() => deletePassenger(passenger.pnrNumber)}>Delete</button>
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

export default Passenger_Details ;