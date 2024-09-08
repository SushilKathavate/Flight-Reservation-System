import React, { useState, useEffect } from 'react';
import './AdminUser.css';
import AdminHeader from './AdminHeader';

const AdminUser = () => {
    const [users, setUsers] = useState([]);
    const [newUser, setNewUser] = useState({
        firstName: '',
        lastName: '',
        email: '',
        role: ''
    });

    const fetchUsers = async () => {
        const response = await fetch('/api/users');
        const data = await response.json();
        setUsers(data);
    };

    useEffect(() => {
        fetchUsers();
    }, []);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setNewUser({ ...newUser, [name]: value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        const response = await fetch('/api/users', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newUser)
        });

        if (response.ok) {
            fetchUsers();
            setNewUser({
                firstName: '',
                lastName: '',
                email: '',
                role: ''
            });
        }
    };

    const handleDelete = async (id) => {
        const response = await fetch(`/api/users/${id}`, {
            method: 'DELETE'
        });

        if (response.ok) {
            fetchUsers();
        }
    };

    return (
        <div>
            <AdminHeader/>
        <div className="users-container">
            <h2>Users</h2>
            <form onSubmit={handleSubmit} className="user-form">
                <input
                    type="text"
                    name="firstName"
                    placeholder="First Name"
                    value={newUser.firstName}
                    onChange={handleChange}
                />
                <input
                    type="text"
                    name="lastName"
                    placeholder="Last Name"
                    value={newUser.lastName}
                    onChange={handleChange}
                />
                <input
                    type="email"
                    name="email"
                    placeholder="Email"
                    value={newUser.email}
                    onChange={handleChange}
                />
                <input
                    type="text"
                    name="role"
                    placeholder="Role"
                    value={newUser.role}
                    onChange={handleChange}
                />
                <button type="submit">Add User</button>
            </form>

            <div className="users-list">
                {users.map(user => (
                    <div key={user.id} className="user-item">
                        <h3>{user.firstName} {user.lastName}</h3>
                        <p>Email: {user.email}</p>
                        <p>Role: {user.role}</p>
                        <button onClick={() => handleDelete(user.id)}>Delete</button>
                    </div>
                ))}
            </div>
        </div>
        </div>
    );
};

export default AdminUser;