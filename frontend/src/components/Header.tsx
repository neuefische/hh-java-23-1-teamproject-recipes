import React from "react";
import {Link, NavLink} from "react-router-dom";

export default function Header(){

    return(
        <header className="header">
            <h1 className="header_title">Daily Recipes</h1>

            <Link className="headerLink" to='/recipe'>Recipes</Link>
            <NavLink className="headerNav" to='/recipes/add'>ADD</NavLink>
            <NavLink className="headerNav" to='/login'>Login</NavLink>

        </header>
    )
}