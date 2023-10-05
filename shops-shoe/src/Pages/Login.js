import React, { useState } from "react";
import { useNavigate } from 'react-router-dom';
import "./login.css"

import AuthService from "../Service/auth-service"


function Login() {

    let navigate = useNavigate();

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [message, setMessage] = useState("");

    const onChangeUsername = (e) => {
        const username = e.target.value;
        setUsername(username);
    };

    const onChangePassword = (e) => {
        const password = e.target.value;
        setPassword(password);
    };
    const handleLogin = (e) => {
        e.preventDefault();
        AuthService.login(username, password).then(
            () => {
                navigate("/");
                window.location.reload();
            },
            (error) => {
                const resMessage =
                    (error.response &&
                        error.response.data &&
                        error.response.data.message) ||
                    error.message ||
                    error.toString();

                setMessage(resMessage);
            }
        );
    };
    return (
        <>
            <div class="sidenav">
                <div class="login-main-text">
                    <h2>Application Login Page</h2>
                    <p>Login or register from here to access.</p>
                </div>
            </div>
            <div class="main">
                <div class="col-md-6 col-sm-12">
                    <div class="login-form">
                        <form>
                            <div class="form-group">
                                <label>User Name</label>
                                <input type="text"
                                    class="form-control"
                                    placeholder="User Name"
                                    name="username"
                                    value={username}
                                    onChange={onChangeUsername}
                                />
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <input type="password"
                                    class="form-control"
                                    placeholder="Password" name="password"
                                    value={password}
                                    onChange={onChangePassword}
                                />
                            </div>
                            <button type="submit" class="btn btn-dark" onClick={handleLogin}>Login</button>
                            <button type="submit" class="btn btn-secondary">Register</button>
                            {message && (
                                <div className="form-group" style={{marginTop:5+'px'}}>
                                    <div className="alert alert-danger" role="alert">
                                        {message}
                                    </div>
                                </div>
                            )}
                        </form>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Login;
