import React, { useState, useEffect } from 'react';
import './Ticket.css';
import UserHeader from './UserHeader';

const Ticket = () => {
    const [tickets, setTickets] = useState([]);
    const [newTicket, setNewTicket] = useState({
        ticketId: '',
        bookingDate: '',
        journeyDate: '',
        source: '',
        destination: '',
        passengers: [{ pnrNumber: '', passengerName: '', passengerAge: '', passengerUIN: '', luggage: '' }]
    });

    useEffect(() => {
        fetchTickets();
    }, []);

    const fetchTickets = async () => {
        const response = await fetch('http://localhost:9082/ticket/viewAll');
        const data = await response.json();
        setTickets(data);
    };

    const addTicket = async () => {
        await fetch('http://localhost:9082/ticket/add', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newTicket)
        });
        fetchTickets();
        resetForm();
    };

    const handleTicketChange = (e) => {
        const { name, value } = e.target;
        setNewTicket({ ...newTicket, [name]: value });
    };

    const handlePassengerChange = (e, index) => {
        const { name, value } = e.target;
        const updatedPassengers = [...newTicket.passengers];
        updatedPassengers[index] = { ...updatedPassengers[index], [name]: value };
        setNewTicket({ ...newTicket, passengers: updatedPassengers });
    };

    const addPassengerField = () => {
        setNewTicket({
            ...newTicket,
            passengers: [...newTicket.passengers, { pnrNumber: '', passengerName: '', passengerAge: '', passengerUIN: '', luggage: '' }]
        });
    };

    const removePassengerField = (index) => {
        const updatedPassengers = [...newTicket.passengers];
        updatedPassengers.splice(index, 1);
        setNewTicket({ ...newTicket, passengers: updatedPassengers });
    };

    const resetForm = () => {
        setNewTicket({
            ticketId: '',
            bookingDate: '',
            journeyDate: '',
            source: '',
            destination: '',
            passengers: [{ pnrNumber: '', passengerName: '', passengerAge: '', passengerUIN: '', luggage: '' }]
        });
    };

    return (
        <div>
            <UserHeader/>
        <div className="ticket-container">
            <h1>Ticket Management</h1>
            <div className="ticket-form">
                <h2>Add New Ticket</h2>
                <input
                    type="text"
                    name="ticketId"
                    placeholder="Ticket ID"
                    value={newTicket.ticketId}
                    onChange={handleTicketChange}
                />
                <input
                    type="date"
                    name="bookingDate"
                    placeholder="Booking Date"
                    value={newTicket.bookingDate}
                    onChange={handleTicketChange}
                />
                <input
                    type="date"
                    name="journeyDate"
                    placeholder="Journey Date"
                    value={newTicket.journeyDate}
                    onChange={handleTicketChange}
                />
                <input
                    type="text"
                    name="source"
                    placeholder="Source"
                    value={newTicket.source}
                    onChange={handleTicketChange}
                />
                <input
                    type="text"
                    name="destination"
                    placeholder="Destination"
                    value={newTicket.destination}
                    onChange={handleTicketChange}
                />

                <h3>Passengers</h3>
                {newTicket.passengers.map((passenger, index) => (
                    <div key={index} className="passenger-form">
                        <input
                            type="text"
                            name="pnrNumber"
                            placeholder="PNR Number"
                            value={passenger.pnrNumber}
                            onChange={(e) => handlePassengerChange(e, index)}
                        />
                        <input
                            type="text"
                            name="passengerName"
                            placeholder="Passenger Name"
                            value={passenger.passengerName}
                            onChange={(e) => handlePassengerChange(e, index)}
                        />
                        <input
                            type="number"
                            name="passengerAge"
                            placeholder="Passenger Age"
                            value={passenger.passengerAge}
                            onChange={(e) => handlePassengerChange(e, index)}
                        />
                        <input
                            type="text"
                            name="passengerUIN"
                            placeholder="Passenger UIN"
                            value={passenger.passengerUIN}
                            onChange={(e) => handlePassengerChange(e, index)}
                        />
                        <input
                            type="number"
                            name="luggage"
                            placeholder="Luggage"
                            value={passenger.luggage}
                            onChange={(e) => handlePassengerChange(e, index)}
                        />
                        <button onClick={() => removePassengerField(index)} disabled={newTicket.passengers.length === 1}>
                            Remove Passenger
                        </button>
                    </div>
                ))}
                <button onClick={addPassengerField}>Add Passenger</button>
                <button onClick={addTicket}>Add Ticket</button>
            </div>

            <div className="ticket-list">
                <h2>All Tickets</h2>
                <table>
                    <thead>
                        <tr>
                            <th>Ticket ID</th>
                            <th>Booking Date</th>
                            <th>Journey Date</th>
                            <th>Source</th>
                            <th>Destination</th>
                            <th>Passengers</th>
                        </tr>
                    </thead>
                    <tbody>
                        {tickets.map((ticket) => (
                            <tr key={ticket.ticketId}>
                                <td>{ticket.ticketId}</td>
                                <td>{ticket.bookingDate}</td>
                                <td>{ticket.journeyDate}</td>
                                <td>{ticket.source}</td>
                                <td>{ticket.destination}</td>
                                <td>
                                    <ul>
                                        {ticket.passengers.map((passenger) => (
                                            <li key={passenger.pnrNumber}>
                                                {passenger.passengerName} (Age: {passenger.passengerAge}, UIN: {passenger.passengerUIN}, Luggage: {passenger.luggage})
                                            </li>
                                        ))}
                                    </ul>
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

export default Ticket;