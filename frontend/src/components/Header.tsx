import React from "react";
import {Link, NavLink, Route, Routes} from "react-router-dom";
import LoginPage from "./LoginPage";
import ProtectedRoutes from "../ProtectedRoutes";

export default function Header(){

    return(
        <header className="header">
            <h1 className="header_title">Daily Recipes</h1>
            <Link className="headerLink" to='/recipes'>Recipes</Link>
            <NavLink className="headerNav" to='/recipes/add'>Add Recipe</NavLink>
            <NavLink className="headerNav" to='/login'>Login</NavLink>

        </header>
    )
}