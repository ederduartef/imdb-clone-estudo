import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { useAuth } from '../contexts/AuthContext';
import './Navbar.css';

const Navbar = () => {
  const { user, isAuthenticated, logout } = useAuth();
  const navigate = useNavigate();

  const handleLogout = () => {
    logout();
    navigate('/');
  };

  return (
    <nav className="navbar">
      <div className="container">
        <Link to="/" className="navbar-brand">
          IMDB Clone
        </Link>
        
        <div className="navbar-nav">
          {isAuthenticated ? (
            <>
              <span className="navbar-user">
                Olá, {user?.username}!
              </span>
              <button onClick={handleLogout} className="btn btn-secondary">
                Sair
              </button>
            </>
          ) : (
            <>
              <Link to="/login" className="btn btn-primary">
                Entrar
              </Link>
              <Link to="/register" className="btn btn-secondary">
                Registrar
              </Link>
            </>
          )}
        </div>
      </div>
    </nav>
  );
};

export default Navbar; 