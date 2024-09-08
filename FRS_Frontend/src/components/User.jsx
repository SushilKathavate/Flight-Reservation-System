import React, { useState, useEffect } from 'react';
import './User.css';
import UserHeader from './UserHeader';

const User = () => {
    const [users, setUsers] = useState([]);
    const [newUser, setNewUser] = useState({
        userId: '',
        userName: '',
        userPassword: '',
        userPhone: '',
        userEmail: '',
        userType: ''
    });
    const [searchId, setSearchId] = useState('');
    const [selectedUser, setSelectedUser] = useState(null);

    useEffect(() => {
        fetchUsers();
    }, []);

    const fetchUsers = async () => {
        const response = await fetch('http://localhost:9082/user/readAllUsers');
        const data = await response.json();
        setUsers(data);
    };

    const addUser = async () => {
        await fetch('http://localhost:9082/user/createUser', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newUser)
        });
        fetchUsers();
        resetForm();
    };

    const updateUser = async () => {
        await fetch('http://localhost:9082/user/updateUser', {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(selectedUser)
        });
        fetchUsers();
        resetForm();
    };

    const deleteUser = async (id) => {
        await fetch(`http://localhost:9082/user/deleteUser/${id}, {
            method: 'DELETE'
        }`);
        fetchUsers();
    };

    const searchUserById = async () => {
        const response = await fetch(`http://localhost:9082/user/searchUser/${searchId}`);
        const data = await response.json();
        setSelectedUser(data);
    };

    const handleChange = (e) => {
        const { name, value } = e.target;
        setNewUser({ ...newUser, [name]: value });
    };

    const handleSelectedUserChange = (e) => {
        const { name, value } = e.target;
        setSelectedUser({ ...selectedUser, [name]: value });
    };

    const resetForm = () => {
        setNewUser({
            userId: '',
            userName: '',
            userPassword: '',
            userPhone: '',
            userEmail: '',
            userType: ''
        });
        setSelectedUser(null);
        setSearchId('');
    };

    return (
        <div>
            <UserHeader/>
        <div className="user-container">
            <h1>User Management</h1>

            <div className="user-form">
                <h2>Add New User</h2>
                <input
                    type="text"
                    name="userId"
                    placeholder="User ID"
                    value={newUser.userId}
                    onChange={handleChange}
                />
                <input
                    type="text"
                    name="userName"
                    placeholder="User Name"
                    value={newUser.userName}
                    onChange={handleChange}
                />
                <input
                    type="password"
                    name="userPassword"
                    placeholder="User Password"
                    value={newUser.userPassword}
                    onChange={handleChange}
                />
                <input
                    type="text"
                    name="userPhone"
                    placeholder="User Phone"
                    value={newUser.userPhone}
                    onChange={handleChange}
                />
                <input
                    type="email"
                    name="userEmail"
                    placeholder="User Email"
                    value={newUser.userEmail}
                    onChange={handleChange}
                />
                <input
                    type="text"
                    name="userType"
                    placeholder="User Type"
                    value={newUser.userType}
                    onChange={handleChange}
                />
                <button onClick={addUser}>Add User</button>
            </div>

            <div className="user-search">
                <h2>Search User</h2>
                <input
                    type="text"
                    placeholder="Enter User ID"
                    value={searchId}
                    onChange={(e) => setSearchId(e.target.value)}
                />
                <button onClick={searchUserById}>Search</button>
            </div>

            {selectedUser && (
                <div className="user-update-form">
                    <h2>Update User</h2>
                    <input
                        type="text"
                        name="userId"
                        placeholder="User ID"
                        value={selectedUser.userId}
                        readOnly
                    />
                    <input
                        type="text"
                        name="userName"
                        placeholder="User Name"
                        value={selectedUser.userName}
                        onChange={handleSelectedUserChange}
                    />
                    <input
                        type="password"
                        name="userPassword"
                        placeholder="User Password"
                        value={selectedUser.userPassword}
                        onChange={handleSelectedUserChange}
                    />
                    <input
                        type="text"
                        name="userPhone"
                        placeholder="User Phone"
                        value={selectedUser.userPhone}
                        onChange={handleSelectedUserChange}
                    />
                    <input
                        type="email"
                        name="userEmail"
                        placeholder="User Email"
                        value={selectedUser.userEmail}
                        onChange={handleSelectedUserChange}
                    />
                    <input
                        type="text"
                        name="userType"
                        placeholder="User Type"
                        value={selectedUser.userType}
                        onChange={handleSelectedUserChange}
                    />
                    <button onClick={updateUser}>Update User</button>
                </div>
            )}

            <div className="user-list">
                <h2>All Users</h2>
                <table>
                    <thead>
                        <tr>
                            <th>User ID</th>
                            <th>User Name</th>
                            <th>User Email</th>
                            <th>User Phone</th>
                            <th>User Type</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {users.map((user) => (
                            <tr key={user.userId}>
                                <td>{user.userId}</td>
                                <td>{user.userName}</td>
                                <td>{user.userEmail}</td>
                                <td>{user.userPhone}</td>
                                <td>{user.userType}</td>
                                <td>
                                    <button onClick={() => deleteUser(user.userId)}>Delete</button>
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

export default User;