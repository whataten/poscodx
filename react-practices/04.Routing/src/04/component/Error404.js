import React from 'react';
import { NavLink } from 'react-router-dom';

function Error404(props) {
    return (
        <div>
            <h1>Error 404</h1>
            <h3>Not Found</h3>
            <ul>
                <li>
                    <NavLink to={'/'}>[Main]</NavLink>
                </li>
                <li>
                    <NavLink to={'/guestbook'}>[Guestbook]</NavLink>
                </li>
                <li>
                    <NavLink to={'/gallery'}>[Gallery]</NavLink>
                </li>
            </ul>
        </div>
    );
}

export default Error404;