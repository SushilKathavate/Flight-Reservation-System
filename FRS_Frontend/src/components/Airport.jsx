import React, { useState, useEffect } from 'react';
import './Airport.css';
import UserHeader from './UserHeader';

const AirportComponent = () => {
    const [airports, setAirports] = useState([]);
    const [newAirport, setNewAirport] = useState({ airportName: '', airportLocation: '', airportCode: '' });
    const [editAirport, setEditAirport] = useState(null);

    useEffect(() => {
        fetchAirports();
    }, []);

    const fetchAirports = async () => {
        const response = await fetch('http://localhost:9082/airport/allAirport');
        const data = await response.json();
        setAirports(data);
    };

    const addAirport = async () => {
        await fetch('http://localhost:9082/airport/addAirport', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newAirport)
        });
        fetchAirports();
        setNewAirport({ airportName: '', airportLocation: '', airportCode: '' });
    };

    const updateAirport = async () => {
        await fetch('http://localhost:9082/airport/updateAirport', {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(editAirport)
        });
        fetchAirports();
        setEditAirport(null);
    };

    const deleteAirport = async (airportCode) => {
        await fetch(`http://localhost:9082/airport/deleteAirport/${airportCode}, {
            method: 'DELETE'
        }`);
        fetchAirports();
    };

    const handleChange = (e) => {
        const { name, value } = e.target;
        if (editAirport) {
            setEditAirport({ ...editAirport, [name]: value });
        } else {
            setNewAirport({ ...newAirport, [name]: value });
        }
    };

    return (
       <div>
        <UserHeader />
        <div className="airport-container">
          
            <h1>Airport Management</h1>
            <div className="airport-form">
                <h2>{editAirport ? 'Edit Airport' : 'Add New Airport'}</h2>
                <input
                    type="text"
                    name="airportName"
                    placeholder="Airport Name"
                    value={editAirport ? editAirport.airportName : newAirport.airportName}
                    onChange={handleChange}
                />
                <input
                    type="text"
                    name="airportLocation"
                    placeholder="Airport Location"
                    value={editAirport ? editAirport.airportLocation : newAirport.airportLocation}
                    onChange={handleChange}
                />
                <input
                    type="text"
                    name="airportCode"
                    placeholder="Airport Code"
                    value={editAirport ? editAirport.airportCode : newAirport.airportCode}
                    onChange={handleChange}
                    disabled={!!editAirport} // Disable airport code input when editing
                />
                <button onClick={editAirport ? updateAirport : addAirport}>
                    {editAirport ? 'Update Airport' : 'Add Airport'}
                </button>
            </div>

            <div className="airport-list">
                <h2>All Airports</h2>
                <table>
                    <thead>
                        <tr>
                            <th>Airport Code</th>
                            <th>Airport Name</th>
                            <th>Airport Location</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {airports.map((airport) => (
                            <tr key={airport.airportCode}>
                                <td>{airport.airportCode}</td>
                                <td>{airport.airportName}</td>
                                <td>{airport.airportLocation}</td>
                                <td>
                                    <button onClick={() => setEditAirport(airport)}>Edit</button>
                                    <button onClick={() => deleteAirport(airport.airportCode)}>Delete</button>
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

export default AirportComponent;