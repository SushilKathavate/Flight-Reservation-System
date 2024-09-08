import React, { useState, useEffect } from 'react';
import './AddFare.css';
import AdminHeader from './AdminHeader';

const AddFare = () => {
    const [fares, setFares] = useState([]);
    const [newFare, setNewFare] = useState({
        flightId: '',
        amount: '',
        currency: ''
    });

    const fetchFares = async () => {
        const response = await fetch('/api/fares');
        const data = await response.json();
        setFares(data);
    };

    useEffect(() => {
        fetchFares();
    }, []);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setNewFare({ ...newFare, [name]: value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        const response = await fetch('/api/fares', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newFare)
        });

        if (response.ok) {
            fetchFares();
            setNewFare({
                flightId: '',
                amount: '',
                currency: ''
            });
        }
    };

    const handleDelete = async (id) => {
        const response = await fetch(`/api/fares/${id}, {
            method: 'DELETE'
        }`);

        if (response.ok) {
            fetchFares();
        }
    };

    return (
      <div>
        <AdminHeader/>
        <div className="fares-container">
            <h2>Fares</h2>
            <form onSubmit={handleSubmit} className="fare-form">
                <input
                    type="text"
                    name="flightId"
                    placeholder="Flight ID"
                    value={newFare.flightId}
                    onChange={handleChange}
                />
                <input
                    type="number"
                    name="amount"
                    placeholder="Amount"
                    value={newFare.amount}
                    onChange={handleChange}
                />
                <input
                    type="text"
                    name="currency"
                    placeholder="Currency"
                    value={newFare.currency}
                    onChange={handleChange}
                />
                <button type="submit">Add Fare</button>
            </form>

            <div className="fares-list">
                {fares.map(fare => (
                    <div key={fare.id} className="fare-item">
                        <h3>Flight ID: {fare.flightId}</h3>
                        <p>Amount: {fare.amount} {fare.currency}</p>
                        <button onClick={() => handleDelete(fare.id)}>Delete</button>
                    </div>
                ))}
            </div>
        </div>
        </div>
    );
};

export default AddFare;