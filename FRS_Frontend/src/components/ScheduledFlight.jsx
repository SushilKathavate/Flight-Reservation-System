import React, { useState, useEffect } from 'react';
import './ScheduledFlight.css';
import UserHeader from './UserHeader';

const ScheduledFlight = () => {
    const [scheduledFlights, setScheduledFlights] = useState([]);
    const [newScheduledFlight, setNewScheduledFlight] = useState({
        scheduleFlightId: '',
        flight: {
            flightNumber: '',
            carrierName: '',
            seatCapacity: '',
        },
        availableSeats: '',
        schedule: {
            srcAirport: '',
            dstnAirport: '',
            deptDateTime: '',
            arrDateTime: '',
        }
    });
    const [editScheduledFlight, setEditScheduledFlight] = useState(null);

    useEffect(() => {
        fetchScheduledFlights();
    }, []);

    const fetchScheduledFlights = async () => {
        const response = await fetch('http://localhost:9082/scheduledFlight/viewAll');
        const data = await response.json();
        setScheduledFlights(data);
    };

    const addScheduledFlight = async () => {
        await fetch('http://localhost:9082/scheduledFlight/add', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newScheduledFlight)
        });
        fetchScheduledFlights();
        resetForm();
    };

    const updateScheduledFlight = async () => {
        await fetch('http://localhost:9082/scheduledFlight/modify', {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(editScheduledFlight)
        });
        fetchScheduledFlights();
        setEditScheduledFlight(null);
    };

    const deleteScheduledFlight = async (scheduleFlightId) => {
        await fetch(`http://localhost:9082/scheduledFlight/delete/${scheduleFlightId}, {
            method: 'DELETE'
        }`);
        fetchScheduledFlights();
    };

    const handleChange = (e) => {
        const { name, value } = e.target;
        if (editScheduledFlight) {
            setEditScheduledFlight({ ...editScheduledFlight, [name]: value });
        } else {
            setNewScheduledFlight({ ...newScheduledFlight, [name]: value });
        }
    };

    const resetForm = () => {
        setNewScheduledFlight({
            scheduleFlightId: '',
            flight: {
                flightNumber: '',
                carrierName: '',
                seatCapacity: '',
            },
            availableSeats: '',
            schedule: {
                srcAirport: '',
                dstnAirport: '',
                deptDateTime: '',
                arrDateTime: '',
            }
        });
    };

    return (
        <div>
            <UserHeader/>
        <div className="scheduled-flight-container">
            <h1>Scheduled Flight Management</h1>
            <div className="scheduled-flight-form">
                <h2>{editScheduledFlight ? 'Edit Scheduled Flight' : 'Add New Scheduled Flight'}</h2>
                <input
                    type="text"
                    name="scheduleFlightId"
                    placeholder="Schedule Flight ID"
                    value={editScheduledFlight ? editScheduledFlight.scheduleFlightId : newScheduledFlight.scheduleFlightId}
                    onChange={handleChange}
                    disabled={!!editScheduledFlight} // Disable ID input when editing
                />
                <input
                    type="text"
                    name="flight.flightNumber"
                    placeholder="Flight Number"
                    value={editScheduledFlight ? editScheduledFlight.flight.flightNumber : newScheduledFlight.flight.flightNumber}
                    onChange={(e) => handleChange({ target: { name: 'flight.flightNumber', value: e.target.value } })}
                />
                <input
                    type="text"
                    name="flight.carrierName"
                    placeholder="Carrier Name"
                    value={editScheduledFlight ? editScheduledFlight.flight.carrierName : newScheduledFlight.flight.carrierName}
                    onChange={(e) => handleChange({ target: { name: 'flight.carrierName', value: e.target.value } })}
                />
                <input
                    type="number"
                    name="availableSeats"
                    placeholder="Available Seats"
                    value={editScheduledFlight ? editScheduledFlight.availableSeats : newScheduledFlight.availableSeats}
                    onChange={handleChange}
                />
                <input
                    type="text"
                    name="schedule.srcAirport"
                    placeholder="Source Airport"
                    value={editScheduledFlight ? editScheduledFlight.schedule.srcAirport : newScheduledFlight.schedule.srcAirport}
                    onChange={(e) => handleChange({ target: { name: 'schedule.srcAirport', value: e.target.value } })}
                />
                <input
                    type="text"
                    name="schedule.dstnAirport"
                    placeholder="Destination Airport"
                    value={editScheduledFlight ? editScheduledFlight.schedule.dstnAirport : newScheduledFlight.schedule.dstnAirport}
                    onChange={(e) => handleChange({ target: { name: 'schedule.dstnAirport', value: e.target.value } })}
                />
                <input
                    type="datetime-local"
                    name="schedule.deptDateTime"
                    placeholder="Departure Time"
                    value={editScheduledFlight ? editScheduledFlight.schedule.deptDateTime : newScheduledFlight.schedule.deptDateTime}
                    onChange={(e) => handleChange({ target: { name: 'schedule.deptDateTime', value: e.target.value } })}
                />
                <input
                    type="datetime-local"
                    name="schedule.arrDateTime"
                    placeholder="Arrival Time"
                    value={editScheduledFlight ? editScheduledFlight.schedule.arrDateTime : newScheduledFlight.schedule.arrDateTime}
                    onChange={(e) => handleChange({ target: { name: 'schedule.arrDateTime', value: e.target.value } })}
                />
                <button onClick={editScheduledFlight ? updateScheduledFlight : addScheduledFlight}>
                    {editScheduledFlight ? 'Update Scheduled Flight' : 'Add Scheduled Flight'}
                </button>
            </div>

            <div className="scheduled-flight-list">
                <h2>All Scheduled Flights</h2>
                <table>
                    <thead>
                        <tr>
                            <th>Schedule Flight ID</th>
                            <th>Flight Number</th>
                            <th>Carrier Name</th>
                            <th>Available Seats</th>
                            <th>Source Airport</th>
                            <th>Destination Airport</th>
                            <th>Departure Time</th>
                            <th>Arrival Time</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {scheduledFlights.map((flight) => (
                            <tr key={flight.scheduleFlightId}>
                                <td>{flight.scheduleFlightId}</td>
                                <td>{flight.flight.flightNumber}</td>
                                <td>{flight.flight.carrierName}</td>
                                <td>{flight.availableSeats}</td>
                                <td>{flight.schedule.srcAirport}</td>
                                <td>{flight.schedule.dstnAirport}</td>
                                <td>{flight.schedule.deptDateTime}</td>
                                <td>{flight.schedule.arrDateTime}</td>
                                <td>
                                    <button onClick={() => setEditScheduledFlight(flight)}>Edit</button>
                                    <button onClick={() => deleteScheduledFlight(flight.scheduleFlightId)}>Delete</button>
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

export default ScheduledFlight;